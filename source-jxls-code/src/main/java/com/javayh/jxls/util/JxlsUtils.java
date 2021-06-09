package com.javayh.jxls.util;

import com.javayh.jxls.model.UserInfo;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-04
 */
public class JxlsUtils{

    private static List<UserInfo> generateSampleEmployeeData() throws ParseException {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        userInfos.add( new UserInfo(1, "12fawywhagwfqd", "1500", 15) );
        userInfos.add( new UserInfo(2, "12fawywhagwfqd", "2300", 25) );
        userInfos.add( new UserInfo(3, "12fawywhagwfqd", "2500", 10) );
        userInfos.add( new UserInfo(4, "12fawywhagwfqd", "1700", 15) );
        userInfos.add( new UserInfo(5, "12fawywhagwfqd", "2800", 20) );
        return userInfos;
    }

    /**
     * 简单的excel导出
     * @throws ParseException
     * @throws IOException
     */
    public static void out01() throws ParseException, IOException {
        List<UserInfo> employees = generateSampleEmployeeData();
        OutputStream os = new FileOutputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\object_collection.xlsx");
        InputStream is = new FileInputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\object_collection_template.xlsx");
        Context context = new Context();
        context.putVar("userInfos", employees);
        context.putVar("nowdate", new Date());
        JxlsHelper.getInstance().setUseFastFormulaProcessor(true)
                .processTemplate(is, os, context);
        os.close();
    }

    public static void outGroupExample() throws ParseException, IOException {
        List<UserInfo> employees = generateSampleEmployeeData();//group_example_collection
        OutputStream os =
                new FileOutputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\group_example_collection.xlsx");
        InputStream is =
                new FileInputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\group_example_collection_template.xlsx");
        Context context = new Context();
        context.putVar("userInfos", employees);
        context.putVar("nowdate", new Date());
        JxlsHelper.getInstance().setUseFastFormulaProcessor(true)
                .processTemplate(is, os, context);
        os.close();
    }


}
