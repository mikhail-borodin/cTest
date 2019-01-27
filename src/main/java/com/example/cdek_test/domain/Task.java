package com.example.cdek_test.domain;

import java.sql.Timestamp;

public class Task {
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

    public Task() {
    }

    public Task(String number, Timestamp date, Boolean checked) {
        this.number = number;
        this.date = date;
        this.checked = checked;
    }
}
