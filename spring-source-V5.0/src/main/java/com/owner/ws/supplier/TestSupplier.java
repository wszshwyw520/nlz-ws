package com.owner.ws.supplier;

import com.owner.ws.instantiation.User;
import org.apache.logging.log4j.util.Supplier;

/**
 * @project nlz-ws->TestSupplier
 * @description WANSI001
 * @create 2020-10-24 10:59
 */
public class TestSupplier {

    public static void main(String[] args) {
        //节约CPU资源 需要用到才计算
        Supplier<User> user = ()->getUser();

    }

    private static User getUser() {
        System.out.println("+--复杂计算过程---+");
        return new User();
    }

}
