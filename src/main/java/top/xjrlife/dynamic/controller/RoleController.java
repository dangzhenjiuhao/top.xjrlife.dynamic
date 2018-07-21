package top.xjrlife.dynamic.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.dto.RoleDto;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.service.IRoleService;

import java.util.Date;
import java.util.Map;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 角色列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "list_page",method = RequestMethod.GET)
    public String getListPage() throws Exception {
        return "role_list";
    }

    /**
     * 角色列表
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Result list(Integer page, Integer limit) throws Exception {
        if (limit == null) limit = 10;
        if (page == null) page = 1;
        return roleService.list(limit,page);
    }

    /**
     * 新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "add_page",method = RequestMethod.GET)
    public String addPage() throws Exception {
        return "role_add_page";
    }

    /**
     * 新增
     * @param role
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void add(RoleDto role) throws Exception{
        Role entity = new Role();
        BeanUtils.copyProperties(role, entity);
        entity.setCreateTime(new Date());
        roleService.add(entity);
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
            System.out.println(id);
            roleService.delete(id);
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
            System.out.println(ids);
            roleService.deletes(ids);
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
        Role selectRole = roleService.getRoleById(id);
        model.addAttribute("selectRole",selectRole);
        return "role_update_page";
    }

    @ModelAttribute
    public void getUserDto(Map<String, Object> map, Integer id) {
        if (id != null){
            Role role = roleService.getRoleById(id);
            RoleDto roleDto = new RoleDto();
            if (role != null){
                BeanUtils.copyProperties(role, roleDto);
                map.put("role",roleDto);
            }
        }
    }

    /**
     * 修改
     * @param role
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@ModelAttribute("role") RoleDto role) throws Exception{
        Role entity = new Role();
        BeanUtils.copyProperties(role, entity);
        roleService.update(entity);
    }
}
