package org.moyu.nocode.repository;

import org.moyu.nocode.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    /**
     * 这个是使用自然的sql语句的
     * @return 总数
     */
    // 可以自定义查询方法，Spring Data JPA会根据方法名自动生成查询语句
    @Query(value = """
    select count(*) from systemUser
    """, nativeQuery = true)
    long count();


    /**
     * 这个是使用jpql语句
     * @return 一个新的构建出来的对象
     */
    @Query("""
       select new SystemUser(count(*))  from SystemUser
      """)
    SystemUser count2();

    SystemUser findByUserName(String username);
}
