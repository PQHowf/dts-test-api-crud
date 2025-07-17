package manage.test.service;

import manage.test.dto.UserDTO;
import manage.test.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void softDelete(Long id);
    void createUser(User user);
    boolean existsByUserName(String userName);
    void updateUser(Long id, UserDTO userDTO);
    List<User> readAllUser();
    Optional<User> findById(Long id);
}
