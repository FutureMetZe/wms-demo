package com.eshore.wms.service.impl;

import com.eshore.wms.pojo.Role;
import com.eshore.wms.mapper.RoleMapper;
import com.eshore.wms.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizj
 * @since 2018-12-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


    @Override
    public List<String> getRolesByUserId(Integer id) {
        List<Role> list = this.list(null);
        List<String> roles = new ArrayList<>();
        for(Role role : list){
            roles.add(role.getRole());
        }
        return roles;
    }
}
