package top.xjrlife.dynamic.service;

import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.pojo.User;

import java.util.List;

/**
 * 创建人：xjz
 * 创建时间：2018/5/30
 */
public interface IUserService {
    User getUserById(Integer userId);
    String login(String userName, String password) throws Exception;
    Result list(Integer pageSize, Integer page) throws Exception;

    void add(User entity) throws Exception;
    void update(User entity) throws Exception;
    void delete(Integer id) throws Exception;
    void deletes(Integer[] ids) throws Exception;
}
