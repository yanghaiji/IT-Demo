package com.javayh.hadoop;

import com.javayh.hadoop.config.HadoopTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HdfsController {

    @Autowired
    private HadoopTemplate hadoopTemplate;

    /**
     * 将本地文件srcFile,上传到hdfs
     * @param srcFile
     * @return
     */
    @PostMapping("/upload")
    public String upload(String srcFile){
        hadoopTemplate.uploadFile(srcFile);
        return "copy";
    }

    @DeleteMapping("/delFile")
    public String del(@RequestParam String fileName){
        hadoopTemplate.delFile(fileName);
        return "delFile";
    }

    @GetMapping("/download")
    public String download(@RequestParam String fileName,@RequestParam String savePath){
        hadoopTemplate.download(fileName,savePath);
        return "download";
    }
}