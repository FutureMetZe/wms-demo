package com.eshore.wms.controller;


import com.eshore.wms.pojo.User;
import com.eshore.wms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizj
 * @since 2018-12-03
 */
@RestController
@RequestMapping("/wms/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signIn")
    private Object sing(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }


    @GetMapping("/list")
    private List<User> list(){
        return userService.list(null);
    }
}
