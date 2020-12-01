package test;

import com.annotation.controller.UserController;
import com.annotation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceTest.class})
public class JunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @Test
    public void test() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}