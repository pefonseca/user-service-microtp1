package demo.user.service.service.impl;

import demo.user.service.dto.UserRequestDTO;
import demo.user.service.entity.User;
import demo.user.service.repository.UserRepository;
import demo.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserRequestDTO requestDTO) {
        return userRepository.save(requestDTO.toEntity());
    }

    @Override
    public User update(Long id, UserRequestDTO requestDTO) {
        var userDB = findById(id);
        BeanUtils.copyProperties(requestDTO, userDB);
        return userRepository.save(userDB);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
