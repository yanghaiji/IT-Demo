package com.javayh.patter.factory;

/**
 * <p>
 * 抽象工厂
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-26
 */
public abstract class AbstractFactory {

    /**
     * 创建产品
     */
    public abstract ProdAbstractFactory create(String name);

    /**
     * 更新
     */
    public abstract ProdB update();

}
