package com.javayh.wenflux.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-08
 */
@Data
public class DemoEntity {
    private String name;

    public DemoEntity(String name) {
        this.name = name;
    }

    private static List<DemoEntity> list = new ArrayList<>();

    public static List<DemoEntity> listEntityBuild(){

        for (int i = 0; i < 10; i++) {
            DemoEntity demoEntity = new DemoEntity("flux" + i);
            list.add(demoEntity);
        }
        return list;
    }

    public static Long del(){
        list.clear();
        return 1L;
    }
}
