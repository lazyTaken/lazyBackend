package com.lazytaken.lazybackend.controller;

import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
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
//@MapperScan("com.baomidou.ant.sys.mapper")
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
//    判断是否为接单者
    @RequestMapping(value="/ifAccept",method= RequestMethod.GET)
    @GetMapping("/json")
    public Map<String, Object> getWetherAccepct(@RequestParam("id") String i) {
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

    @PostMapping("/user")
    public ResponseEntity<Boolean> simpleLogin(@RequestBody User user) throws IOException {
        User res = userService.findOnlyPhone(user.getPhone());
        if (res != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

//      改昵称
    @RequestMapping(value="/alterName",method= RequestMethod.GET)
    public Map<String, Object> AlterName(@RequestParam("id") String id, @RequestParam("name") String i) {
        User user = userService.AlterName(id,i);
//        List<User> userList= new ArrayList<User>();
//        userList.add(user);
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

    @RequestMapping(value="/alterPhone",method= RequestMethod.GET)
    public Map<String, Object> AlterPhone(@RequestParam("id") String i, @RequestParam("phone") String phone) {
        System.out.println("username is:"+phone);
        User user = userService.AlterPhone(i,phone);
//        List<User> userList= new ArrayList<User>();
//        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }

//修改微信账号

    @RequestMapping(value="/alterWeixin",method= RequestMethod.GET)
    public Map<String, Object> AlterWeixin(@RequestParam("phone") String phone, @RequestParam("weixin") String weixin) {
        System.out.println("username is:"+weixin);
        User user = userService.AlterWeixin(phone,weixin);
//        List<User> userList= new ArrayList<User>();
//        userList.add(user);
////        userMapper.insert(u);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }
//修改支付宝账号
    @RequestMapping(value="/alterAlipay",method= RequestMethod.GET)
    public Map<String, Object> AlterAlipay(@RequestParam("phone") String phone, @RequestParam("alipay") String alipay) {
        User user = userService.AlterAlipay(phone,alipay);
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
            return map;
        }
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("alipay",user.getAlipay());
        map.put("weixin",user.getWeixin());
        map.put("wetherAccept",user.getWetherAccept());
        map.put("staCode",1);
        return map;
    }

//  注册接单者
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public Map<String, Object> Register(@RequestParam("id") String i, @RequestParam("true_name") String name, @RequestParam("reason") String reason) {
        System.out.println("username is:"+reason);
        User user = userService.Register(i,name,reason);
        List<User> userList= new ArrayList<User>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
    }
//修改密码
    @PostMapping("/password")
    public ResponseEntity<Boolean> updatePassword(@RequestBody User user) throws IOException {
        if(userService.updatePassword(user) == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
//后端存头像
@Autowired
private UserMapper userMapper;
@RequestMapping(value="/file",method= RequestMethod.POST)
public Map<String, Object> ImgStr(@RequestParam("file") MultipartFile file, @RequestParam("phone") String phone)throws IOException {
//    User user = new User();
//    System.out.println("+++++++++++"+phone);
    User user = userMapper.selectById(phone);
    Map<String, Object> map1 = new HashMap<>(3);
    map1.put("staCode",0);
    if (file.equals("")){return map1;}
    String casePath = "C:\\Users\\lenovo\\Desktop\\小懒代取\\lazyBackend-main\\lazyBackend-main\\image\\"+phone;
    String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    File f = new File(casePath);
    try {if (!f.exists()){f.mkdirs();}
    }catch (Exception e){ }
    String name= phone+imgFormat;
    String urlImg =casePath+"/"+name;
    System.out.println("+++++++++++"+user.getPhoto()+user.getPhone());
    UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("phone",user.getPhone());
    User user1 = new User();
    user1.setPhoto(urlImg);
    userMapper.update(user1, updateWrapper);
    Map<String, Object> map = new HashMap<>(3);
    map.put("staCode",1);
    map.put("success",1);
    return map;
}

//传图片去前端
    @RequestMapping(value = "/getImageToFront", produces = MediaType.IMAGE_PNG_VALUE,method= RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@RequestParam("phone") String phone) throws Exception{
        byte[] imageContent ;
        User user = userService.SelectByPhone(phone);
        String path = user.getPhoto();
        imageContent = fileToByte(new File(path));
        System.out.println(path);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }
    public static byte[] fileToByte(File img) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "png", baos);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        return bytes;
    }
}