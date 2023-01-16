package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Role;
import com.HospitalMangagmentSystem.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    User findByLastAndFirst(String lastName, String firstname);

    List<User> findUserByRolesAndDepartment(Role roles, String department);

    List<User> findUserByRoles(Role roles);

    @Query("SELECT a FROM User a WHERE a.dType = ?1")
    List<User> findByName(String dType);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
