package top.xjrlife.dynamic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.xjrlife.dynamic.dao.UserMapper;
import top.xjrlife.dynamic.dto.Result;
import top.xjrlife.dynamic.pojo.User;
import top.xjrlife.dynamic.pojo.UserExample;
import top.xjrlife.dynamic.service.IUserService;
import top.xjrlife.dynamic.tools.MD5Utils;
import top.xjrlife.dynamic.tools.RedisCache;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 创建人：xjz
 * 创建时间：2018/5/30
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userDao;
    @Resource
    private RedisCache redisCache;

    public User getUserById(Integer userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @throws Exception
     */
    public String login(String userName, String password) throws Exception {
        if (StringUtils.isEmpty(userName)){
            throw new Exception("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)){
            throw new Exception("密码不能为空");
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(userName);
        criteria.andLoginPasswordEqualTo(MD5Utils.md5(password));
        List<User> userList = userDao.selectByExample(example);
        if (userList == null || userList.size() == 0){
            throw new Exception("用户名或密码错误");
        }
        //缓存到redis
        String userKey = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        redisCache.putCacheWithExpireTime(userKey,userList.get(0),7200);//缓存2小时
        return userKey;
    }

    /**
     * 获取用户列表
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public Result list(Integer pageSize, Integer page) throws Exception {
        Result result = new Result();
        PageHelper.startPage(page,pageSize);
        List<User> data = userDao.selectByExample(null);
        PageInfo pageInfo = new PageInfo(data);
        result.setCode(0);
        result.setMsg("success");
        result.setCount(pageInfo.getTotal());
        result.setData(data);
        return result;
    }

    /**
     * 新增
     * @param entity
     * @throws Exception
     */
    public void add(User entity) throws Exception {
        userDao.insert(entity);
    }

    /**
     * 修改
     * @param entity
     * @throws Exception
     */
    public void update(User entity) throws Exception {
        userDao.updateByPrimaryKey(entity);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id) throws Exception{
        if (id == null ){
            throw new Exception("ID不能为空");
        }
        userDao.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deletes(Integer[] ids) throws Exception{
        if (ids == null || ids.length == 0){
            throw new Exception("ID不能为空");
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        userDao.deleteByExample(example);
    }
}
