package com.owner.ws.scope;

import com.owner.ws.instantiation.CacheComponent;
import org.springframework.context.annotation.Scope;

/**
 * @project nlz-ws->CustomScopeBean
 * @description WANSI001
 * @create 2020-11-22 22:04
 */
@CacheComponent
@Scope(value = CustomScope.IND_SCOPE)
public class CustomScopeBean {
}
