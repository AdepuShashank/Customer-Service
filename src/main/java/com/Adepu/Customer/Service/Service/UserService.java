package com.Adepu.Customer.Service.Service;

import com.Adepu.Customer.Service.DTO.UserDto;
import com.Adepu.Customer.Service.Mapper.UserMapper;
import com.Adepu.Customer.Service.Model.User;
import com.Adepu.Customer.Service.Repository.UserRepository;

import com.Adepu.Customer.Service.feign.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.Optional;

@Service
public class UserService
{
    private final HandlerExceptionResolver handlerExceptionResolver;
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthorizationService authorizationService;



    public UserService(UserRepository userRepository, HandlerExceptionResolver handlerExceptionResolver) {
        this.userRepository = userRepository;

        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    public User RegisterToBank(User user){

        User us = new User();

        us.setFirstName(user.getFirstName());
        us.setLastName(user.getLastName());
        us.setAge(user.getAge());
        us.setGender(user.getGender());
        us.setPhoneNumber(user.getPhoneNumber());

        user = userRepository.save(us);

        return user;
    }

    public User findById(Long id){
        Optional<User> SingleUser = userRepository.findById(id);
        User us;
        if(SingleUser.isEmpty())
            return null;
        us = SingleUser.get();
        return us;
    }

    public User findByPhoneNumber(String phoneNumber){
        Optional<User> userByNumber = userRepository.findByPhoneNumber(phoneNumber);
        return userByNumber.get();
    }

    public UserDto UpdateUserDetails(Long id , String firstName, String lastName, Long phoneNumber, int age, String gender) throws Exception
    {
        Optional<User> SingleUser = userRepository.findById(id);

        if (SingleUser.isEmpty()) {
            throw new Exception("User not found");
        } else {
            User us = SingleUser.get();

            if (firstName != null) {
                us.setFirstName(firstName);
            }
            if (lastName != null) {
                us.setLastName(lastName);
            }

            UserDto updateduser = userMapper.toUserDto(us);

            return updateduser;

        }
    }

    public User RegisterUser(String firstName, String lastName, String phoneNumber, String gender) throws Exception
    {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setGender(gender);

        userRepository.save(newUser);
        return newUser;
    }

    public String login(User user){
        String token = authorizationService.login(user);
        return token ;
    }
}
