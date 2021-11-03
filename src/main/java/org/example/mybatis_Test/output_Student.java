package org.example.mybatis_Test;
import org.apache.ibatis.type.Alias;

import java.util.Map;

//可以通过在类前面@Alias("alias_name")的方法对类进行取别名从而在mybatis(映射).xml进行引用
@Alias("class_news")
public class output_Student{
    private Integer ID;
    private String Age;
    private String Name;
    private Map<String, Object> meta;

    //创建无参构造器
    output_Student(){

    }


    public output_Student(Integer ID, String Age, String Name){
        this.Age = Age;
        this.Name = Name;
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    // meta的setter和getter方法
    public void setMeta(Map<String, Object> meta)
    {
        this.meta = meta;
    }
    public Map<String, Object> getMeta()
    {
        return this.meta;
    }

    @Override
    public String toString() {
        return "output_Student{" +
                "学号是=" + this.ID +
                ", 年龄是='" + this.Age + '\'' +
                ", 姓名是='" + this.Name + '\'' +
                ", 数据源是=" + this.meta +
                '}';
    }
}
