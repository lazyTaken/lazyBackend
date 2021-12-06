package com.lazytaken.lazybackend.controller;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        User user = userService1.AlterName(id,i);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
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
//修改用户密码
    @RequestMapping(value="/alterPassword",method= RequestMethod.GET)
    public Map<String, Object> AlterPassword(@RequestParam("id") int i, @RequestParam("password") String password) {
        System.out.println("username is:"+password);
        User user = userService.AlterPassword(i,password);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
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
////    订单存储到order表中
//    @RequestMapping(value = "/saveAllOrder",method = RequestMethod.GET)
//    public Map<String,Object> Register(@RequestParam())


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

