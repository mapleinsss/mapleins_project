package org.maple.framework.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.maple.framework.jwt.pojo.User;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author mapleins
 * @Date 2019-03-14 11:20
 * @Desc
 **/
public class JwtUtil {

    private static final String SECRET = "maple";

    /**
     * 用户登录成功后生成 jwt
     * 使用 HS256 算法，私钥使用 maple
     * jwt 三部分： HEADER、PAYLOAD、SIGNATURE
     * @param expireTime jwt过期时间
     * @param user 登录成功的用户对象
     * @return jwt的字符串
     */
    public static String generateToken(long expireTime, User user){
        long currentTimeMillis = System.currentTimeMillis();
        /**
         * 生成 PAYLOAD
         * iss (issuer)：签发人
         * exp (expiration time)：过期时间
         * sub (subject)：主题
         * aud (audience)：受众
         * nbf (Not Before)：生效时间
         * iat (Issued At)：签发时间
         * jti (JWT ID)：编号
         */
        Map<String,Object> claims = new HashMap<>();
        //自定义载荷
        claims.put("id",user.getId());
        claims.put("username",user.getUserName());
        claims.put("password",user.getPassword());
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置自己创建的私有声明，会覆盖标准声明
                .setClaims(claims)
                //设置jti,JWT唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //设置iat,JWT签发时间
                .setIssuedAt(new Date(currentTimeMillis))
                //设置sub,JWT的主题，存放一个json格式的字符串，可以存放用户的信息，这里我们存放在私有声明中,在主题中存放一个用户名
                .setSubject(user.getUserName())
                //设置HEADER 使用的算法，其他部分 jjwt 已经封装好了
                .signWith(SignatureAlgorithm.HS256,SECRET);
        //设置过期时间
        if(expireTime >= 0){
            jwtBuilder.setExpiration(new Date(currentTimeMillis+expireTime));
        }
        return jwtBuilder.compact();
    }

    /**
     * Token 解密
     * @param token 加密后的token
     * @param user 用户对象
     * @return
     */
    public static Claims parseToken(String token,User user){
        Claims claims = Jwts.parser()
                //设置解密的秘钥
                .setSigningKey(SECRET)
                //设置需要解析的 token
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public static Boolean verifyToken(String token,User user){
        Claims claims = parseToken(token, user);
        //此处做逻辑校验,写简单点，验证下密码就行
        if(claims.get("password").equals(user.getPassword())){
            return true;
        }
        return false;
    }

}
