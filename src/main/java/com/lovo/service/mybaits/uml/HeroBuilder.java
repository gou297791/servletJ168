package com.lovo.service.mybaits.uml;

public interface HeroBuilder {
    /**
     *
     * @return 符文
     */
    public void buildPymbol();

    /**
     *
     * @return 技能
     */
    public void buildKill();

    /**
     *
     * @return 皮肤
     */
    public void buildKien();
    /**
     * 返回英雄
     * @return
     */
    public Hero createHero();
}
