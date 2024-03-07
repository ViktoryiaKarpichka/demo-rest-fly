package com.example.demorestfly.services.impl;

import com.example.demorestfly.dto.UserDto;
import com.example.demorestfly.dto.UserRegistrationDto;
import com.example.demorestfly.entities.Role;
import com.example.demorestfly.entities.User;
import com.example.demorestfly.mapper.UserMapper;
import com.example.demorestfly.repositories.RoleRepository;
import com.example.demorestfly.repositories.UserRepository;
import com.example.demorestfly.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demorestfly.utils.Constants.ROLE_ADMIN;
import static com.example.demorestfly.utils.Constants.ROLE_USER;
import static com.example.demorestfly.utils.ResponseUtils.DATA_SOURCE_LOOKUP_FAILURE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
//    @Transactional
    public void saveUser(UserRegistrationDto userRegistrationDto) {
        userRegistrationDto.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        User user = userMapper.convertToEntity(userRegistrationDto);
        Optional<Role> optionalRole = roleRepository.findByName(ROLE_USER);
        if (optionalRole.isPresent()) {
            user.setRole(optionalRole.get());
            userRepository.save(user);
        } else {
            throw new DataSourceLookupFailureException(DATA_SOURCE_LOOKUP_FAILURE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean isUserExist(String userName) {
        return userRepository.findByUserName(userName).isPresent();
    }

    @Override
    public void setRoleAdmin(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            Optional<Role> optionalRole = roleRepository.findByName(ROLE_ADMIN);
            if (optionalRole.isPresent()) {
                User user = optionalUser.get();
                Role role = optionalRole.get();
                user.setRole(role);
                userRepository.save(user);
            } else {
                throw new DataSourceLookupFailureException(DATA_SOURCE_LOOKUP_FAILURE_EXCEPTION_MESSAGE);
            }
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::convertToDto)
                .toList();
    }
}
