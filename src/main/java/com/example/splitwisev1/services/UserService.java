package com.example.splitwisev1.services;

import com.example.splitwisev1.dtos.UserRequestDTO;
import com.example.splitwisev1.dtos.UserResponseDTO;
import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.User;
import com.example.splitwisev1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUsersToExpense(List<User> particpants, Set<Long> keySet) {

        for (long id : keySet) {
            if (userRepository.existsById(id)) {
                particpants.add(userRepository.getById(id));
            } else {
                // Should not happen in business case and should not be added directly here, but for the same of simple build creating a user and adding to the list here
                User user = new User();
                user.setUserName("Randomly created user ");
                user.setId(id);
                user.setHashedPassword("dummyhashedpassword");
                user.setPhoneNumber("000000000000");
                particpants.add(user);
            }
        }

    }

    public User getUserById(long userCreatedBy) {
        if (userRepository.existsById(userCreatedBy)) {
            return userRepository.getById(userCreatedBy);


        }
        // throw user not found exception
        return null;

    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setUserName(userRequestDTO.getUserName());
        user.setHashedPassword(userRequestDTO.getPassword());

        userRepository.save(user);
        return new UserResponseDTO(user);
    }
}