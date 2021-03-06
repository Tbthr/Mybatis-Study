package com.lyq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Alias("_user") //设置别名
public class User {
    
    private int id;  //id
    private String name;   //姓名
    private String password;   //密码
    
}