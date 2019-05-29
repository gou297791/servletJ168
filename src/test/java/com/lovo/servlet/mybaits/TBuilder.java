package com.lovo.servlet.mybaits;

import com.lovo.service.mybaits.test5_29.Hero;
import com.lovo.service.mybaits.test5_29.HeroBuilder;
import com.lovo.service.mybaits.test5_29.MakeHero;
import com.lovo.service.mybaits.test5_29.VNVIPBuilder;
import com.lovo.service.mybaits.test5_29.factory.FactoryBmw;
import com.lovo.service.mybaits.test5_29.factory.IBMW;
import org.junit.Test;

public class TBuilder {
    @Test
    public void testBuilder(){
        //构建者开始构建
        HeroBuilder hb=new VNVIPBuilder();
        //生产者
        MakeHero mk=new MakeHero(hb);
        mk.build();
        Hero h=mk.getHero();
        System.out.printf(h.getKill()+","+h.getKien());
    }
    @Test
    public void testFactory(){
        FactoryBmw fb=new FactoryBmw();
        IBMW bmw=fb.creatBmw(1);
        System.out.printf(bmw.carName());
    }
}
