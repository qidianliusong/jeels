package com.wcyc.upms.api.service;


import com.wcyc.base.api.base.vo.JsTree;
import com.wcyc.base.api.base.vo.PCAjaxVO;
import com.wcyc.base.api.service.IBaseService;
import com.wcyc.upms.api.entity.SysDict;

import java.util.List;

/**
 *
 * @author chen
 * @date 2017/9/21
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系統数据字典
 */
public interface ISysDictService extends IBaseService<SysDict> {

    void insert(String dicKey, String dicValue, Long dicPid, String type, String desc, String sort, String invalid, String path);

    boolean update(Long id, String dicKey, String dicValue, String type, String desc, String sort, String invalid);

    List<JsTree> getDictTree();


     PCAjaxVO delete(Long id);


}
