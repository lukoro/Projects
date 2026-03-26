package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }


    @Controller
    @RequestMapping("user")
    public static class GreetingController {

        private final SuperCounterServiceImpl counterServiceImpl;

        public GreetingController(SuperCounterServiceImpl counterServiceImpl) {
            this.counterServiceImpl = counterServiceImpl;
        }

        @RequestMapping(value = "/greeting")
        public String requestGreeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            counterServiceImpl.add();
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
            model.addAttribute("counter", counterServiceImpl.getCounter());
            return "greeting";
        }

        @GetMapping(value = "/greeting2")
        public String requestGreeting2(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            counterServiceImpl.add();
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
            model.addAttribute("counter", counterServiceImpl.getCounter());
            return "greeting";
        }

        @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
        public String listUsersInvoices(@PathVariable("name") String name, Model model) {
            counterServiceImpl.add();
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
            model.addAttribute("counter", counterServiceImpl.getCounter());
            return "greeting";
        }

    }
}
