package org.moyu.controller.admin.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.moyu.service.user.AdminUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
@Tag(name = "管理后台 - 用户")
public class UserController {

    @Resource
    private AdminUserService adminUserService;

    @GetMapping("/test")
    @Operation(summary = "新增用户")
    String test(){
        boolean userTest = adminUserService.createUserTest();
        return userTest?"插入成功":"插入失败";
    }
}
