package com.eshore.wms.service;

import com.eshore.wms.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizj
 * @since 2018-12-03
 */
public interface IUserService extends IService<User> {

    User getByUsername(String username);
}
