package com.example.cdek_test.controller;

import com.example.cdek_test.form.OrderForm;
import com.example.cdek_test.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    private ITasksService tasksService;

    @Autowired
    public MainController(ITasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/courier")
    public String courierForm(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        return "courier";
    }


    @PostMapping("/courier")
    public String addTask(@Valid @ModelAttribute("orderForm") OrderForm orderForm) {
        return tasksService.newTask(orderForm);
    }

    @GetMapping("/callcenter")
    public String getTasks(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        model.addAttribute("tasks", tasksService.findAll());
        return "callcenter";
    }

    @PostMapping("/callcenter")
    public String findTasks(@Valid @ModelAttribute("orderForm") OrderForm orderForm, Model model) {
        if (orderForm.getNumber().isEmpty()) {
            model.addAttribute("tasks", tasksService.findAll());
        }
        else {
            model.addAttribute("tasks", tasksService.findByNumber(orderForm));
        }
        return "callcenter";
    }

    @PostMapping("/checked/{id}")
    public String checkedTask(@PathVariable Integer id, Model model){
        tasksService.setChecked(id);
        model.addAttribute("tasks", tasksService.findAll());

        return "redirect:/callcenter";
    }


}
