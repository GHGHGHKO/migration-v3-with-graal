package com.example.migrationv3withgraal.service;

import com.example.migrationv3withgraal.domain.entity.Users;
import com.example.migrationv3withgraal.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public void saveUser() {
        for (int i = 0; i < 10; i++) {
            Users users = Users.builder()
                    .userName("JohnBer" + i)
                    .isQuit(false)
                    .userNickname("Doge" + i)
                    .build();

            usersRepository.save(users);
        }
    }
}
