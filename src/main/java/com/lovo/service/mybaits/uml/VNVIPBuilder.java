package com.lovo.service.mybaits.uml;

/**
 * 构建VIP版本的VN
 */
public class VNVIPBuilder implements HeroBuilder {
    //持有英雄
    Hero h=new Hero();

    @Override
    public void buildPymbol() {
        h.setPymbol("全攻速符文");
    }

    @Override
    public void buildKill() {
        h.setKill("终极时刻");
    }

    @Override
    public void buildKien() {
        h.setKien("源计划");
    }

    @Override
    public Hero createHero() {
        return h;
    }
}
