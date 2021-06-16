package com.lyq.mapper;

import com.lyq.model.Student;

import java.util.List;

public interface StudentMapper {

    // 多表联查，查询学生的所有信息以及老师的信息
    List<Student> getStudent();

    List<Student> getStudent2();

    int insertStudent(Student student);
}