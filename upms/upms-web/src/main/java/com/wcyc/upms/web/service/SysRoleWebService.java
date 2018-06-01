package com.wcyc.upms.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wcyc.upms.api.entity.SysRole;
import com.wcyc.upms.api.service.ISysRoleService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter(ISysRoleService.class)
public class SysRoleWebService {

    @Reference(version = "1.0")
    private ISysRoleService sysRoleService;

    public List<SysRole> selectRoleByUserId(Long id) {
        return sysRoleService.selectRoleByUserId(id);
    }
}
