package com.soft.demosoftunispring.servives;

import com.soft.demosoftunispring.entities.User;
import com.soft.demosoftunispring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void persistUser() {

        try {

            User user = new User("Petko12", "12344", "petko12@abv.bg",
                    LocalDate.of(2000, 2, 15), LocalDate.of(2012, 2, 12), 15, Boolean.FALSE);
            userRepository.saveAndFlush(user);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
