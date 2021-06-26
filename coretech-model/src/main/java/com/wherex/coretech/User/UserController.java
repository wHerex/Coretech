package com.wherex.coretech.User;

import com.wherex.coretech.Callback;
import com.wherex.coretech.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin
public class UserController {

    private List<User> users;

    @Autowired
    public UserController() {
        users = new ArrayList<>();
        users.add(new User("admin", "admin", "ADMIN"));
        users.add(new User("user", "user", "USER"));

    }

    @PostMapping("/login")
    public Callback login(@RequestBody User user) {
        if (users.contains(user)) {
            User usr = users.stream()
                    .filter(u -> u.getLogin().equals(user.getLogin()))
                    .collect(toSingleton());
            user.setPrivilege(usr.getPrivilege());
            return new Callback(user, Status.SUCCESS);
        }else{
            return new Callback(user, Status.FAILURE);
        }
    }

    @PostMapping("/register")
    public Callback register(@RequestBody User user) {
        if (!users.contains(user)) {
            users.add(user);
            return new Callback(user, Status.SUCCESS);
        } else {
            return new Callback(user, Status.FAILURE);
        }
    }

    @PostMapping("/delete/{login}")
    public void delete(@PathVariable String login) {
        users.removeIf(u -> login.equals(u.getLogin()));
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/{login}")
    public String getPrivilegeByLogin(@PathVariable String login) {
        for (User u : users) {
            if (login.equals(u.getLogin())) {
                return u.getPrivilege();
            }
        }
        return null;
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
