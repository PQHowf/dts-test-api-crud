package manage.test.service;

import manage.test.dto.UserDTO;
import manage.test.entity.User;

import java.util.List;

public interface UserService {
    void softDelete(Long id);
    void createUser(User user);
    boolean existsByUserName(String userName);
    void updateUser(Long id, UserDTO userDTO);
    List<User> readAllUser();
}
