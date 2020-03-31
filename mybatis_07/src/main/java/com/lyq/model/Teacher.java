package com.lyq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    private int id;
    private String name;
    //一个老师多个学生
    private List<Student> students;

}
