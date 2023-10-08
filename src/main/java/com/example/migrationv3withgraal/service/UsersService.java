package com.example.migrationv3withgraal.service;

import com.example.migrationv3withgraal.domain.entity.Users;
import com.example.migrationv3withgraal.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    private static final String USER_PREFIX_NAME = "JohnBer";
    private static final String USER_PREFIX_NICKNAME = "Doge";

    public void saveUser() {
        for (int i = 0; i < 10; i++) {
            Users users = Users.builder()
                    .userName(USER_PREFIX_NAME + i)
                    .isQuit(false)
                    .userNickname(USER_PREFIX_NICKNAME + i)
                    .build();

            usersRepository.save(users);
        }
    }

    public void updateQuitUser() {
        Users users = usersRepository.findByUserNickname(USER_PREFIX_NICKNAME + "1")
                .orElseThrow(IllegalArgumentException::new);
        users.updateUserNickname("Pepe");
        usersRepository.save(users);
    }
}
