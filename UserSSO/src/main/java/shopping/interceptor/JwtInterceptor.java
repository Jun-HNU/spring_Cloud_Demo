package shopping.interceptor;

import com.alibaba.fastjson.JSONObject;
import shopping.service.UserService;
import shopping.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author yxm
 * @date 2021/3/2
 * Token拦截器
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //这里做简单判断
        if (token == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject res = new JSONObject();
                res.put("code", "403");
                res.put("msg", "访问无权限!");
                out = response.getWriter();
                out.append(res.toString());
            } catch (Exception ex) {
                response.sendError(500);
            }
            return false;
        }
        if (token != null){
            String username = JwtUtil.getUserNameByToken(request);
            // 这边拿到的 用户名 应该去数据库查询获得密码，简略，步骤在service直接获取密码
            boolean result = JwtUtil.verify(token,username,userService.getPassword(username));
            if(result){
                return true;
            }else{
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                try {
                    JSONObject res = new JSONObject();
                    res.put("code", "500");
                    res.put("msg", "token错误！");
                    out = response.getWriter();
                    out.append(res.toString());
                } catch (Exception ex) {
                    response.sendError(500);
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

