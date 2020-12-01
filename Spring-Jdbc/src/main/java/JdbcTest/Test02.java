package JdbcTest;

import Bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

@ContextConfiguration(classes = {DataSourceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test02 {
    @Autowired
    private DataSource dataSource;
//    通过spring Template模板向数据库中添加数据
    @Test
    public void test() throws PropertyVetoException, SQLException {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource((DataSource) dataSource);
        int row=jdbcTemplate.update("insert into user values (?,?)","Tom1",21);
        System.out.println(row);
    }
//    通过spring Template模板向数据库中修改数据
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource((DataSource) dataSource);
        int row=jdbcTemplate.update("update user set age=? where name=?",19,"Tom1");
        System.out.println(row);
    }
//    通过spring Template模板向数据库中删除数据
    @Test
    public void test2() throws PropertyVetoException, SQLException {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource((DataSource) dataSource);
        int row=jdbcTemplate.update("delete from user where age=?",19);
        System.out.println(row);
    }
//   通过spring Template模板向数据库中删除数据
    @Test
    public void test3() throws PropertyVetoException, SQLException {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource((DataSource) dataSource);
        List<User> list =jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
        List<User> list1 =jdbcTemplate.query("select * from user where name=?",new BeanPropertyRowMapper<User>(User.class),"Tom");
        Long count=jdbcTemplate.queryForObject("select count(*) from user",Long.class);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(count);
    }

}
