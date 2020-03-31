package com.lyq.mapper;

import com.lyq.model.Teacher;

public interface TeacherMapper {

    //获取指定老师，及老师下的所有学生
    Teacher getTeacher(int id);

    Teacher getTeacher2(int id);
}