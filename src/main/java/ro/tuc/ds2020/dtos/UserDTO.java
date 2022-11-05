package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.entities.User;

public class UserDTO {

    private String name;
    private String password;
    private boolean role;

    public UserDTO(User user){
        this.name= user.getName();
        this.password= user.getPassword();
        this.role=user.isRole();
    }

    public UserDTO(String name, String password, boolean role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
