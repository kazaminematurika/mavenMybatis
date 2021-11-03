package org.example.mybatis_Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.HashMap;

public class Student_Test {
    private static SqlSessionFactory sqlSessionFactory;
    public static void main(String[] args) throws Exception{
        var resource = "mybatis配置文件.xml";
        var inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        var sqlsession = sqlSessionFactory.openSession();

//        insterTest(sqlsession);

//        updataTest(sqlsession);

//        delete_insert_Test(sqlsession);

//        delete_Test(sqlsession);

        select_Test(sqlsession);
    }

//    使用添加数据的方法体
//    public static void insterTest(SqlSession sqlsession){
//        var into = new HashMap<String, String>();
//        into.put("ID", "333333");
//        into.put("Name", "红叶");
//        into.put("Age", "18");
//        var number = sqlsession.insert("org.example.mybatis_Test_XML_resources.insert_Studet.StudentSave", into);
//        System.out.println("插入了第" + number + "数据");
//        sqlsession.commit();
//        sqlsession.close();
//    }
//    public static void updataTest(SqlSession sqlSession){
//        var updata_news = new HashMap<String, String>();
//        updata_news.put("ID", "222222");
//        updata_news.put("Name", "雪月花");
//        updata_news.put("Age", "17");
//        var number = sqlSession.update("org.example.mybatis_Test_XML_resources.mybatis_Test.Studentupdata", updata_news);
//        System.out.println("更新了" + number + "条事务");
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    public static void delete_insert_Test(SqlSession sqlSession){
//        var number = sqlSession.insert("org.example.mybatis_Test_XML_resources.mybatis_Test.Student_delete_insert", "111111");
//        System.out.println("使用不同映射标签的SQL语句删除了" + number + "条数据");
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    public static void delete_Test(SqlSession sqlSession){
//        var number = sqlSession.delete("org.example.mybatis_Test_XML_resources.mybatis_Test.Studentdelete", "222222");
//        System.out.println("使用一样的SQL语句删除了对应的" + number + "条数据");
//        sqlSession.commit();
//        sqlSession.close();
//    }
    public static void select_Test(SqlSession sqlSession){
        //创建只查找一个的selsctOne语句的映射指令
        var number = sqlSession.selectOne("org.example.mybatis_Test_XML_resources.mybatis_Test.selectStudent", "333333");
        System.out.println("使用SQLselect查找语句进行对应的语句查找" + number + "条消息");
        sqlSession.commit();
        sqlSession.close();
    }
}
