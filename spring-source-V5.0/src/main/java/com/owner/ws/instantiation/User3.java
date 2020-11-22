package com.owner.ws.instantiation;

import lombok.Data;

import java.io.Serializable;

/**
 * @project nlz-ws->User
 * @description 用户实体
 * WANSI001
 * @create 2020-10-21 20:16
 */
@Data
public class User3 implements Serializable{

    private String userNo;

    private String userName;

    private String deptNo;

    private String deptName;

    private String imageAddr;

}
