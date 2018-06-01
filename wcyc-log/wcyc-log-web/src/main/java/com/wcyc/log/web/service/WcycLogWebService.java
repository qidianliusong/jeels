package com.wcyc.log.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wcyc.log.api.entity.WcycLog;
import com.wcyc.log.api.service.IWcycLogService;
import org.springframework.stereotype.Service;

@Service
public class WcycLogWebService {

    @Reference(version = "1.0",check = false)
    private IWcycLogService wcycLogService;

    public boolean insert(WcycLog log){
       return wcycLogService.insert(log);
    }

}
