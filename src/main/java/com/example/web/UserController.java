package com.example.web;

import com.example.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    //@Autowired
    //private UserService userService;

    //    @Autowired
    //    private MyRedisTemplate myRedisTemplate;

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true,
            value = "用户的姓名", defaultValue = "zhaojigang"),
        @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码",
            defaultValue = "wangna")
    })
    @ApiResponses({
        @ApiResponse(code = 400, message = "请求参数没填好"),
        @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestHeader("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return user;
    }

    //    @RequestMapping("/testJedisCluster")
    //    public User testJedisCluster(@RequestParam("username") String username){
    //        String value =  myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX, username);
    //        if(StringUtils.isBlank(value)){
    //            myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX, username, JSON.toJSONString(getUser()));
    //            return null;
    //        }
    //        return JSON.parseObject(value, User.class);
    //    }

}