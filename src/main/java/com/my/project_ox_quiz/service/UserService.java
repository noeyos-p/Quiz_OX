package com.my.project_ox_quiz.service;

import com.my.project_ox_quiz.dto.UserDto;
import com.my.project_ox_quiz.entity.User;
import com.my.project_ox_quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void userSave(UserDto dto) {
        User user = UserDto.toDto(dto);
        userRepository.save(user);
    }

    public void userSignup(UserDto dto) {
        User user = UserDto.toDto(dto);
        user.setStatus(false);
        userRepository.save(user);
    }

    public UserDto userFindOne(String id) {
        User user = userRepository.findById(id).orElse(null);
        return UserDto.fromUserEntity(user);
    }

    public List<UserDto> userFindAll() {
        List<User> userList = userRepository.findAll();
        return userList
                .stream()
                .map(x -> UserDto.fromUserEntity(x))
                .toList();
    }

    public void userUpdate(UserDto dto) {
        User user = UserDto.toDto(dto);
        userRepository.save(user);
    }

    public void userDelete(String id) {
        userRepository.deleteById(id);
    }

    public void userApprove(String id) {
        User user = userRepository.findById(id).orElse(null);
        user.setStatus(true);
        userRepository.save(user);
    }

    public void userUnapprove(String id) {
        User user = userRepository.findById(id).orElse(null);
        user.setStatus(false);
        userRepository.save(user);
    }
}
