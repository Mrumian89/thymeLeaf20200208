package com.example.thymeLeaf20200208;


import com.example.thymeLeaf20200208.model.User;
import com.example.thymeLeaf20200208.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    public static class NotFoundException extends RuntimeException {
    }

    public class NumberFormatException extends RuntimeException {
    }


    @Autowired
    UserService userService;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
/*        List<User> users = new ArrayList<>();
        users.add(new User(1, "Anna", "Kowalska", 22));
        users.add(new User(2, "Anna", "Kowalska", 32));
        users.add(new User(3, "Anna", "Kowalska", 45));
        users.add(new User(4, "Anna", "Kowalska", 10));
        users.add(new User(5, "Anna", "Kowalska", 29));*/
        model.addAttribute("users", userService.listUsers());
        return "list-Users-view";
    }

    @GetMapping("/addUser")
        public String addUser(Model model) {
            model.addAttribute("user", new User());
            return "addUser";
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable String id, Model model) {
        int i = Integer.parseInt(id);
        User user = userService.getUser(i);
        if (user == null) {
            throw new NotFoundException();
        }
        model.addAttribute("user", user);
        return "user-details";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/addUser";
        }

        userService.createUser(user.getName(), user.getNazwisko(), user.getWiek());
        return "redirect:/listUsers";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "exception404";
    }


    public void validate(User user, BindingResult bindingResult) {
        if (user.getName() == null || user.getName().isEmpty()) {
            bindingResult.addError(new ObjectError("name", "Musisz podać imię"));
        }

        if (user.getNazwisko() == null || user.getNazwisko().isEmpty()) {
            bindingResult.addError(new ObjectError("nazwisko", "Musisz podać nazwisko"));
        }

        if (user.getWiek() < 0) {
            bindingResult.addError(new ObjectError("wiek", "Wiek nie może być ujemny"));
        }

    }
}

