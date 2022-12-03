package com.distributedstudentgradingsystem.Security.JWT;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private String username;
    private List<String> roles;

    public JwtResponse(String token, String username,String email, Long Id, List<String> roles) {
        this.token = token;
        this.username = username;
        this.id=Id;
        this.email=email;
        this.roles = roles;
    }
}