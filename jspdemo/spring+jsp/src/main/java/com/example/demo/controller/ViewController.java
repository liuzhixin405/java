package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Keafmd
 *
 */
@Controller
public class ViewController {

    @GetMapping("getname")
    public String getName(Model model){
        model.addAttribute("name","keafmd");
        return "name";
    }
    @GetMapping("getage")
    public String getAge(Model model){
        model.addAttribute("age",18);
        return "age";
    }
}