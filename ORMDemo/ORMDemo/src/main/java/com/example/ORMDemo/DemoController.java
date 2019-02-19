package com.example.OrmDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class DemoController {
    @Autowired
    private UserRepository repository;
    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String adress){
        User u = new User(name,adress);
        repository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }
}
