package mybatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Student.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class myBatis_Test {
    @Test
    public void selectStudentbyID() throws IOException {
        String config = "mybatis配置文件.xml";
       InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        String sqlid = "org.example.Studentdao.Studentdao" + "." + "selectStudentbyID";
        Student student = session.selectOne(sqlid);
        System.out.println("测试输出mybatis数据:" + student);
        session.close();
    }
}
