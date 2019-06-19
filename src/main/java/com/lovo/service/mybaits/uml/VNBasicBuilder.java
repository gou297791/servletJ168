package com.lovo.service.mybaits.uml;

/**
 * 构建普通版本的VN
 */
public class VNBasicBuilder implements HeroBuilder {
    //持有英雄
    Hero h=new Hero();

    @Override
    public void buildPymbol() {
        h.setPymbol("全物理攻击符文");
    }

    @Override
    public void buildKill() {
        h.setKill("圣银弩箭");
    }

    @Override
    public void buildKien() {
        h.setKien("系统皮肤");
    }

    @Override
    public Hero createHero() {
        return h;
    }
}
