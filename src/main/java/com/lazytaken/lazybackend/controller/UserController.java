package com.lazytaken.lazybackend.controller;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@MapperScan("com.baomidou.ant.sys.mapper")
public class UserController {
    @Autowired
    UserMapper userMapper;
//   @RequestMapping(value="/user",method= RequestMethod.POST)
//    public String contextLoads(@Param("id") Integer i) {
//       System.out.println(i);
//
//        User user = userMapper.selectById(3);
//
//        System.out.println(user);
//        return "user";
//    }
//    @RequestMapping(value="/user",method= RequestMethod.GET)
//    public String getUserData(@RequestParam("id") int i) {
//        System.out.println("username is:"+i);
//        return "Hello SpringBoot Project.";
//    }

//    @GetMapping(value = "/user/age/{age}")
//    public List<Person> personListByAge(@PathVariable("id") Integer age) {
//        return personRepository.findByAge(age);
//    }
//

    @Autowired
    private UserService userService;
//    @GetMapping("/user/{id}")
    @RequestMapping(value="/user",method= RequestMethod.GET)
    public String getWetherAccepct(@RequestParam("id") int i) {
        System.out.println("username is:"+i);
        User user = userService.getWetherAccepct(i);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
////        userMapper.insert(u);
        return user.getWetherAccept();
    }

//    public String AlterName(@RequestParam("id") int id,@RequestParam("name") String i) {
//        System.out.println("username is:"+i);
//        User user = userService.AlterName(id,i);
//        List<User> userList= new ArrayList<User>();
//        userList.add(user);
//////        userMapper.insert(u);
//        return user.getName();
//    }

//    @RequestMapping("/user")
//    @GetMapping("/json")
//    public List<User> addUser2(HttpServletRequest request) {
//        String id=request.getParameter("id");
//        System.out.println("username is:"+id);
//        UserMapper userMapper = null;
//        User u = new User(2,"1","1","1","1","1");
//        List<User> userList = new ArrayList<User>();
//        userList.add(u);
////        userMapper.insert(u);
//        return userList;
//    }


//    @Resource
//    UserMapper userMapper;
//    @PostMapping
//
//    public Result<?> save(@RequestBody User user){
////        User user1 = new User(2,"1","1","1","1","1");
//        if (user.getPassword()==null){
//            user.setPassword("123456");
//        }
//        userMapper.insert(user);
//        return Result.success();
//    }

//    @RequestMapping("/user")
//    @ResponseBody
//    public User getJsonVal(@RequestParam("id") Integer id) {
//        User user = new User();
//        user.setId(id);
//
//        return user;
//}

//    @GetMapping(value = "/user/{id}")
//    public List<User> personFindOne(@PathVariable("id") Integer id) {
//        UserServiceImpl userService=new UserServiceImpl();
//        UserMapper userMapper=new UserMapper() {
//            @Override
//            public List<User> getAllUsers() {
//                User u = new User(2,"1","1","1","1","1");
//                List<User> userList = new ArrayList<User>();
//                userList.add(u);
//                return userList;
//            }
//
//            @Override
//            public List<User> getOnesMessageById(Integer id) {
//                return null;
//            }
//        };
//        userService.setUserMapper(userMapper);
//        return userService.getAllUsers();
//    }

}

