package com.example.demo.Entity;

import com.example.demo.Dto.Request.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder //빌더패던쓸수있게함
@Entity
public class User extends BaseEntity{

    @Id //명시안하면 에러
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String nickname;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;  // 사용자가 작성한 게시물, 하나의 사용자가 여러 게시물 사용할 수 있으니 List로 관리

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public void update(UserRequestDto dto) {
        if (dto.getEmail() != null) this.email = dto.getEmail();
        if (dto.getPassword() != null) this.password = dto.getPassword();
        if (dto.getNickname() != null) this.nickname = dto.getNickname();
    }
}