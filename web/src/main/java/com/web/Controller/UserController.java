package com.web.Controller;

import com.domain.interfaces.IUserHandler;
import com.domain.models.User;
import com.logic.handlers.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController()
@RequestMapping("/user")
public class UserController {

    private IUserHandler userHandler;

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler _handler) {
        userHandler = _handler;
    }

    @GetMapping(value = "/getUser")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathParam("id") long id){
        User user = userHandler.getUser(id);
        user.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).checkLogin("email","passowrd")).withSelfRel());
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/CheckLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> checkLogin(@RequestParam(name = "email",required = true) String email,@RequestParam(name = "password",required = true) String password){
        User user = userHandler.Login(email,password);
        user.add(linkTo(methodOn(UserController.class).getUser(0)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).checkLogin("email","passowrd")).withSelfRel());
        if (user != null) {
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return new ResponseEntity<User>((User) null,HttpStatus.UNAUTHORIZED);
    }

    /*

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = repository.findAll();
        return users;
    }*/
}
