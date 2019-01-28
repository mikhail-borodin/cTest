package com.example.cdek_test.form;

import java.sql.Timestamp;

public class TaskForm {

    private Integer id;

    private String number;

    private Timestamp date;

    private Boolean checked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public TaskForm() {
    }

    public TaskForm(Integer id, String number, Timestamp date, Boolean checked) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.checked = checked;
    }
}
