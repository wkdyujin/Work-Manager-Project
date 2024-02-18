package com.fisa.workmanager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fisa.workmanager.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
