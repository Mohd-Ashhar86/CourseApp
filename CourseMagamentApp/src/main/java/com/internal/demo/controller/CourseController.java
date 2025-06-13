package com.internal.demo.controller;

import com.internal.demo.model.Course;
import com.internal.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "index";
    }

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "edit-course";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course); // okay if it updates too
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/";
    }
}
