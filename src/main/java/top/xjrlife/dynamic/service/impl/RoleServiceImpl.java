package top.xjrlife.dynamic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.xjrlife.dynamic.dao.RoleMapper;
import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.pojo.RoleExample;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.service.IRoleService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 角色列表
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public Result list(Integer pageSize, Integer page) throws Exception {
        Result result = new Result();
        PageHelper.startPage(page,pageSize);
        List<Role> data = roleMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(data);
        result.setCode(0);
        result.setMsg("success");
        result.setCount(pageInfo.getTotal());
        result.setData(data);
        return result;
    }

    /**
     * 获取角色
     * @param id
     * @return
     */
    public Role getRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param entity
     * @throws Exception
     */
    public void add(Role entity) throws Exception {
        roleMapper.insert(entity);
    }

    /**
     * 修改
     * @param entity
     * @throws Exception
     */
    public void update(Role entity) throws Exception {
        roleMapper.updateByPrimaryKey(entity);
    }

    /**
     * 删除
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception {
        if (id == null ){
            throw new Exception("ID不能为空");
        }
        roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     * @throws Exception
     */
    public void deletes(Integer[] ids) throws Exception {
        if (ids == null || ids.length == 0){
            throw new Exception("ID不能为空");
        }
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        roleMapper.deleteByExample(example);
    }
}
