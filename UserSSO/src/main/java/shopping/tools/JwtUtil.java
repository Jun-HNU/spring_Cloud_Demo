package shopping.tools;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author yxm
 * @date 2021/3/2
 * JWT工具类
 */
public class JwtUtil{
    /**
     * Token过期时间30分钟
     */
    //public static final long EXPIRE_TIME = 30 * 60 * 1000;
    public static final long EXPIRE_TIME =7 * 24* 60 * 60 * 1000;


    /**
     * 校验Token是否正确
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            // 设置加密算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            // 效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 生成签名,30min后过期
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    /**
     *获得用户名
     * @param request
     * @return
     */
    public static String getUserNameByToken(HttpServletRequest request)  {
        String token = request.getHeader("token");
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username")
                    .asString();
        }catch (Exception e){
            e.getMessage();
        }
        return "";

    }

}

