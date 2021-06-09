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

}
