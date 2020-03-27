package cn.dujr.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int port;
    private String username;
    private String password;
    private String desc;
    private Date createDate;
}
