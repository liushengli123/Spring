package JdbcTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

@ContextConfiguration(classes = {DataSourceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test02 {
    @Autowired
    private DataSource dataSource;
    @Test
    public void test() throws PropertyVetoException, SQLException {
//        System.out.println(dataSource.getConnection());
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource((DataSource) dataSource);
        int row=jdbcTemplate.update("insert into user values (?,?)","Tom1",21);
        System.out.println(row);
    }
}
