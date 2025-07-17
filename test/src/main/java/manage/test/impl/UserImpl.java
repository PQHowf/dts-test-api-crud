package manage.test.impl;

import manage.test.dto.UserDTO;
import manage.test.entity.User;
import manage.test.exception.UserException;
import manage.test.repository.UserReponsitory;
import manage.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserReponsitory userRepon;

    @Override
    public void softDelete(Long id) {
        Optional<User> userOpt = userRepon.findById(id);
        if(userOpt.isEmpty() || userOpt.get().isStatus() == false) {
            throw new UserException("User not found!!");
        }
        int updated = userRepon.softDelete(id);
        if(updated == 0) {
            throw new UserException("Delete failed");
        }
    }

    @Override
    public void createUser(User user) {
        boolean checkExists = userRepon.existsByUserName(user.getUserName());
        if(checkExists == true) {
            throw new UserException("UserName already exists");
        }
        user.setStatus(true);
        userRepon.save(user);
    }

    @Override
    public boolean existsByUserName(String username) {
        return userRepon.existsByUserName(username);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User user = userRepon.findById(id).orElseThrow(() -> new UserException("User not found with ID: " + id));

        user.setName(userDTO.getName());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());
        user.setStatus(userDTO.isStatus());
        user.setRole(userDTO.getRole());

        userRepon.save(user);
    }

    @Override
    public List<User> readAllUser() {
        return userRepon.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepon.findById(id);
    }
}
