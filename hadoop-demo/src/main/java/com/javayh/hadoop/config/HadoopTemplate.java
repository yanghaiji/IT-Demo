package com.javayh.hadoop.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@ConditionalOnClass(FileSystem.class)
@Slf4j
public class HadoopTemplate {

    @Autowired
    private FileSystem fileSystem;

    @Value("${hadoop.name-node}")
    private String nameNode;

    @Value("${hadoop.namespace:/}")
    private String nameSpace;

    @PostConstruct
    public void init(){
        existDir(nameSpace,true);
    }

    public void uploadFile(String srcFile){
        copyFileToHDFS(false,true,srcFile,nameSpace);
    }

    public void uploadFile(boolean del,String srcFile){
        copyFileToHDFS(del,true,srcFile,nameSpace);
    }

    public void uploadFile(String srcFile,String destPath){
        copyFileToHDFS(false,true,srcFile,destPath);
    }

    public void uploadFile(boolean del,String srcFile,String destPath){
        copyFileToHDFS(del,true,srcFile,destPath);
    }

    public void delFile(String fileName){
        rmdir(nameSpace,fileName) ;
    }

    public void delDir(String path){
        nameSpace = nameSpace + "/" +path;
        rmdir(path,null) ;
    }

    public void download(String fileName,String savePath){
        getFile(nameSpace+"/"+fileName,savePath);
    }


    /**
     * 判断nameSpace 目录是否存在，如果不存在就创建该目录
     * @param filePath
     * @param create
     * @return
     */
    public boolean existDir(String filePath, boolean create){
        boolean flag = false;
        if(StringUtils.isEmpty(filePath)){
            throw new IllegalArgumentException("filePath不能为空");
        }
        try{
            Path path = new Path(filePath);
            if (create){
                if (!fileSystem.exists(path)){
                    fileSystem.mkdirs(path);
                }
            }
            if (fileSystem.isDirectory(path)){
                flag = true;
            }
        }catch (Exception e){
            log.error("", e);
        }
        return flag;
    }




    /**
     * 文件上传至 HDFS
     * @param delSrc       指是否删除源文件，true为删除，默认为false
     * @param overwrite    是否重写
     * @param srcFile      源文件，上传文件路径
     * @param destPath     hdfs的目的路径
     */
    public  void copyFileToHDFS(boolean delSrc, boolean overwrite,String srcFile,String destPath) {
        // 源文件路径是Linux下的路径，如果在 windows 下测试，需要改写为Windows下的路径，比如D://hadoop/djt/weibo.txt
        Path srcPath = new Path(srcFile);
        log.info("@@@@@ 上传文件路径："+srcFile);
        // 目的路径
        if(StringUtils.isNotBlank(nameNode)){
            destPath = nameNode + destPath;
        }
        Path dstPath = new Path(destPath);
        // 实现文件上传
        try {
            // 获取FileSystem对象
            //fileSystem.copyFromLocalFile(srcPath, dstPath);
            log.info("@@@@@ 开始上传");
            fileSystem.copyFromLocalFile(delSrc,overwrite,srcPath, dstPath);
            log.info("@@@@@ 上传完成");
            //释放资源
            //    fileSystem.close();
        } catch (IOException e) {
            log.error("", e);
        }
    }


    /**
     * 删除文件或者文件目录
     *
     * @param path
     */
    public void rmdir(String path,String fileName) {
        try {
            // 返回FileSystem对象
            if(StringUtils.isNotBlank(nameNode)){
                path = nameNode + path;
            }
            if(StringUtils.isNotBlank(fileName)){
                path =  path + "/" +fileName;
            }
            // 删除文件或者文件目录  delete(Path f) 此方法已经弃用
            fileSystem.delete(new Path(path),true);
        } catch (IllegalArgumentException | IOException e) {
            log.error("", e);
        }
    }

    /**
     * 从 HDFS 下载文件
     *
     * @param hdfsFile
     * @param destPath 文件下载后,存放地址
     */
    public void getFile(String hdfsFile,String destPath) {
        // 源文件路径
        if(StringUtils.isNotBlank(nameNode)){
            hdfsFile = nameNode + hdfsFile;
        }
        Path hdfsPath = new Path(hdfsFile);
        Path dstPath = new Path(destPath);
        try {
            // 下载hdfs上的文件
            log.info("@@@@@ 开始下载");
            fileSystem.copyToLocalFile(hdfsPath, dstPath);
            log.info("@@@@@ 下载完成");
            // 释放资源
            // fs.close();
        } catch (IOException e) {
            log.error("", e);
        }
    }

    public String getNameSpace(){
        return nameSpace;
    }

}