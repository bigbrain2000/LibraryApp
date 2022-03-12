package com.Ness.repository;

import com.Ness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u Where u.username = :username")
    Optional<User> getUserByUsername(@Param("username") String username);
}
