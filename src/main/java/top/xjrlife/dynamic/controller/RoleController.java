package top.xjrlife.dynamic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.service.IRoleService;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "addRole",method = RequestMethod.GET)
    @ResponseBody
    public Role addRole(Role role){
        roleService.addRole(role);
        return role;
    }
}
