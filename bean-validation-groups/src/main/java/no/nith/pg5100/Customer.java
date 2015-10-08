package no.nith.pg5100;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Customer {
    @NotNull(groups = Name.class)
    private String firstName;
    @NotNull(groups = Name.class)
    private String lastName;
    @Min(value = 18, groups = Age.class)
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
