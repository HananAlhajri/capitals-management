package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.common.mapper.UserMapper;
import com.demo.capmgnmt.dto.request.NewUserRequest;
import com.demo.capmgnmt.dto.request.UpdateUserRequest;
import com.demo.capmgnmt.dto.response.UserResponse;
import com.demo.capmgnmt.entity.User;
import com.demo.capmgnmt.exception.custom.RegionNotSupportedException;
import com.demo.capmgnmt.exception.custom.UserDoesNotExistException;
import com.demo.capmgnmt.repository.RegionRepository;
import com.demo.capmgnmt.repository.RoleRepository;
import com.demo.capmgnmt.repository.UserRepository;
import com.demo.capmgnmt.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.demo.capmgnmt.common.constants.enums.RoleEnum.USER;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RegionRepository regionRepository;

    @Override
    public void createUser(NewUserRequest newUser){
        User user = userMapper.mapRequestToUser(newUser);
        user.setRegion(regionRepository.findById(newUser.getRegionId()).orElseThrow(RegionNotSupportedException::new));
        user.setRole(roleRepository.findById(USER.getId()).get());
        userRepository.save(user);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest newInfo) {
        //TODO: support updating other fields
        User toUpdate = userRepository.findById(id).orElseThrow(UserDoesNotExistException::new);

        toUpdate.setFirstName(newInfo.getFirstName());
        toUpdate.setLastName(newInfo.getLastName());
        toUpdate.setMiddleName(newInfo.getMiddleName());
        toUpdate.setRegion(regionRepository.findById(newInfo.getRegionId()).orElseThrow(RegionNotSupportedException::new));

        userRepository.save(toUpdate);

        return userMapper.mapUserToResponse(toUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(UserDoesNotExistException::new);
        userRepository.deleteById(id);
    }
}