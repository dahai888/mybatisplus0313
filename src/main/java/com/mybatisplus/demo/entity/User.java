package com.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

//    @TableField(fill = FieldFill.INSERT)//到底填充什么，要填充一个自动填充的处理器
    private Date createTime;

    //@TableField(fill = FieldFill.UPDATE)
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer deleted;

}
