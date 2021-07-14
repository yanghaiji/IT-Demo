package com.java.rest.template.controller;

import com.java.rest.template.util.RestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Objects;

/**
 * <p>
 *      测试
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Slf4j
@RestController
public class RestTmController {

    private final RestUtil restUtil;

    public RestTmController(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @GetMapping(value = "test")
    public void test(){
        String s = restUtil.get("http://baidu.com", null, null, String.class);
        System.out.println(s);
    }

    @GetMapping(value = "upload")
    public void upload(@RequestParam("file") MultipartFile files, HttpServletRequest request){
        String upload = restUtil.upload(new File(Objects.requireNonNull(files.getOriginalFilename())),
                "http://localhost:8081/upload/file", String.class);
        System.out.println(upload);
    }

    /**
     * 测试 rest template 通过 -Dserver.port=8081 参数改变端口，模拟两个服务的调用
     *
     * -Dserver.port=8081
     *
     * @param files
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "upload/file")
    public String fileUpload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws Exception {
        // 携带的其他参数可以使用 getParameter 方法接收
        String param1 = request.getParameter("param1");

        if (files == null) {
            return "文件上传失败";
        }
        for (MultipartFile file : files) {
            if (!file.isEmpty() && file.getSize() > 0) {
                String fileName = file.getOriginalFilename();
                // 参考 FileCopyUtils 这个工具类
                file.transferTo(new File("C:\\Users\\haiyang\\Desktop\\git\\" + fileName));
                log.info("文件:{} 上传成功...",fileName);
            }
        }
        return "文件上传成功";
    }

}
