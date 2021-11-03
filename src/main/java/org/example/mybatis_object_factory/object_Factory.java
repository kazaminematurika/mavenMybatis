package org.example.mybatis_object_factory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.example.mybatis_Test.output_Student;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author Kazamine_Setueka
 */
public class object_Factory extends DefaultObjectFactory {
    private String author;
    //创建使用无参构造器创建对象的通用方法
    @Override
    public Object create(Class type){
        System.out.println("无参构造器创建对象" + type);
        var obj = super.create(type);
        return processObject(obj);
    }

    @Override
    public Object create(Class type, List constructorArgtypes, List  constructorArgs){
        System.out.printf("调用构造器创建%s对象,构造器的参数为:%s", type, constructorArgs);
        var obj = super.create(type, constructorArgtypes, constructorArgs);
        return processObject(obj);
    }

    //    将对象工厂配置的元素属性传入到相对应的这个对象
    @Override
    public void setProperties(Properties properties){
        super.setProperties(properties);
        System.out.println("输出配置的相对应的属性值:" + properties);
        this.author = properties.getProperty("author");
    }

    @Override
    public <T> boolean isCollection(Class<T> type){
        System.out.println("==isCollection==");
        return super.isCollection(type);
    }

    private Object processObject(Object obj){
        //判断是否为output_Student对象或者其子类
        if (output_Student.class.isAssignableFrom(obj.getClass())){
            var news = (output_Student) obj;
                news.getMeta().put("author", this.author);
                news.getMeta().put("queryDate", new Date());
        }
        return obj;
    }
}
