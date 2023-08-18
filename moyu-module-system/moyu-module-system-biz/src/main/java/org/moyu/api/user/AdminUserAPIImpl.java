package org.moyu.api.user;

import jakarta.annotation.Resource;
import org.moyu.api.user.dto.AdminUserRespDTO;
import org.moyu.convert.user.UserConvert;
import org.moyu.dal.dataobject.user.AdminUser;
import org.moyu.dal.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminUserAPIImpl implements AdminUserAPI{

    @Resource
    private AdminUserRepository adminUserRepository;


    @Override
    public AdminUserRespDTO getAdminUserByUsername(String username) {
        AdminUser adminUser = adminUserRepository.findByUsername(username);
        AdminUserRespDTO convert = UserConvert.INSTANCE.convert(adminUser);
        return convert;
    }
}
