package com.lovo.service.mybaits.test5_29.factory;

public class M2Factory implements BasicFactoryBMW{
    @Override
    public IBMW createBMW() {
        return new BMW2();
    }
}
