package group.dl.backend.application.user.service;

import org.springframework.stereotype.Service;

import group.dl.backend.application.user.dto.CreateUserDTO;
import group.dl.backend.application.user.dto.UserResponseDTO;
import group.dl.backend.application.user.mapper.UserMapper;
import group.dl.backend.domain.user.UserModel;
import group.dl.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

}
