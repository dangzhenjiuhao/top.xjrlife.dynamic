package redis;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import top.xjrlife.dynamic.tools.RedisCache;
import javax.annotation.Resource;

/**
 * 创建人：xjz
 * 创建时间：2018/7/12
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RedisTest {

    private static Logger logger = Logger.getLogger(role.RoleServiceImplTest.class);
    @Resource
    private RedisCache redisCache;
    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void testRedis(){
        try {
              redisCache.putCache("xjz","009988");
//            Jedis jedis = new Jedis("118.190.199.78", 6379);
//            jedis.auth("123456");
//            jedis.set("k8","k8");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJedis(){
        try {
            Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
           jedis.set("jedis","jedis");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
