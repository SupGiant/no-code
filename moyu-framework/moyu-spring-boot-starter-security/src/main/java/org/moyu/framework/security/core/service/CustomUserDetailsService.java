package org.moyu.framework.security.core.service;

import jakarta.annotation.Resource;
import org.moyu.api.user.AdminUserAPI;
import org.moyu.api.user.dto.AdminUserRespDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * 自定义一个服务，以便按自己的需求从数据库或者缓存里面获取用户
 * 但是这个只有在spring security被设置为表单登录才可以调用
 * @author linr
 * @since 2023/8/18 9:35
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private AdminUserAPI adminUserAPI;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserRespDTO adminUserByUsername = adminUserAPI.getAdminUserByUsername(username);
        return new User(adminUserByUsername.getUsername(), adminUserByUsername.getPassword(), new ArrayList<SimpleGrantedAuthority>());
    }
}
