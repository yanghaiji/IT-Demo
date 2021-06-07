package com.javayh.jxls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private int id;
    private String name;
    private String pwd;
    private int age;


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

    private static List<UserInfo> generateSampleEmployeeData() throws ParseException {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        userInfos.add( new UserInfo(1, "12fawywhagwfqd", "1500", 15) );
        userInfos.add( new UserInfo(2, "12fawywhagwfqd", "2300", 25) );
        userInfos.add( new UserInfo(3, "12fawywhagwfqd", "2500", 10) );
        userInfos.add( new UserInfo(4, "12fawywhagwfqd", "1700", 15) );
        userInfos.add( new UserInfo(4, "12fawywhagwfqd", "2800", 20) );
        return userInfos;
    }
}
