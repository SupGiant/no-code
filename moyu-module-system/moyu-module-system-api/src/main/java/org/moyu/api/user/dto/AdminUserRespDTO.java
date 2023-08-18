package org.moyu.api.user.dto;

import lombok.Data;

/**
 * API使用的传输对象
 * @author linr
 * @since 2023/8/18 15:30
 */

public class AdminUserRespDTO {

    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
