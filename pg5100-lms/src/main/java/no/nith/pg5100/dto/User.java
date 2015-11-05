package no.nith.pg5100.dto;

import no.nith.pg5100.dto.constraint.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    private int id;

    @NotNull
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$")
    private String email;

    @NotNull
    @ValidPassword
    private String password;

    private UserType userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
