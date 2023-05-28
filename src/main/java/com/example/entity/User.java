package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Slf4j

// mybatis-plus
@TableName(value = "user")
public class User {
    // IdType.ASSIGN_ID 雪花算法
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    // exist = true 数据表中存在该字段
    @TableField(value = "username", exist = true)
    @NonNull
    private String username;

    @TableField(value = "password", exist = true)
    @NonNull
    private String password;
}
