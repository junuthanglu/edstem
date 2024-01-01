package com.junaid.userregister.controller;

import com.junaid.userregister.entity.User;
import com.junaid.userregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/")
    public String userRegister(@RequestBody User user){

        if( user.getName().isEmpty() || user.getPhone().isEmpty() )
            return "Name and Phone number are Mandatory";
        else {
            Optional<User> u = userService.findByPhone(user.getPhone());
            if(u.isPresent())
                return "Phone number already exist";
        }

        userService.save(user);

        return user.getName()+" is Saved";

    }
    @GetMapping("/")
    public List<User> Users(){
        List<User> users = userService.findAll();
        return users;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
       Optional<User> user = userService.findById(id);
       if (user.isPresent()){
           userService.deleteUser(id);
           return "deleted ";
       }else
           return "No user Found";
    }
}
