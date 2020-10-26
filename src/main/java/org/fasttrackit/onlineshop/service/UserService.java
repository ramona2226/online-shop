package org.fasttrackit.onlineshop.service;

import org.fasttrackit.onlineshop.domain.User;
import org.fasttrackit.onlineshop.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshop.persistance.UserRepository;
import org.fasttrackit.onlineshop.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



//spring bean(object controlled by spring boot)
//IoC Container(contex of all spring beans)

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

    public User getUser(long id) {

        LOGGER.info("Retrieving user{}", id);


        //optional example
////          Optional<User> userOptional = userRepository.findById(id);
//          if(userOptional.isPresent()) {
//              return userOptional.get();
//          }else {
//              throw new ResourceNotFoundException("User " + id + "does not exist");




        //    }

        return userRepository.findById(id)
                //Lambda expression
                .orElseThrow(()-> new ResourceNotFoundException(("User " + id + "does not exist")));
    }


public User updateUser(long id, SaveUserRequest request){

        LOGGER.info("Updating user {}: {}", id, request);
    User existingUser = getUser(id);

//    existingUser.setFirstName(request.getFirstName());
//    existingUser.setLastName(request.getLastName());
    BeanUtils.copyProperties(request, existingUser);

    return userRepository.save(existingUser);
}

public void deleteUser(long id) {
        LOGGER.info("Deleting user {} ", id);
        userRepository.deleteById(id);
}

}
