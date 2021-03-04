package com.lucasdev.htoauth.feignclients;

import com.lucasdev.htoauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClients {

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByemail(@RequestParam String email);

}
