package com.example.thymeLeaf20200208.model;

import com.example.thymeLeaf20200208.service.TestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/skierowanie")
public class SkierowanieController {

    SkierowanieService service;

    public SkierowanieController(SkierowanieService service) {
        this.service = service;
    }

    @GetMapping("/list") // skierowanie/list --> list-skierowanie.html
    public String listSkierowanie(Model model) {
        model.addAttribute("skierowania", service.listSkierowanie());
        return "list-skierowanie";
    }


    @GetMapping("/{id}")
    public String getSkierowanie(@PathVariable Integer id, Model model) {
    model.addAttribute("skierowanie", service.getSkierowanie(id));
    return "get-skierowanie";
    }

    @GetMapping("/dodaj")
    public String dodajSkierowanie(Model model) {
        model.addAttribute("skierowanie", new SkierowanieDoLekarza());
        return "dodaj-skierowanie";
    }

    @PostMapping("/dodaj")
    public String stworzSkierowanie(@Valid @ModelAttribute SkierowanieDoLekarza skierowanieDoLekarza, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "dodaj-skierowanie";
        }
        service.createSkierowanie(skierowanieDoLekarza);
        return "redirect:/skierowanie/list";
    }

    @GetMapping("/modyfikuj/{id}")
    public String modyfikujSkierowanie(@PathVariable Integer id, Model model) {
        model.addAttribute("skierowanie", service.getSkierowanie(id));
        return "modyfikuj-skierowanie";
    }

    @PostMapping("/modyfikuj")
    public String updateSkierowanie(@Valid @ModelAttribute SkierowanieDoLekarza skierowanieDoLekarza, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "modyfikuj-skierowanie";
        }
        service.updateskierowanie(skierowanieDoLekarza);
        return "redirect:/skierowanie/" + skierowanieDoLekarza.getId();
    }

    @GetMapping("/usun/{id}")
    public String usunSkierowanie(@PathVariable Integer id) {
        service.deleteSkierowanie(id);
        return "redirect:/skierowanie/list";
    }

    @ExceptionHandler(TestController.NotFoundException.class)
    public String notFound() {
        return "exception404";
    }




}

