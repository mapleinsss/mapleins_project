package org.maple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * @author Mapleins
 * @create 2019-03-19 21:46
 * @description 通过IO流实现文件的上传和下载
 */
public class HDFSFileIO {

    /**
     * 把 e 盘的 hello.txt 上传到 HDFS 的根目录
     */
    @Test
    public void putFileToHDFS() throws Exception{
        Configuration configuration = new Configuration();
        //1.获取对象
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //2.获取输入流
        FileInputStream fis = new FileInputStream(new File("e:/hello.txt"));
        //3.获取输出流
        FSDataOutputStream fos = fs.create(new Path("/helloIO.txt"));
        //4.流的对拷
        IOUtils.copyBytes(fis,fos,configuration);
        //5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    /**
     * 从 HDFS 下载 hello.txt 到 e 盘上
     */
    @Test
    public void getFileFromHDFS() throws Exception {
        Configuration configuration = new Configuration();
        //1.获取对象
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //2.获取输入流
        FSDataInputStream fis = fs.open(new Path("/helloIO.txt"));
        //3.获取输出流
        FileOutputStream fos = new FileOutputStream(new File("e:/helloIO.txt"));
        //4.流的对拷
        IOUtils.copyBytes(fis,fos,configuration);
        //5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }
}
