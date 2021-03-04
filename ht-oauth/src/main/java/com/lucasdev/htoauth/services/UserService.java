package com.lucasdev.htoauth.services;

import com.lucasdev.htoauth.entities.User;
import com.lucasdev.htoauth.feignclients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClients;

    public User findbyEmail(String email) {
        User user = userFeignClients.findByemail(email).getBody();
        if (user == null) {
            logger.error("Email not found");
            throw new IllegalArgumentException("Email not found");
        }

        logger.info("User found");

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClients.findByemail(username).getBody();
        if (user == null) {
            logger.error("Email not found");
            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("User found");

        return user;
    }
}
