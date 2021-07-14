package com.javayh.jxls.util;

import com.javayh.jxls.model.Department;
import com.javayh.jxls.model.Employee;
import com.javayh.jxls.model.UserInfo;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
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
public class JxlsUtils {

    private static List<UserInfo> generateSampleEmployeeData() throws ParseException {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        userInfos.add(new UserInfo(1, "12fawywhagwfqd", "1500", 15));
        userInfos.add(new UserInfo(2, "12fawywhagwfqd", "2300", 25));
        userInfos.add(new UserInfo(3, "12fawywhagwfqd", "2500", 10));
        userInfos.add(new UserInfo(4, "12fawywhagwfqd", "1700", 15));
        userInfos.add(new UserInfo(5, "12fawywhagwfqd", "2800", 20));
        return userInfos;
    }

    /**
     * 简单的excel导出
     *
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
        is.close();
    }

    public static void multi_sheet_markup_demo() throws IOException {
        OutputStream os =
                new FileOutputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\multisheet_markup.xlsx");
        InputStream is =
                new FileInputStream("C:\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\multisheet_markup_template.xlsx");
        List<Department> departments = createDepartments();
        try (is; os) {
            Context context = PoiTransformer.createInitialContext();
            context.putVar("departments", departments);
            context.putVar("sheetNames", Arrays.asList(
                    departments.get(0).getName(),
                    departments.get(1).getName(),
                    departments.get(2).getName()));
            JxlsHelper.getInstance().processTemplate(is, os, context);
        }
    }

    private static List<Department> createDepartments() {
        List<Department> departments = new ArrayList<>();
        Department department = new Department();
        department.setLink("http://github.com");
        department.setName("Derek");
        department.setChief(new Employee("Git", 28, 2500.00, 2300.00, new Date()));
        List<Employee> staff = new ArrayList<>();
        staff.add((new Employee("Git", 28, 1500.00, 1300.00, new Date())));
        staff.add((new Employee("GITHUB", 28, 3500.00, 1500.00, new Date())));
        staff.add((new Employee("Yanghaiji", 28, 2500.00, 2300.00, new Date())));
        staff.add((new Employee("Dylan", 28, 2500.00, 2500.00, new Date())));
        department.setStaff(staff);
        departments.add(department);

        Department department1 = new Department();
        department1.setLink("http://github.com");
        department1.setName("GIT");
        department1.setChief(new Employee("Git", 28, 2500.00, 2300.00, new Date()));
        List<Employee> staff1 = new ArrayList<>();
        staff1.add((new Employee("Git", 28, 1500.00, 1300.00, new Date())));
        staff1.add((new Employee("GITHUB", 28, 3500.00, 1500.00, new Date())));
        staff1.add((new Employee("Yanghaiji", 28, 2500.00, 2300.00, new Date())));
        staff1.add((new Employee("Dylan", 28, 2500.00, 2500.00, new Date())));
        department1.setStaff(staff1);
        departments.add(department1);

        Department department2 = new Department();
        department2.setLink("http://github.com");
        department2.setName("HUB");
        department2.setChief(new Employee("Git", 28, 2500.00, 2300.00, new Date()));
        List<Employee> staff2 = new ArrayList<>();
        staff2.add((new Employee("Git", 28, 1500.00, 1300.00, new Date())));
        staff2.add((new Employee("GITHUB", 28, 3500.00, 1500.00, new Date())));
        staff2.add((new Employee("Yanghaiji", 28, 2500.00, 2300.00, new Date())));
        staff2.add((new Employee("Dylan", 28, 2500.00, 2500.00, new Date())));
        department2.setStaff(staff2);
        departments.add(department2);
        return departments;
    }

    public static void outIf() throws ParseException, IOException {
        List<UserInfo> userInfos = generateSampleEmployeeData();//group_example_collection
        OutputStream os =
                new FileOutputStream("C:\\Dylan\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\if_collection.xlsx");
        InputStream is =
                new FileInputStream("C:\\Dylan\\javayh-demo\\source-jxls-code\\src\\main\\resources\\template\\if_collection_template.xlsx");
        Context context = PoiTransformer.createInitialContext();
        context.putVar("userInfos", userInfos);
        JxlsHelper.getInstance().processTemplate(is, os, context);
        os.close();
        is.close();
    }
}
