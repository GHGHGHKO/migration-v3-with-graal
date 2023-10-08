package com.example.migrationv3withgraal.domain.repository;

import com.example.migrationv3withgraal.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByUserNickname(String userNickname);
}
