package top.xjrlife.dynamic.filters;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.tools.RedisCache;

import javax.annotation.Resource;
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
        User user = redisCache.getCache("currentUser");
        if (user == null){
            response.sendRedirect("/user/login");
            return false;
        }
        redisCache.putCacheWithExpireTime("currentUser",user, 7200);//重新设置为2小时
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
