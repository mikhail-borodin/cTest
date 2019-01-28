package com.example.cdek_test.service;


import com.example.cdek_test.domain.Task;
import com.example.cdek_test.form.AddForm;
import com.example.cdek_test.form.FindForm;
import com.example.cdek_test.form.TaskForm;
import com.example.cdek_test.mapper.TasksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TasksService implements ITasksService {

    private static final Logger log = Logger.getLogger(TasksService.class.getName());

    private final TasksMapper tasksMapper;

    @Autowired
    public TasksService(TasksMapper tasksMapper) {
        this.tasksMapper = tasksMapper;
    }

    @Override
    @Transactional
    public boolean addNew(AddForm content) {
        log.info("Received request to add new task (number = " + content.getNumber() + ")");

        if (!tasksMapper.isCanAdd(content.getNumber())) {
            log.info("Error adding task, task already added");
            return false;
        }

        Task task = new Task(content.getNumber(),
                new Timestamp(System.currentTimeMillis()), false);
        tasksMapper.addNew(task);
        log.info(task.toString() + " added successfully");

        return true;
    }

    @Override
    public List<TaskForm> findAll() {
        log.info("Received request to search all tasks");

        return castToTasksForm(tasksMapper.findAll());
    }

    @Override
    public List<TaskForm> findByNumber(FindForm content) {
        log.info("Received request to search tasks (number = " + content.getNumber() + ")");

        return castToTasksForm(tasksMapper.findByNumber(content.getNumber()));
    }

    @Override
    @Transactional
    public void setChecked(Integer id) {
        log.info("Received request to update task (id = " + id + ")");

        tasksMapper.setChecked(id);
    }

    private static List<TaskForm> castToTasksForm(List<Task> tasks) {
        List<TaskForm> tList = new ArrayList<>();

        for (Task task : tasks) {
            tList.add(new TaskForm(task.getId(), task.getNumber(),
                    task.getDate(), task.getChecked()));
        }

        return tList;
    }
}
