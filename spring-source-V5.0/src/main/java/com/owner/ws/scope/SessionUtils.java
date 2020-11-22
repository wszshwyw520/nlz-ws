package com.owner.ws.scope;

import org.assertj.core.util.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @project nlz-ws->SessionUtils
 * @description WANSI001
 * @create 2020-11-22 22:26
 */
public class SessionUtils {

    private static final Map<String,String> userMap = new HashMap<>();

    private static String lastUm = "";
    public static String IncrAndGetCurUser(String um){
        lastUm = um;
        if(userMap.get(um) != null){
            return userMap.get(um);
        }
        userMap.put(um,um);
        return um;
    }

    public static String getCurUser(){
        System.out.println("curUser -----: " + lastUm);
        return lastUm;
    }
}
