package com.owner.ws.instantiation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project nlz-ws->CacheCompoent
 * @description WANSI001
 * @create 2020-10-21 20:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheComponent {
}
