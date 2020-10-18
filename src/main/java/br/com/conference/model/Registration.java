package br.com.conference.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Registration {

    @NotEmpty private String firstName;
    @NotEmpty private String lastName;

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
}
