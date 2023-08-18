package org.moyu.dal.repository;

import org.moyu.dal.dataobject.user.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用jpa实现自动的查询
 * @author linr
 * @since 2023/8/18 10:44
 */
public interface AdminUserRepository extends JpaRepository<AdminUser,Long> {
    AdminUser findByUsername(String username);
}
