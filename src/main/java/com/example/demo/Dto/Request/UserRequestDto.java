package com.example.demo.Dto.Request;
import com.example.demo.Entity.User;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String email;
    private String password;
    private String nickname; //id x 실제로는 id역할

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .nickname(this.nickname)
                .build();
    }
}
