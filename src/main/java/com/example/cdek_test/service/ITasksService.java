package com.example.cdek_test.service;

import com.example.cdek_test.form.AddForm;
import com.example.cdek_test.form.FindForm;
import com.example.cdek_test.form.TaskForm;

import java.util.List;

public interface ITasksService {
    boolean addNew(AddForm order);
    List<TaskForm> findAll();
    List<TaskForm> findByNumber(FindForm order);
    void setChecked(Integer id);
}
