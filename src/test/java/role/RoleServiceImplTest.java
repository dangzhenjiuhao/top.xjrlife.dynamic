package role;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xjrlife.dynamic.pojo.Role;
import top.xjrlife.dynamic.service.IRoleService;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RoleServiceImplTest {

    private static Logger logger = Logger.getLogger(RoleServiceImplTest.class);
    @Resource
    private IRoleService roleService;
    @Resource
    private DataSource dataSource;

    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName("test");
        role.setSort(100);
        role.setRemark("test");
        role.setIsAvailable(1);
        roleService.addRole(role);
        logger.info(JSON.toJSONString(role));
    }

    @Test
    public void testDatasource(){
        System.out.println(dataSource);
    }
}
