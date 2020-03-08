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
    
    private int id;
    private String name;
    private String password;
    
}