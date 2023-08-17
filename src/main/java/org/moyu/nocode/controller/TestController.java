package org.moyu.nocode.controller;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moyu.nocode.entity.User;
import org.moyu.nocode.repository.UserRepository;
import org.moyu.nocode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/test")
    String test() throws JsonProcessingException {
        User user = userRepository.findAll().get(0);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(user);
    }


    @GetMapping("/test2")
    String test2() throws JsonProcessingException {
        User user = new User();
        user.setUserName("test");
        user.setPassWord("test");
        User save = userRepository.save(user);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(save);
    }


    @GetMapping("/test3")
    String test3() throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> all = userRepository.findAll(pageRequest);
        return new ObjectMapper().writeValueAsString(all);
    }

    @GetMapping("/test4")
    String test4() {
        long count = userRepository.count();
        return String.valueOf(count);
    }

    @GetMapping("/test5")
    String test5() throws JsonProcessingException {
        User user = userRepository.count2();
        return new ObjectMapper().writeValueAsString(user);
    }
}
