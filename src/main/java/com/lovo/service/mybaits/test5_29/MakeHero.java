package com.lovo.service.mybaits.test5_29;

/**
 * 英雄制作
 */
public class MakeHero {
    private HeroBuilder heroBuilder;
    public MakeHero(HeroBuilder heroBuilder){
        this.heroBuilder=heroBuilder;
    }
    //开始构建
    public void build(){
        heroBuilder.buildPymbol();
        heroBuilder.buildKill();
        heroBuilder.buildKien();
    }
    public Hero getHero(){
        return  heroBuilder.createHero();
    }
}
