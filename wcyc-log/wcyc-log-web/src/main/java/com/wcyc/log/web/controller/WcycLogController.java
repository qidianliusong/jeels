package com.wcyc.log.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.wcyc.base.api.base.entity.ReturnDTO;
import com.wcyc.base.api.base.vo.DataTable;
import com.wcyc.base.common.base.controller.BaseController;
import com.wcyc.base.common.util.ReturnDTOUtil;
import com.wcyc.log.api.entity.WcycLog;
import com.wcyc.log.api.service.IWcycLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chen on 2017/9/19.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: slife 日志 controller
 */
@Controller
@RequestMapping("/monitor/log")
public class WcycLogController extends BaseController {

    @Reference(version = "1.0",check = false)
    private IWcycLogService wcycLogService;


    @ApiOperation(value = "进入日志列表", notes = "进入日志列表")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath()+"/monitor/log/");
        return "log/list";
    }

    @ApiOperation(value = "获取日志列表数据", notes = "获取日志列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<WcycLog> list(@RequestBody DataTable dt, ServletRequest request) {
        return wcycLogService.pageSearch(dt);
    }

    @ApiOperation(value = "批量删除日志记录", notes = "批量删除日志记录传入日志ids")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        boolean success = wcycLogService.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }

    @GetMapping("/test.do")
    @ResponseBody
    public ReturnDTO getPage(){
        Page<WcycLog> wcycLogPage = wcycLogService.testPage();
        ReturnDTO success = ReturnDTOUtil.success();
        success.setMessage(wcycLogPage);
        return success;
    }


}
