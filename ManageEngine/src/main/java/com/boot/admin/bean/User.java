package com.boot.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

//以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
