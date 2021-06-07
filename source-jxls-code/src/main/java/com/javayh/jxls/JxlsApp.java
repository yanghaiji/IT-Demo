package com.javayh.jxls;

import com.javayh.jxls.model.UserInfo;
import com.javayh.jxls.util.JxlsUtils;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

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
public class JxlsApp {
    static Logger logger = LoggerFactory.getLogger(JxlsApp.class);

    public static void main(String[] args) throws ParseException, IOException {
        logger.info("Running Object Collection demo");

        UserInfo.out01();
        return;
    }

}
