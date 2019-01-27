package com.example.cdek_test.service;


import com.example.cdek_test.domain.Task;
import com.example.cdek_test.dto.TaskDto;
import com.example.cdek_test.form.OrderForm;
import com.example.cdek_test.mapper.TasksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService implements ITasksService {

    private TasksMapper tasksMapper;

    @Autowired
    public TasksService(TasksMapper tasksMapper) {
        this.tasksMapper = tasksMapper;
    }

    @Override
    public String newTask(OrderForm order) {

        Task task = new Task(order.getNumber(),
                new Timestamp(System.currentTimeMillis()), false);
        tasksMapper.insert(task);

        return "courier";
    }

    @Override
    public List<TaskDto> findAll() {
        return castToTasksDto(tasksMapper.findAll());
    }

    @Override
    public List<TaskDto> findByNumber(OrderForm order) {
        return castToTasksDto(tasksMapper.findByNumber(order.getNumber()));
    }

    @Override
    public void setChecked(Integer id) {
        tasksMapper.setChecked(id);
    }

    private static List<TaskDto> castToTasksDto(List<Task> tasks) {
        List<TaskDto> tList = new ArrayList<>();

        for (Task task : tasks) {
            tList.add(new TaskDto(task.getId(), task.getNumber(), task.getDate(),task.getChecked()));
        }

        return tList;
    }
}
