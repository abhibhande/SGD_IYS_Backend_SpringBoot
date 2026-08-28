package com.SGD.IYS_Backend.repository;

import com.SGD.IYS_Backend.entity.Announcement;
import com.SGD.IYS_Backend.entity.IYSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<IYSUser, Long> {
    IYSUser findByUsername(String username);

    boolean existsByUsername(String username);
}
