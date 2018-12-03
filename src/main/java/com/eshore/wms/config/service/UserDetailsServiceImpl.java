package com.eshore.wms.config.service;


import com.eshore.wms.pojo.User;
import com.eshore.wms.service.IRoleService;
import com.eshore.wms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


/**
 * @author lizj on 2018/9/03.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        List<String> roles = roleService.getRolesByUserId(user.getId());
        //用户无权限时给予默认权限
        if (roles.isEmpty()) {
            roles.add("role_user");
        }
        Iterator<String> iterator = roles.iterator();
        while (iterator.hasNext()) {
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }
        String password = user.getPassword();
        //这里检测的密码是数据库已经加密之后的密码
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                password, collection);
    }

}
