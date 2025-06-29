package com.Adepu.Customer.Service.Controller;

import com.Adepu.Customer.Service.DTO.UserDto;
import com.Adepu.Customer.Service.Model.User;
import com.Adepu.Customer.Service.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/User/id/{id}")
    public User getUserById(@PathVariable("id") Long id){
            return userService.findById(id);
    }

    @PostMapping("/registertobank")
    public User RegisterToBank(@RequestBody User userAccount){
        User us = userService.RegisterToBank(userAccount);
        return us;
    }

    @GetMapping("/User/phone/{phoneNumber}")
    public User GetUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return userService.findByPhoneNumber(phoneNumber);
    }

//    @PutMapping("/user/{id}")
//    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) throws Exception{
//    UserDto updateUser;
//    updateUser = userService.UpdateUserDetails(
//            id,
//            user.getFirstName(),
//            user.getLastName(),
//            user.getPhoneNumber(),
//            user.getAge(),
//            user.getGender()
//    );
//    return updateUser;
//    }

    @PostMapping("/login")
    public String login(@RequestBody User user) throws Exception{
        String loginUser = userService.login(user);
        return loginUser;
    }
}
