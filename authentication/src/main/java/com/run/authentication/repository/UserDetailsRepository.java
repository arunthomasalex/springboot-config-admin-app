package com.run.authentication.repository;

import com.run.authentication.domain.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    @Query(value = "SELECT ud.* FROM user_details ud LEFT JOIN users u on u.id = ud.id and u.username = :username", nativeQuery = true)
    UserDetails findUserDetailsByUsername(String username);
}