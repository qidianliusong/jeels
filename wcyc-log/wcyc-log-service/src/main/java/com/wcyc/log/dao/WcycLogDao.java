package com.wcyc.log.dao;


import com.baomidou.mybatisplus.plugins.Page;
import com.wcyc.base.common.base.dao.CrudDao;
import com.wcyc.log.api.entity.WcycLog;

import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:  系统日志 dao
 */
public interface WcycLogDao extends CrudDao<WcycLog> {


    List<WcycLog> testPage(Page<?> page, Map<String,Object> params);


}
