package com.utils;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //获取存放在请求头中的token
        String token = request.getHeader("token");
        try {
            JwtUtil.getTokenInfo(token);   //验证令牌，验证通过则返回true
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message","无效签名");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("message","token过期！");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("message","token无效！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","token无效！");
        }

        //验证令牌不通过，返回false
        map.put("state",false);
        //将map转化为json，相应给前端
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;

    }
}
