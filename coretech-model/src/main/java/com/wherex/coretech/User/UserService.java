package com.wherex.coretech.User;

import com.wherex.coretech.Callback;
import com.wherex.coretech.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Callback> login(User credentials) {
        String login = credentials.getLogin();
        User user;
        try {
            user = getUser(login);
            if(login(credentials, user)){
                Callback callback = new Callback(user, Status.SUCCESS);
                return new ResponseEntity<>(callback, HttpStatus.OK);
            }else{
                Callback callback = new Callback(credentials, Status.FAILURE);
                return new ResponseEntity<>(callback, HttpStatus.UNAUTHORIZED);
            }
        }catch (NoSuchElementException noSuchElementException){
            Callback callback = new Callback(credentials, Status.FAILURE);
            return new ResponseEntity<>(callback, HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Callback> register(User credentials) {
        String login = credentials.getLogin();
        if(!userRepository.existsByLogin(login)){
            userRepository.save(credentials);
            Callback callback =  new Callback(credentials, Status.SUCCESS);
            return new ResponseEntity<>(callback, HttpStatus.CREATED);
        }else{
            Callback callback =  new Callback(credentials, Status.FAILURE);
            return new ResponseEntity<>(callback, HttpStatus.CONFLICT);

        }
    }

    private boolean login(User credentials, User user) {
        return user.getLogin().equals(credentials.getLogin()) && user.getPassword().equals(credentials.getPassword());
    }

    private User getUser(String login) {
        return userRepository.findByLogin(login).orElseThrow();
    }
}
