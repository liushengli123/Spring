import admin.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
//    配置核心配置文件并返回一个sqlSession对象
    public  SqlSession getSqlSession() throws IOException {
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句 此时openSession创建一个事务但是不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
//      查询数据 集成pageHelper实现分页显示
    @org.junit.Test
    public void test() throws IOException {
//        加载核心配置文件
        Test test=new Test();
        SqlSession sqlSession = test.getSqlSession();
//        分页查询语句
        PageHelper.startPage(1,2);
//        获取sql查询语句
        List<User> userList=sqlSession.selectList("userMapper.findAll");
        for (User user:userList
             ) {
            System.out.println(user);
        }
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("页大小："+pageInfo.getPageSize());
        sqlSession.close();
    }
//    插入数据
    @org.junit.Test
    public void test1() throws IOException {
        User user=new User();
        user.setUsername("kacy");
        user.setPassword("56789");
//        加载核心配置文件
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.save",user);
//        注意:当需要对数据库进行增删改时需要提交事务
        sqlSession.commit();
        sqlSessionFactory.openSession().close();
    }
//    修改数据
    @org.junit.Test
    public void test2() throws IOException {
        User user=new User();
        user.setUsername("kacy");
        user.setPassword("45678");
//        加载核心配置文件
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update",user);
//        注意:当需要对数据库进行增删改时需要提交事务
        sqlSession.commit();
        sqlSessionFactory.openSession().close();
    }
//    删除数据
    @org.junit.Test
    public void test3() throws IOException {
        User user=new User();
        user.setUsername("kacy");
//        加载核心配置文件
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.delete",user);
//        注意:当需要对数据库进行增删改时需要提交事务
        sqlSession.commit();
        sqlSessionFactory.openSession().close();
    }
}
