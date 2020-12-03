import admin.User;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
//    动态if test查询
    @Test
    public void test() throws IOException {
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句 此时openSession创建一个事务但是不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User condition=new User();
//        condition.setUsername("lucy");
//        condition.setPassword("12345");
        List<User> userList = mapper.findbyCollection(condition);
        System.out.println(userList);
    }
//    动态foreach查询
    @Test
    public void test1() throws IOException {
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句 此时openSession创建一个事务但是不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<String> list=new ArrayList<String>();
        list.add("lucy");
        list.add("tom");
        List<User> userList = mapper.findlist(list);
        System.out.println(userList);
    }
}
