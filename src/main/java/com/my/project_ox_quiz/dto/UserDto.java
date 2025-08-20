package com.my.project_ox_quiz.dto;

import com.my.project_ox_quiz.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Id
    private String id;
    @Column(nullable = false)
    private String password;
    private boolean status;
    private String info;

    public static UserDto fromUserEntity(User user) {
        return new UserDto(
                user.getId(),
                user.getPassword(),
                user.isStatus(),
                user.getInfo()
        );
    }

    public static User toDto(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setStatus(dto.isStatus());
        user.setInfo(dto.getInfo());
        return user;
    }
}
