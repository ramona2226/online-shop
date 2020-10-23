package org.fasttrackit.onlineshop.service;

import org.fasttrackit.onlineshop.domain.User;
import org.fasttrackit.onlineshop.persistance.UserRepository;
import org.fasttrackit.onlineshop.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);



    //Inversion of CControl(IoC)- design pattern
     private final UserRepository userRepository ;

    //Dependency Injection
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(SaveUserRequest request) {

        LOGGER.info("Creating User: {}" , request);

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

 return userRepository.save(user);

    }






}
