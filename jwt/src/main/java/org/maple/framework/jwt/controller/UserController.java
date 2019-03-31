package org.maple.framework.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import org.maple.framework.jwt.anno.CheckToken;
import org.maple.framework.jwt.anno.LoginToken;
import org.maple.framework.jwt.pojo.User;
import org.maple.framework.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapleins
 * @Date 2019-03-14 14:28
 * @Desc
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    @LoginToken(required = true)
    public JSONObject login(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        //此处拿着user的用户名 去数据库查询 user,此处假如查出的是realUser
        User realUser = new User();
        realUser.setId(1);
        realUser.setUserName("maple");
        realUser.setPassword("123456");
        //1.判断realUser是否为空,此处模拟，不需要判断是否为空，需要判断用户名是否相同
        if(!user.getUserName().equals(realUser.getUserName())){
            jsonObject.put("message","账号不存在");
            return jsonObject;
        }
        //2.判断密码
        if(!user.getPassword().equals(realUser.getPassword())){
            jsonObject.put("message","登录密码错误");
            return jsonObject;
        }
        //3.登录成功,给用户一个token
        String token = JwtUtil.generateToken(1000 * 60 * 60 * 12, realUser);
        jsonObject.put("token",token);
        return jsonObject;
    }

    @GetMapping("/doSth")
    @CheckToken
    public JSONObject checkToken(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","可以做些别的事情了");
        return jsonObject;
    }
}
