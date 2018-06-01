package com.wcyc.log.api.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wcyc.base.api.service.IBaseService;
import com.wcyc.log.api.entity.WcycLog;

/**
 * Created by chen on 2017/9/19.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public interface IWcycLogService extends IBaseService<WcycLog> {

    Page<WcycLog> testPage();

}
