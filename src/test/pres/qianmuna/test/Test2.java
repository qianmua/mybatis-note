package pres.qianmuna.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/2  19:44
 * @description :
 */
public class Test2 {


//    private Logger logger = Logger.getLogger(Test2.class);

    @org.junit.Test
    public void test() {
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            //queryById
            count = sqlSession.selectOne("pres.qianmuna.mybatis.mapper.UserMapper.count");
            //List<Object> list = sqlSession.selectList("pres.qianmuna.mybatis.mapper.UserMapperKT.queryById", 1);

            System.out.println("///=================///");
            System.out.println(count);
            System.out.println("///=================///");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
