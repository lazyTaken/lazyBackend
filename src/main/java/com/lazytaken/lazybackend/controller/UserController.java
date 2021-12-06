package com.lazytaken.lazybackend.controller;

import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList() throws IOException {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Boolean> login(String phone, String password) throws  IOException {
        User user = userService.findByPhone(phone, password);
        if (user != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Boolean> simpleLogin(@RequestBody User user) throws IOException {
        User res = userService.findOnlyPhone(user.getPhone());
        if (res != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newuser")
    public ResponseEntity<Boolean> regieter(@RequestBody User user) throws IOException {
        if (userService.findUserById(user.getId()) != null) {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
        userService.addUser(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PostMapping("/password")
    public ResponseEntity<Boolean> updatePassword(@RequestBody User user) throws IOException {
        if(userService.updatePassword(user) == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
}
