package com.lazytaken.lazybackend.controller;

import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//    判断是否为接单者
    @Autowired
    private UserService userService;
//    @GetMapping("/user/{id}")
    @RequestMapping(value="/ifAccept",method= RequestMethod.GET)
    @GetMapping("/json")
    public Map<String, Object> getWetherAccepct(@RequestParam("id") int i) {
        System.out.println("username is:"+i);
        User user = userService.getWetherAccepct(i);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
////        userMapper.insert(u);
        map.put("wetherAccept",user.getWetherAccept());
        map.put("staCode",1);
        Map<String, Object> data = new HashMap<>(3);
        data.put("data",map);
        return map;
    }
//  改昵称
    @Autowired
    private UserService userService1;
    @RequestMapping(value="/alterName",method= RequestMethod.GET)
    public Map<String, Object> AlterName(@RequestParam("id") Integer id, @RequestParam("name") String i) {

    @PostMapping("/user")
    public ResponseEntity<Boolean> simpleLogin(@RequestBody User user) throws IOException {
        User res = userService.findOnlyPhone(user.getPhone());
        if (res != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
        User user = userService1.AlterName(id,i);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }

    @PostMapping("/newuser")
    public ResponseEntity<Boolean> regieter(@RequestBody User user) throws IOException {
        if (userService.findUserById(user.getId()) != null) {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
        userService.addUser(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
//    改绑定的手机号
    @Autowired
    private UserService userService2;
    @RequestMapping(value="/alterPhone",method= RequestMethod.GET)
    public Map<String, Object> AlterPhone(@RequestParam("id") int i, @RequestParam("phone") String phone) {
        System.out.println("username is:"+phone);
        User user = userService2.AlterPhone(i,phone);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }

//    改头像

    @RequestMapping(value="/alterPhoto",method= RequestMethod.GET)
    public Map<String, Object> AlterPhoto(@RequestParam("id") int i, @RequestParam("photo") String photo) {
        System.out.println("username is:"+photo);
        User user = userService.AlterPhoto(i,photo);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
////        userMapper.insert(u);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }
//  通过手机号获取信息
    @RequestMapping(value="/selectByPhone",method= RequestMethod.GET)
    public Map<String, Object> SelectByPhone(@RequestParam("phone") String phone) {
        System.out.println("username is:"+phone);
        Map<String, Object> map = new HashMap<>(3);
        User user = userService.SelectByPhone(phone);
        if(user==null){
            map.put("staCode",0);
//            map.put("success",0);
            return map;
        }
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("photo",user.getPhoto());
        map.put("wetherAccept",user.getWetherAccept());
        map.put("staCode",1);

        return map;
    }
//  注册接单者
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public Map<String, Object> Register(@RequestParam("id") int i, @RequestParam("true_name") String name, @RequestParam("reason") String reason) {
        System.out.println("username is:"+reason);
        User user = userService.Register(i,name,reason);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }

    @PostMapping("/password")
    public ResponseEntity<Boolean> updatePassword(@RequestBody User user) throws IOException {
        if(userService.updatePassword(user) == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
}
