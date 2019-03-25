package com.web.Controller;

import com.domain.interfaces.handlers.IUserHandler;
import com.domain.interfaces.rest.IUserController;
import com.domain.models.User;
import com.logic.handlers.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController()
@RequestMapping("/user")
public class UserController implements IUserController {

    private IUserHandler userHandler;

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler _handler) {
        userHandler = _handler;
    }

    @GetMapping(value = "/getUser")
    @ResponseBody
    public ResponseEntity getUser(@PathParam("id") long id){
        User user = userHandler.getUser(id);
        if (user != null) {
            user.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
            user.add(linkTo(methodOn(UserController.class).checkLogin("email", "passowrd")).withSelfRel());
            return new ResponseEntity<User>(user,HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(404));
        }
    }

    @RequestMapping(value = "/CheckLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity checkLogin(@RequestParam(name = "email",required = true) String email,@RequestParam(name = "password",required = true) String password){
        User user = userHandler.Login(email,password);
        if (user != null) {
            user.add(linkTo(methodOn(UserController.class).getUser(0)).withSelfRel());
            user.add(linkTo(methodOn(UserController.class).checkLogin("email","password")).withSelfRel());
            return new ResponseEntity<User>(user,HttpStatus.valueOf(200));
        }
        return new ResponseEntity(null,HttpStatus.valueOf(401));
    }

    @Override
    public ResponseEntity create(String name, String password, String email, long wage) {
        return (ResponseEntity)userHandler.create(new User(name,password,email,wage));
    }

    @Override
    public ResponseEntity read(int id) {
        return (ResponseEntity)userHandler.read(id);
    }

    @Override
    public ResponseEntity update(String name, String password, String email, long wage) {
        return (ResponseEntity)userHandler.update(new User(name,password,email,wage));
    }

    @Override
    public ResponseEntity delete(int id) {
        return (ResponseEntity)userHandler.delete(id);
    }
}
