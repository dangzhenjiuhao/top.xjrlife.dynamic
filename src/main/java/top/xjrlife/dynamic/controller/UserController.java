package top.xjrlife.dynamic.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.xjrlife.dynamic.dto.LoginDto;
import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.dto.UserDto;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.service.IUserService;
import top.xjrlife.dynamic.tools.MD5Utils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建人：xjz
 * 创建时间：2018/7/17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 登录
     * @param model
     * @param loginDto
     * @param result
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Model model, @Valid @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result, HttpServletRequest request, HttpServletResponse response){
        //如果存在验证错误信息重定向到表单提交展示错误信息
        if(result.hasErrors()){
            return "login";
        }
        try{
            String token = userService.login(loginDto.getLoginName(),loginDto.getLoginPassword());
            Cookie cookie = new Cookie("u_key",token);//创建新cookie
            cookie.setMaxAge(7200);// 设置存在时间为5分钟
            cookie.setPath("/");//设置作用域
            response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
        }catch(Exception e){
            model.addAttribute("globalError",e.getMessage());
            return "login";
        }
        return "redirect:/main/index";
    }

    /**
     * 用户列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "list_page",method = RequestMethod.GET)
    public String getUserList() throws Exception {
        return "user_list";
    }

    /**
     * 获取用户列表数据(分页)
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Result getList(Integer page, Integer limit) throws Exception {
        if (limit == null) limit = 10;
        if (page == null) page = 1;
        return userService.list(limit,page);
    }

    /**
     * 新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "add_page",method = RequestMethod.GET)
    public String addPage() throws Exception {
        return "user_add_page";
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void add(UserDto user) throws Exception{
        System.out.println(user.getLoginName());
        User entity = new User();
        BeanUtils.copyProperties(user, entity);
        entity.setCreateTime(new Date());
        entity.setLastLoginTime(new Date());
        entity.setUserType(0);
        entity.setSort(100);
        entity.setLoginPassword(MD5Utils.md5(entity.getLoginPassword()));
        userService.add(entity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    @ResponseBody
    public Result delete(Integer id){
        Result result = new Result();
        try {
            userService.delete(id);
            result.setCode(200);
            result.setMsg("success");
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "deletes",method = RequestMethod.GET)
    @ResponseBody
    public Result deletes(Integer[] ids){
        Result result = new Result();
        try {
            userService.deletes(ids);
            result.setCode(200);
            result.setMsg("success");
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 修改页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update_page",method = RequestMethod.GET)
    public String updatePage(Model model, Integer id) throws Exception {
        User selectUser = userService.getUserById(id);
        model.addAttribute("selectUser",selectUser);
        return "user_update_page";
    }

    @ModelAttribute
    public void getUserDto(Map<String, Object> map, Integer id){
        if (id != null){
            User user = userService.getUserById(id);
            UserDto userDto = new UserDto();
            if (user != null){
                BeanUtils.copyProperties(user, userDto);
                map.put("user",userDto);
            }
        }
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@ModelAttribute("user") UserDto user) throws Exception{
        System.out.println(user.getLoginPassword());
        User entity = new User();
        BeanUtils.copyProperties(user, entity);
        entity.setLastLoginTime(new Date());
        userService.update(entity);
    }
}
