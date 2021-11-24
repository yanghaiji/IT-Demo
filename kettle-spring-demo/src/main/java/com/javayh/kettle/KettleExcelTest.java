package com.javayh.kettle;

import cn.hutool.core.io.FileUtil;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-24
 */
public class KettleExcelTest {

    /**
     * <p>
     * 用于测试 java 代码调用kettle api 实现 excel 输入输出
     *
     * 测试的前提，您可以自行修改或者创建一个 xxx.ktr文件
     * 如果您无法创建，想使用本示例，请将excel_input_demo_01.ktr文件 的加载路径进行修改
     *
     * 修改方法，可以在excel_input_demo_01.ktr文件 中全局搜索 kettle-spring-demo
     * </p>
     *
     * @return void
     * @version 1.0.0
     * @since 2021/11/24
     */
    public static void main(String[] args) throws KettleException {
        File file = FileUtil.file("kettle/excel_input_demo_01.ktr");
        String path = file.getPath();
        System.out.println(path);
        //初始化
        KettleEnvironment.init();
        //  加载文件
        TransMeta transMeta = new TransMeta(path);
        Trans trans = new Trans(transMeta);
        // 放入参数，这里其实可以从数据库中取到
        // 如果没有参数，可以把这步忽略
        // trans.setParameterValue("stade", "");
        trans.prepareExecution(null);
        trans.startThreads();
        // 等待执行完毕
        trans.waitUntilFinished();
    }
}
