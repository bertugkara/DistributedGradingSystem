package com.distributedstudentgradingsystem.Users.Expert.Controller;


import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationServiceImpl;
import com.distributedstudentgradingsystem.Users.Expert.DTO.ExpertAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.ExpertProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Expert.Mapper.ExpertMapper;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "expert/")
public class ExpertController {
    private final ExpertService expertService;
    private final RegistrationServiceImpl<Expert> registrationService;
    private final ExpertMapper expertMapper;

    @GetMapping(value = "getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<List<PojoExpertResponseDTO>> getAllExperts() {
        List<PojoExpertResponseDTO> pojoExpertResponseDTOList =
                expertMapper.entityListToDtoList(expertService.findAllExperts());
        return new DataResult<>(pojoExpertResponseDTOList, !pojoExpertResponseDTOList.isEmpty());
    }

    @PostMapping(value = "add")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public Result addExpert(@RequestBody @Valid ExpertAddRequestDTO expertAddRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(expertMapper.dtoToEntity(expertAddRequestDTO));
    }

    @GetMapping(value = "whoAmI")
    @PreAuthorize("hasAuthority('EXPERT')")
    public DataResult<ExpertProfileResponseDTO> whoAmI(@RequestParam Long id) {
        ExpertProfileResponseDTO expertProfileResponseDTO =
                expertMapper.profileEntityToResponseDTO(expertService.whoAmI(id));
        return new DataResult<>(expertProfileResponseDTO, expertProfileResponseDTO != null);
    }

}
