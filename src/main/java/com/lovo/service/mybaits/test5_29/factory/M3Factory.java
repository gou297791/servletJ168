package com.lovo.service.mybaits.test5_29.factory;

public class M3Factory implements BasicFactoryBMW{
    @Override
    public IBMW createBMW() {
        return new BMW3();
    }
}
