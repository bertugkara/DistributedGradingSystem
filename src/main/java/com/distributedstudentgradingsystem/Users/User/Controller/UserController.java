package com.distributedstudentgradingsystem.Users.User.Controller;


import com.distributedstudentgradingsystem.Users.User.DTO.UserResponseDTO;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.Users.User.Mapper.UserMapper;
import com.distributedstudentgradingsystem.Users.User.Service.UserService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "user/")
public class UserController {

    private final UserService<User> userService;

    @PostMapping(value = "assignActive")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result assignActive(@RequestParam Long id) {
        return userService.assignUserActive(id);
    }

    @PostMapping(value = "assignInactive")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result assignInactive(@RequestParam Long id) {
        return userService.assignUserInactive(id);
    }

    @GetMapping(value = "getAllActiveUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<List<UserResponseDTO>> getAllActiveUsers() {
        List<UserResponseDTO> userResponseDTOList = UserMapper.INSTANCE.entityListToDtoList(userService.findAllActiveUsers());
        return new DataResult<>(userResponseDTOList, !userResponseDTOList.isEmpty());
    }


    @GetMapping(value = "getAllInactiveUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<List<UserResponseDTO>> getAllInactiveUsers() {
        List<UserResponseDTO> userResponseDTOList = UserMapper.INSTANCE.entityListToDtoList(userService.findAllInactiveUsers());
        return new DataResult<>(userResponseDTOList, !userResponseDTOList.isEmpty());
    }
}
