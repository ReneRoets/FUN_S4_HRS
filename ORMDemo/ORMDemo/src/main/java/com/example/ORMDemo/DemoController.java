package com.example.ORMDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(OrmDemoApplication.class);

    @Autowired
    private UserRepository repository;


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public HttpEntity<User> addNewUser(@RequestParam(value = "name", required = true, defaultValue = "Jean paul") String name, @RequestParam(value = "adress", required = true) String adress){
        User user = new User(name,adress);
        repository.save(user);

        user.add(linkTo(methodOn(DemoController.class).addNewUser(name,adress)).withSelfRel());
        user.add(linkTo(methodOn(DemoController.class).getAllUsers()).withSelfRel());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public HttpEntity<Iterable<User>> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<User> users = repository.findAll();

        for (User user : users){
            user.add(linkTo(methodOn(DemoController.class).addNewUser("","")).withSelfRel());
            user.add(linkTo(methodOn(DemoController.class).getAllUsers()).withSelfRel());
        }

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

/*    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(com.example.ORMDemo.DemoController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }*/
}
