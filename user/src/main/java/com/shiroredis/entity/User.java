package com.shiroredis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Adam
 * @since 2019-10-04
 */
@Data
public class User implements Serializable{
    private Long id;
    private String username;
    private String password;
}
