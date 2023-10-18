package com.javayh.mybatis.flex.pojo;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(value = "users")
public class User implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    private String email;

}
