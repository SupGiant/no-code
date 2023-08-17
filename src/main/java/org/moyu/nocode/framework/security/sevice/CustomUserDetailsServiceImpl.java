package org.moyu.nocode.framework.security.sevice;

import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.moyu.nocode.entity.SystemUser;
import org.moyu.nocode.repository.SystemUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SystemUserRepository systemUserRepository;

    /**
     * @param username 用户名
     * @return 返回一个用户信息
     * @throws UsernameNotFoundException 用户没有找到
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = systemUserRepository.findByUserName(username);
        if(user==null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(user.getUserName(),user.getPassWord(),new ArrayList<SimpleGrantedAuthority>());
    }
}
