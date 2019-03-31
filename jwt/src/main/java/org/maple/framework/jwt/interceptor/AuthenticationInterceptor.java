package org.maple.framework.jwt.interceptor;

import com.auth0.jwt.JWT;
import org.maple.framework.jwt.anno.CheckToken;
import org.maple.framework.jwt.anno.LoginToken;
import org.maple.framework.jwt.pojo.User;
import org.maple.framework.jwt.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author mapleins
 * @Date 2019-03-14 14:22
 * @Desc
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //假设前端将token放在请求头中，那么我们从请求头中拿token
        String token = request.getHeader("token");
        //如果这次请求并不是映射到方法上，那么直接返回
        if(! (handler instanceof HandlerMethod)){
            return true;
        }
        //获取请求映射的方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //如果该方法有@LoginToken注解并且require为true，那么直接放行
        if(method.isAnnotationPresent(LoginToken.class)){
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if(loginToken.required()){
                return true;
            }
        }
        //需要检查token的方法
        if(method.isAnnotationPresent(CheckToken.class)){
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if(checkToken.required()){
                if(null == token && ("").equals(token)){
                    throw new RuntimeException("无token,请重新登录");
                }
                //获取 token 中的用户 id ,decode注意数据类型
                Integer id = JWT.decode(token).getClaim("id").asInt();
                //去数据库查询是否有这个用户，此处写死
                User realUser = new User();
                realUser.setId(1);
                realUser.setUserName("maple");
                realUser.setPassword("123456");
                if(id.toString().equals(realUser.getId().toString())){
                    //进行token验证
                    Boolean b = JwtUtil.verifyToken(token, realUser);
                    if(!b){
                        throw new RuntimeException("token错误，非法访问");
                    }
                }
                return true;
            }
        }
        return true;
    }
}
