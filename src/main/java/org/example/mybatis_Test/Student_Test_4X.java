package org.example.mybatis_Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis_Test_XML_resources.mybatis_Test;

public class Student_Test_4X {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws Exception{
        var resources = "mybatis配置文件.xml";
        var inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        var sqlSession = sqlSessionFactory.openSession();
        selectStudent(sqlSession);
        //
    }

    public static void insertTest(SqlSession sqlSession){
        var news_output_Student = new output_Student();
        news_output_Student.setName("红叶");
        news_output_Student.setAge("18");
        //获取Mapper对象
        var newmappers = sqlSession.getMapper(mybatis_Test.class);
        //调用mappers方法为SQL语句执行提供持久化的操作
        var n = newmappers.StudentSave(news_output_Student);
        System.out.println("成功插入了" + n + "数据");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(newmappers.getClass());
    }

    public static void updataTest(SqlSession sqlSession){
        var news_updata_Student = new output_Student();
        news_updata_Student.setID(111111);
        news_updata_Student.setAge("18");
        news_updata_Student.setName("雪月花");
        var newmappers = sqlSession.getMapper(mybatis_Test.class);
        var n = newmappers.Studentupdata(news_updata_Student);
        System.out.println("成功更新了" + n + "条数据");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(newmappers.getClass());
    }

    public static void deleteTest(SqlSession sqlSession){
        var newmapper = sqlSession.getMapper(mybatis_Test.class);
        var n = newmapper.Studentdelete(11111111);
        System.out.println("成功删除了" + n + "条信息");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(newmapper.getClass());
    }

    public static void selectStudent(SqlSession sqlSession){
        var newmapper = sqlSession.getMapper(mybatis_Test.class);
        var n = newmapper.selectStudent(333333);
        System.out.println("查询到的一条记录为:" + n);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(newmapper.getClass());
    }
}
