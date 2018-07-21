package top.xjrlife.dynamic.service;

import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.pojo.User;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
public interface IRoleService {
    Result list(Integer pageSize, Integer page) throws Exception;
    Role getRoleById(Integer id);
    void add(Role entity) throws Exception;
    void update(Role entity) throws Exception;
    void delete(Integer id) throws Exception;
    void deletes(Integer[] ids) throws Exception;
}
