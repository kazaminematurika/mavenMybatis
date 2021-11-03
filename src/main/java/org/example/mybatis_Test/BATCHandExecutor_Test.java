package org.example.mybatis_Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis_Test_XML_resources.mybatis_Test;

public class BATCHandExecutor_Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws Exception{
        var resources = "mybatis配置文件.xml";
        var inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        var sqlSession = sqlSessionFactory.openSession();
        System.out.println("测试使用批处理和以及不适用批处理所需要时间的区别:");
        insertStudentTest1();
        insertStudentTest2();
    }

    public static void insertStudentTest1(){
        var sqlSession = sqlSessionFactory.openSession();
        var start = System.currentTimeMillis();
        var newsMappers = sqlSession.getMapper(mybatis_Test.class);
        for (var i = 0; i < 5000; i++){
            var news = new output_Student(11111, "11111", "222222");
            newsMappers.StudentSave(news);
        }
        sqlSession.commit();
        System.out.println("不使用批处理的耗时:" + (System.currentTimeMillis() - start));
        sqlSession.close();
    }

    public static void insertStudentTest2() {
        var sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        var start = System.currentTimeMillis();
        var newsMappers = sqlSession.getMapper(mybatis_Test.class);
        for (var i = 0; i < 5000; i++) {
            var news = new output_Student(11111, "11111", "222222");
            newsMappers.StudentSave(news);
        }
        sqlSession.flushStatements();
        sqlSession.commit();
        System.out.println("使用批处理的耗时:" + (System.currentTimeMillis() - start));
        sqlSession.close();
    }
}
