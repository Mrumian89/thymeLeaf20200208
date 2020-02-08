package com.example.thymeLeaf20200208.service;

import com.example.thymeLeaf20200208.TestController;
import com.example.thymeLeaf20200208.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewTestController {

        public class NotFoundException extends RuntimeException {
        }

        public class NumberFormatException extends RuntimeException {
        }


        @Autowired
        UserService userService;

        @GetMapping("/listPacjents")
        public String listPacjents(Model model) {
/*        List<User> users = new ArrayList<>();
        users.add(new User(1, "Anna", "Kowalska", 22));
        users.add(new User(2, "Anna", "Kowalska", 32));
        users.add(new User(3, "Anna", "Kowalska", 45));
        users.add(new User(4, "Anna", "Kowalska", 10));
        users.add(new User(5, "Anna", "Kowalska", 29));*/
            model.addAttribute("Pacjents", userService.listUsers());
            return "list-Pacjents-view";
        }

        @GetMapping("/addPacjent")
        public String addUser(Model model) {
            model.addAttribute("Pacjent", new User());
            return "addPacjent";
        }

        @GetMapping("/getPacjent/{id}")
        public String getUser(@PathVariable String id, Model model) {
            int i = Integer.parseInt(id);
            User user = userService.getUser(i);
            if (user == null) {
                throw new com.example.thymeLeaf20200208.TestController.NotFoundException();
            }
            model.addAttribute("user", user);
            return "pacjent-details";
        }

        @PostMapping("/addPacjent")
        public String createUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
            validate(user, bindingResult);
            if (bindingResult.hasErrors()) {
                model.addAttribute("user", user);
                return "redirect:/addPacjent";
            }

            userService.createUser(user.getName(), user.getNazwisko(), user.getWiek());
            return "redirect:/listPacjents";
        }

        @ExceptionHandler(com.example.thymeLeaf20200208.TestController.NotFoundException.class)
        public String notFound() {
            return "exception404";
        }


        public void validate(User user, BindingResult bindingResult) {
            if (listPacjents().getName() == null || user.getName().isEmpty()) {
                bindingResult.addError(new ObjectError("pacjent", "Musisz podać imię"));
            }

            if (user.getNazwisko() == null || user.getNazwisko().isEmpty()) {
                bindingResult.addError(new ObjectError("lekarz", "Musisz podać nazwisko"));
            }

            if (user.getWiek() < 0) {
                bindingResult.addError(new ObjectError("termin", "Wiek nie może być ujemny"));
            }

        }
    }

