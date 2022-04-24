import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.xianlin.config.SpringConfig;
import xyz.xianlin.pojo.UserData;
import xyz.xianlin.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    public void testSelectByUserQQ() {
        UserData userData = new UserData();
        userData.setUserQQ("11111111");
        userData.setUserName("张三");
        userData.setUserPassword("6666");
        userService.insertUser(userData);
    }
}
