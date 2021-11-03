package org.example.mybatis_Test_XML_resources;

import org.example.mybatis_Test.output_Student;

public interface mybatis_Test {
    int StudentSave(output_Student news);
    int Studentupdata(output_Student news);
    int Studentdelete(int a);
    output_Student selectStudent(int a);
}
