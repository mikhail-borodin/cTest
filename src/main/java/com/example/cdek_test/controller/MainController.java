package com.example.cdek_test.controller;

import com.example.cdek_test.form.AddForm;
import com.example.cdek_test.form.FindForm;
import com.example.cdek_test.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    private final ITasksService tasksService;

    @Autowired
    public MainController(ITasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/courier")
    public String courierForm(Model model) {

        model.addAttribute("addForm", new AddForm());

        return "courier";
    }

    @PostMapping("/courier")
    public String addTask(@Valid @ModelAttribute AddForm addForm, BindingResult bindingResult, Model model) {

        if (!bindingResult.hasErrors()) {
            boolean result = tasksService.addNew(addForm);
            model.addAttribute((result) ? "resultSuccess" : "resultError", true);
        }

        return "courier";
    }

    @GetMapping("/callcenter")
    public String getTasks(Model model) {

        model.addAttribute("findForm", new AddForm());
        model.addAttribute("tasks", tasksService.findAll());

        return "callcenter";
    }

    @PostMapping(params = "find", value = "/callcenter")
    public String findTasks(@ModelAttribute FindForm findForm, Model model) {

        if (findForm.getNumber().isEmpty()) {
            model.addAttribute("tasks", tasksService.findAll());
        } else {
            model.addAttribute("tasks", tasksService.findByNumber(findForm));
        }

        return "callcenter";
    }

    @PostMapping(params = "reset", value = "/callcenter")
    public String resetFindTasks(@ModelAttribute FindForm findForm, Model model) {

        model.addAttribute("tasks", tasksService.findAll());

        return "redirect:/callcenter";
    }

    @PostMapping("callcenter/checked/{id}")
    public String checkedTask(@PathVariable Integer id, Model model) {

        tasksService.setChecked(id);
        model.addAttribute("tasks", tasksService.findAll());

        return "redirect:/callcenter";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String notFoundHandler() {
        return "error";
    }
}
