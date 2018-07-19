package top.xjrlife.dynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.tools.RedisCache;

import javax.annotation.Resource;

/**
 * 创建人：xjz
 * 创建时间：2018/7/17
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Resource
    private RedisCache redisCache;

    @RequestMapping(value = "index")
    public String index(Model model) throws Exception {
        User user = redisCache.getCache("currentUser");
        model.addAttribute("user",user);
        return "index";
    }
}
