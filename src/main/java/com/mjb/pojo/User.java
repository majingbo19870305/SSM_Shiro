package com.mjb.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String salt;
    private List<Role> roleList;
}
