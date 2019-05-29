package com.lovo.service.mybaits.test5_29.factory;

public class FactoryBmw {
    public IBMW creatBmw(int tag){
        IBMW bmw=null;
        switch (tag){
            case 1:
                bmw=new BMW2();
                break;
            case 2:
                bmw=new BMW3();
                break;
        }
        return bmw;
    }
}
