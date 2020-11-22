package com.owner.ws.scope;

import com.owner.ws.instantiation.CacheComponent;
import lombok.Data;
import org.springframework.context.annotation.Scope;

/**
 * @project nlz-ws->RedisInfo
 * @description WANSI001
 * @create 2020-11-22 22:21
 */
@Data
@CacheComponent
@Scope(value = RedisScope.REDIS_SCOPE)
public class RedisInfo {

    private String token;
}
