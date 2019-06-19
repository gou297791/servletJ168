package com.lovo.service.mybaits.uml;

import java.util.UUID;

public class GetUUID {

    public static String createUUID(){

        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
