package com.santharam.get_fit.users.repository;

import com.santharam.get_fit.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);
}
