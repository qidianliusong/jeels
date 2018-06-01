package com.wcyc.upms.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wcyc.base.common.base.controller.BaseController;
import com.wcyc.base.common.shiro.WcycSysUser;
import com.wcyc.upms.api.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chen on 2017/7/27.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:SiteMesh 操作
 */
@Controller
public class SiteMeshController extends BaseController {

    @Reference(version = "1.0")
    private ISysMenuService sysMenuService;

    /**
     * 查询系统用户 侧边栏菜单
     * @param model
     * @param request
     * @return
     */
    @GetMapping(value = "layouts")
    public String getIndex(Model model, HttpServletRequest request) {

        model.addAttribute("slife", WcycSysUser.ShiroUser());
        model.addAttribute("menus", sysMenuService.CaseMenu(WcycSysUser.id()));

        return "layouts/default";
    }

    @PostMapping(value = "layouts")
    public String postIndex(Model model, HttpServletRequest request) {
        return getIndex( model,  request);
    }
}
