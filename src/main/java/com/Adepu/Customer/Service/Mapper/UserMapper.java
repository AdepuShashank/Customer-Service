package com.Adepu.Customer.Service.Mapper;

import com.Adepu.Customer.Service.DTO.UserDto;
import com.Adepu.Customer.Service.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userdto = new UserDto();
        userdto.setFirstName(user.getFirstName());
        userdto.setLastName(user.getLastName());
        userdto.setPhoneNumber(user.getPhoneNumber());
        userdto.setAge(user.getAge());
        userdto.setGender(user.getGender());
        return userdto;
    }
    public User toUser(UserDto userdto) {
        User user = new User();
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setPhoneNumber(userdto.getPhoneNumber());
        user.setAge(userdto.getAge());
        user.setGender(userdto.getGender());
        return user;
    }

}
