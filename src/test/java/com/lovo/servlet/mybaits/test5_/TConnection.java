package com.lovo.servlet.mybaits.test5_;

import org.junit.Test;

public class TConnection {
    @Test
    public void testDriver(){
        try {
            Class<?> c1 = Class.forName("com.mysql.jdbc.Driver");
            System.out.printf(c1.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        System.out.printf("helloword");
    }
}
