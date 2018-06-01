package com.wcyc.log.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wcyc.base.common.base.service.impl.BaseService;
import com.wcyc.log.api.entity.WcycLog;
import com.wcyc.log.api.service.IWcycLogService;
import com.wcyc.log.dao.WcycLogDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2017/9/19
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: slife 日志 service
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        interfaceClass = IWcycLogService.class
)
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class WcycLogService extends BaseService<WcycLogDao, WcycLog> implements IWcycLogService {

    public Page<WcycLog> testPage(){
        Page<WcycLog> page = new Page<>(1,2);
        Map<String,Object> params = new HashMap<>();
        params.put("delFlag","Y");
        List<WcycLog> wcycLogs = this.baseMapper.testPage(page, params);
        page.setRecords(wcycLogs);
        return page;
    }

}
