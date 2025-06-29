package com.Adepu.Customer.Service.Repository;

import com.Adepu.Customer.Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);
}
