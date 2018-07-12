package top.xjrlife.dynamic.service.impl;

import org.springframework.stereotype.Service;
import top.xjrlife.dynamic.dao.RoleMapper;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.service.IRoleService;

import javax.annotation.Resource;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    public void addRole(Role role) {
        roleMapper.insert(role);
    }
}
