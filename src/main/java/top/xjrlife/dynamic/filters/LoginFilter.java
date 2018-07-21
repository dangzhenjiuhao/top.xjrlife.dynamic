package top.xjrlife.dynamic.filters;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.tools.RedisCache;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建人：xjz
 * 创建时间：2018/7/18
 */
public class LoginFilter implements HandlerInterceptor {

    @Resource
    private RedisCache redisCache;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();//根据请求数据，找到cookie数组
        String key = "";
        if (null==cookies) {//如果没有cookie数组
            response.sendRedirect("/user/login");
            return false;
        } else {
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("u_key")){
                    key = cookie.getValue();
                }
            }
        }
        if (StringUtils.isEmpty(key)){
            response.sendRedirect("/user/login");
            return false;
        }
        User user = redisCache.getCache(key);
        if (user == null){
            response.sendRedirect("/user/login");
            return false;
        }
        redisCache.putCacheWithExpireTime(key,user, 7200);//重新设置为2小时
        Cookie cookie = new Cookie("u_key",key);//创建新cookie
        cookie.setMaxAge(7200);// 设置存在时间为5分钟
        cookie.setPath("/");//设置作用域
        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端

        request.setAttribute("user",user);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
