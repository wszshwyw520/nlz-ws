package com.owner.ws.instantiation;

import lombok.Data;

/**
 * @project nlz-ws->Dept
 * @description WANSI001
 * @create 2020-10-21 20:49
 */
@Data
@CacheComponent
public class Dept {

    private String id = "1";

    private String deptNo = "CM-PA-0209";

    private String deptName = "卫检部门";
}
