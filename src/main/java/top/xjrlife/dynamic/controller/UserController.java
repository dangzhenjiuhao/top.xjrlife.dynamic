package top.xjrlife.dynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xjrlife.dynamic.dto.LoginDto;
import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
    public String login(Model model, @Valid @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result, HttpServletRequest request){
        //如果存在验证错误信息重定向到表单提交展示错误信息
        if(result.hasErrors()){
            return "login";
        }
        try{
            userService.login(loginDto.getLoginName(),loginDto.getLoginPassword());
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
        return "add_page";
    }
}
