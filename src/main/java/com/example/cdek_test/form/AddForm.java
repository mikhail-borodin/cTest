package com.example.cdek_test.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddForm {

    @NotNull
    @Size(min=4, max=20)
    @Pattern(regexp = "^[A-Za-z0-9]*$", message="недопустимый набор символов")
    private String number;

    public AddForm() {
    }

    public AddForm(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
