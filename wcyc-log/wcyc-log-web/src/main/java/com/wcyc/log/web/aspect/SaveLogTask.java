package com.wcyc.log.web.aspect;

import com.alibaba.fastjson.JSON;
import com.wcyc.base.common.annotation.Wlog;
import com.wcyc.base.common.shiro.ShiroUser;
import com.wcyc.base.common.util.ApplicationContextRegister;
import com.wcyc.log.api.entity.WcycLog;
import com.wcyc.log.web.service.WcycLogWebService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 *
 * @author chen
 * @date 2017/9/19
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class SaveLogTask implements Runnable {


    private WcycLogWebService wcycLogService = ApplicationContextRegister.getBean(WcycLogWebService.class);

    private ProceedingJoinPoint joinPoint;
    private long time;
    private String ip;
    private ShiroUser currUser;

    public SaveLogTask(ProceedingJoinPoint point, long time, String ip,ShiroUser currUser) {
        this.joinPoint = point;
        this.time = time;
        this.ip = ip;
        this.currUser = currUser;
    }

    @Override
    public void run() {
        saveLog(joinPoint, time, ip,currUser);
    }

    /**
     * 保存日志 到数据库
     *
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time, String ip,ShiroUser currUser) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        WcycLog wcycLog = new WcycLog();
        Wlog wlog = method.getAnnotation(Wlog.class);

        if (wlog != null) {
            // 注解上的描述
            wcycLog.setMsg(wlog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        wcycLog.setSrc(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSON.toJSONString(args[0]);
            wcycLog.setParams(params);
        } catch (Exception e) {

        }

        // 设置IP地址
        wcycLog.setIp(ip);

        if (null == currUser) {
            if (null != wcycLog.getParams()) {
                wcycLog.setName(wcycLog.getParams());
                wcycLog.setLoginName(wcycLog.getParams());
            } else {
                wcycLog.setName("获取用户信息为空");
                wcycLog.setLoginName("获取用户信息为空");
                wcycLog.setCreateId(-1L);
            }
        } else {
            wcycLog.setName(currUser.getName());
            wcycLog.setLoginName(currUser.getUsername());

        }

        wcycLog.setUseTime(time);


        // 保存系统日志
        wcycLogService.insert(wcycLog);
    }
}
