package org.moyu.api.user;

import org.moyu.api.user.dto.AdminUserRespDTO;

public interface AdminUserAPI {

    AdminUserRespDTO getAdminUserByUsername(String username);
}
