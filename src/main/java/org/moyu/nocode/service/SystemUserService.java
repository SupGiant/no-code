package org.moyu.nocode.service;

import org.moyu.nocode.entity.SystemUser;
import org.moyu.nocode.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserService {

    private final SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    public SystemUser createUser(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    public SystemUser updateUser(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    public void deleteUser(Long userId) {
        systemUserRepository.deleteById(userId);
    }

    public SystemUser findUserById(Long userId) {
        return systemUserRepository.findById(userId).orElse(null);
    }

}
