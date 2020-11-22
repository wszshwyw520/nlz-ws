package com.owner.ws.scope;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.List;
import java.util.UUID;

/**
 * @project nlz-ws->RedisScope
 * @description WANSI001
 * @create 2020-11-22 22:14
 */
public class RedisScope implements Scope {

    public static final String REDIS_SCOPE = "redisScope";

    /**
     * 仅限制特定几个用户下，Redis的token值才是一样的
     * @param name
     * @param objectFactory
     * @return
     */

    private static List<String> userMenu = Lists.newArrayList("zhangsan001","zhangsan002","zhangsan003");

    private final String token = UUID.randomUUID() + "";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        //暂时放在这里控制，只是测试用
        String curUser = SessionUtils.getCurUser();
        RedisInfo redisInfo = (RedisInfo) objectFactory.getObject();
        if(userMenu.contains(curUser)){
            //处理token一致
            redisInfo.setToken(token);
        }else {
            String uuid = UUID.randomUUID() + "";
            String oldUuid = uuid;
            //确保token区别特定token的唯一性
            do{
                redisInfo.setToken(oldUuid);
                oldUuid = UUID.randomUUID() + "";
            }while (uuid.equals(token));
        }
        return redisInfo;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
