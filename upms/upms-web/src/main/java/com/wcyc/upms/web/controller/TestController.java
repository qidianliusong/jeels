package com.wcyc.upms.web.controller;

import com.wcyc.base.common.base.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping(value = "/sys/test")
public class TestController extends BaseController {


    @GetMapping("/read")
    @RequiresPermissions("sys:test:read")
    @ResponseBody
    public String testRead(){
        return "you can read";
    }

    @GetMapping("/write")
    @RequiresPermissions("sys:test:write")
    @ResponseBody
    public String testWrite(){
        return "you can write";
    }

}
