package com.eshore.wms.service;

import com.eshore.wms.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizj
 * @since 2018-12-03
 */
public interface IRoleService extends IService<Role> {

    List<String> getRolesByUserId(Integer id);
}
