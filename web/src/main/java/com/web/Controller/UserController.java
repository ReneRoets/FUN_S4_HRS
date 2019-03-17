package com.web.Controller;

import com.domain.interfaces.IUserHandler;
import com.domain.models.User;
import com.logic.handlers.UserHandler;
import com.persistence.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;


@RestController()
@RequestMapping("/user")
public class UserController {
    private IUserHandler userHandler = new UserHandler();

    public UserController() {

    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathParam("id") long id){
        User user = new User("","","",1);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping(name = "/userlogin")
    public ResponseEntity<User> userlogin(String email, String password){
        User user = userHandler.Login(email,password);
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
