package com.javayh.security.repository;

import com.javayh.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author haiyang
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

    /**
     * 根据名字查询
     * @param username
     * @return
     */
    Optional<Users> findByName(String username);
}
