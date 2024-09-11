package demo.user.service.service;

import demo.user.service.dto.UserRequestDTO;
import demo.user.service.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User create(UserRequestDTO requestDTO);
    User update(Long id, UserRequestDTO requestDTO);
    User findById(Long id);
    void delete(Long id);

}
