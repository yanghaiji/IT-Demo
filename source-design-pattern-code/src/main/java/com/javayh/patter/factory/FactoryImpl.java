package com.javayh.patter.factory;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-26
 */
public class FactoryImpl extends AbstractFactory{

    @Override
    public ProdAbstractFactory create(String name) {
        if(StringUtils.isBlank(name)){
            return null;
        }else if("A".equals(name)){
            return new ProdA();
        }else {
            return new ProdB();
        }
    }

    @Override
    public ProdB update() {
        return null;
    }
}
