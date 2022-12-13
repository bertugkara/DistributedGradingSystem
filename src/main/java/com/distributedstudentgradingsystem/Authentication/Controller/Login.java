package com.distributedstudentgradingsystem.Authentication.Controller;

import com.distributedstudentgradingsystem.Authentication.DTO.LoginRequestDTO;
import com.distributedstudentgradingsystem.Security.JWT.JwtResponse;
import com.distributedstudentgradingsystem.Security.JWT.JwtUtils;
import com.distributedstudentgradingsystem.Security.UserDetails.Entity.UserDetailsManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "auth/")
public class Login {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsManager userDetails = (UserDetailsManager) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(role -> role.getAuthority())
                .collect(Collectors.toList());
        /*Cookie cookie = new Cookie("token", jwt);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(cookie);*/
        return ResponseEntity.ok(
          new JwtResponse(jwt, userDetails.getUsername(), userDetails.getEmail(), userDetails.getId(), roles));
    }
}
