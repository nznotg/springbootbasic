package com.example.hellospring.controller;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //
    @GetMapping("hello")
    public String hello(Model model) {
        //
        model.addAttribute("data", "Hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        //
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello hello(@RequestParam("name") String name) {
        //
        Hello hello = new Hello();
        hello.setSecondName(name);

        return hello;
    }

    static class Hello {
        //
        private String firstName;
        private String secondName;

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }
    }

}



