package com.wcyc.upms.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wcyc.upms.api.entity.SysUser;
import com.wcyc.upms.api.service.ISysUserService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter(ISysUserService.class)
public class SysUserWebService {

    @Reference(version = "1.0")
    private ISysUserService sysUserService;

    public SysUser getByLoginName(String loginName) {
        return sysUserService.getByLoginName(loginName);
    }
}
