package org.moyu.service.user;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.moyu.dal.dataobject.user.AdminUser;
import org.moyu.dal.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService{

    @Resource
    private AdminUserRepository adminUserRepository;


    /**
     * @return 测试
     */
    @Override
    public boolean createUserTest() {
        try {
            AdminUser adminUser = new AdminUser();
            adminUser.setPassword("123465");
            adminUser.setUsername(UUID.randomUUID().toString().replace("-",""));

            adminUserRepository.save(adminUser);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
