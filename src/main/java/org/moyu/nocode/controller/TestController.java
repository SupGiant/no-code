package org.moyu.nocode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moyu.nocode.entity.SystemUser;
import org.moyu.nocode.repository.SystemUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final SystemUserRepository systemUserRepository;

    public TestController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }


    @GetMapping("/test")
    String test() throws JsonProcessingException {
        SystemUser systemUser = systemUserRepository.findAll().get(0);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(systemUser);
    }


    @GetMapping("/test2")
    String test2() throws JsonProcessingException {
        SystemUser systemUser = new SystemUser();
        systemUser.setUserName("test");
        systemUser.setPassWord("test");
        SystemUser save = systemUserRepository.save(systemUser);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(save);
    }


    @GetMapping("/test3")
    String test3() throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<SystemUser> all = systemUserRepository.findAll(pageRequest);
        return new ObjectMapper().writeValueAsString(all);
    }

    @GetMapping("/test4")
    String test4() {
        long count = systemUserRepository.count();
        return String.valueOf(count);
    }

    @GetMapping("/test5")
    String test5() throws JsonProcessingException {
        SystemUser systemUser = systemUserRepository.count2();
        return new ObjectMapper().writeValueAsString(systemUser);
    }
}
