package top.xjrlife.dynamic.service.impl;

import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;
import top.xjrlife.dynamic.dao.UserMapper;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建人：xjz
 * 创建时间：2018/5/30
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userDao;

    public User getUserById(Integer userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }


}
