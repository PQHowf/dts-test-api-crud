package manage.test.controller;

import manage.test.dto.UserDTO;
import manage.test.entity.User;
import manage.test.exception.UserException;
import manage.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Long id) {
        userService.softDelete(id);
        return ResponseEntity.ok("User soft deleted successfully");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User created successfully");
        } catch(UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(id, userDTO);
            return ResponseEntity.ok("User updated successfully");
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @GetMapping("/users")
    public List<User> allUser() {
        return userService.readAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id) { return userService.findById(id); }
}
