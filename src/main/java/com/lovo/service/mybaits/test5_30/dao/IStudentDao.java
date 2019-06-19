package com.lovo.service.mybaits.test5_30.dao;

import java.util.List;

public interface IStudentDao{
    public void insertStudent(StudentSystem student);
//    public StudentSystem login(StudentSystem student);
    public StudentSystem login(String userName,String pass);
    public List<StudentSystem> findAllStudent();
    public StudentSystem findStudentByName(String userName);
}
