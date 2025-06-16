package manage.test.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private boolean status;
    private String role;
}
