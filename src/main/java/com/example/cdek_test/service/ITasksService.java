package com.example.cdek_test.service;

import com.example.cdek_test.dto.TaskDto;
import com.example.cdek_test.form.OrderForm;

import java.util.List;

public interface ITasksService {
    String newTask(OrderForm order);
    List<TaskDto> findAll();
    List<TaskDto> findByNumber(OrderForm order);
    void setChecked(Integer id);
}
