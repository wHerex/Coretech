package com.wherex.coretech.User;

import com.wherex.coretech.Callback;
import com.wherex.coretech.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin
public class UserController {

    private List<User> users;

    @Autowired
    public UserController() {
        users = List.of(
                new User("admin", "admin", "ADMIN"),
                new User("user", "user", "USER")
        );
    }

    @PostMapping
    public Callback login(@RequestBody User user) {
        if (users.contains(user))
            return new Callback(user, Status.SUCCESS);
        return new Callback(user, Status.FAILURE);
    }
}
