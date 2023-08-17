package org.moyu.nocode.framework.security.config;

import org.moyu.nocode.framework.security.sevice.CustomUserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义安全认证配置
 */
@EnableWebSecurity
@Configuration
public class CustomerSecurityConfiguration{

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    CustomUserDetailsServiceImpl customUserDetailsService() {
        CustomUserDetailsServiceImpl customUserDetailsService = new CustomUserDetailsServiceImpl();

        return customUserDetailsService;
    }

    /**
     * Spring Security 加密器
     * 考虑到安全性，这里采用 BCryptPasswordEncoder 加密器
     *
     * @see <a href="http://stackabuse.com/password-encoding-with-spring-security/">Password Encoding with Spring Security</a>
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
