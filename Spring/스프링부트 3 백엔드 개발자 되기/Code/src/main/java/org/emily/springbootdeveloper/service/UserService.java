package org.emily.springbootdeveloper.service;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import lombok.RequiredArgsConstructor;
import org.emily.springbootdeveloper.domain.User;
import org.emily.springbootdeveloper.dto.AddUserRequest;
import org.emily.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}
