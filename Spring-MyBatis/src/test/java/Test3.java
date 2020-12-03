import admin.Manager;
import admin.Order;
import dao.ManagerMapper;
import dao.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test3 {
    public SqlSession getSqlSession() throws IOException {
        String resource = "sqlSessionConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sql查询语句 此时openSession创建一个事务但是不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
    @Test
    public void test() throws IOException {
        Test3 test=new Test3();
        SqlSession sqlSession = test.getSqlSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order:orderList
             ) {
            System.out.println(order);
        }
    }
    @Test
    public void test2() throws IOException {
        Test3 test=new Test3();
        SqlSession sqlSession = test.getSqlSession();
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        List<Manager> managerList=mapper.findAllorder();
        for (Manager manager:managerList
             ) {
            System.out.println(manager);
        }
    }
}
