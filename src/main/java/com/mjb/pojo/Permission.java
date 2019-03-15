package com.mjb.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Permission implements Serializable {
    private int id;
    private String name;
}
