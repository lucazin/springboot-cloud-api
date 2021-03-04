package com.lucasdev.hruser.repositories;

import com.lucasdev.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String Email);

}
