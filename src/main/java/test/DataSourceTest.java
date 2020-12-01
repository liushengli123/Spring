package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

@Configuration
@ComponentScan("com.annotation")
@Import({DataSourceConfiguration.class})
public class DataSourceTest {
//    通过spring注入的方式配置数据源
    @Test
    public void test() throws Exception {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
//    手动配置数据源
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("w296645");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
//    通过配置文件的方式配置数据源
    @Test
    public void test2() throws Exception {
        ResourceBundle rb=ResourceBundle.getBundle("jdbc");
        String driver=rb.getString("jdbc.driver");
        String url=rb.getString("jdbc.url");
        String user=rb.getString("jdbc.user");
        String password=rb.getString("jdbc.password");
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
