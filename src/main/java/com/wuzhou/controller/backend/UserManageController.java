package com.wuzhou.controller.backend;

import com.wuzhou.common.Result;
import com.wuzhou.common.ResultCode;
import com.wuzhou.pojo.User;
import com.wuzhou.util.CookieUtil;
import com.wuzhou.util.RedisShardedPool;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserManageController {

    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public Result<User> login(String userName, String password, HttpSession session, HttpServletResponse response){
        System.out.println("1." + userName + "2." + password);
        System.out.println("Login success...");
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        RedisShardedPool.initPool();
        ShardedJedisPool pool = RedisShardedPool.getPool();
        Result<User> result = new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getDesc());
        result.setData(user);
        pool.getResource().set(session.getId(), JSONObject.fromObject(user).toString());
        CookieUtil.writeToken(response, session.getId());
        return  result;
    }
}
