package org.moyu.controller.admin.user;

import jakarta.annotation.Resource;
import org.moyu.service.user.AdminUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private AdminUserService adminUserService;

    @GetMapping("/test")
    String test(){
        boolean userTest = adminUserService.createUserTest();
        return userTest?"插入成功":"插入失败";
    }
}
