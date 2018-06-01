package com.wcyc.log.web.aspect;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wcyc.base.common.shiro.WcycSysUser;
import com.wcyc.base.common.util.IPUtils;
import com.wcyc.base.common.util.ServletUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.*;

@Aspect
@Component
public class WLogAspect {

    /**
     * 保存日志到数据库的线程池
     */
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("SLogAspect-Thread-%d").build();

    ExecutorService executor = new ThreadPoolExecutor(5,200,0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            threadFactory,
            new ThreadPoolExecutor.AbortPolicy());


    @Pointcut("@annotation(com.wcyc.base.common.annotation.Wlog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 获取request
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        //获取请求的ip
        String ip = IPUtils.getIpAddr(request);
        SaveLogTask saveLogTask = new SaveLogTask(point, time, ip, WcycSysUser.ShiroUser());
        //保存日志到数据库
        executor.execute(saveLogTask);

        return result;
    }


}
