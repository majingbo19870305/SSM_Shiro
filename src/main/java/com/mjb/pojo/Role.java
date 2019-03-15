package com.mjb.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private int id;
    private String name;
    private List<Permission> permissionList;
}
