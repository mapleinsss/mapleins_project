package org.maple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * @author Mapleins
 * @create 2019-03-19 21:54
 * @description 文件定位下载 ，以 hadoop-2.7.2.tar.gz 为例，有两块
 */
public class HDFSFileSeek {

    /**
     * 下载第一块，大小为128M
     * @throws Exception
     */
    @Test
    public void readFileSeekPartOne() throws Exception{
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //获取输入流，将 hdfs 中的文件写入内存
        FSDataInputStream fis = fileSystem.open(new Path("/hadoop-2.7.2.tar.gz"));
        //获取输出流
        FileOutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz.part1"));
        //流的对拷
        byte[] bytes = new byte[1024];
        for (int i = 0; i < 1024*128; i++) { //只读取128M
            fis.read(bytes);
            fos.write(bytes);
        }
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fileSystem.close();
    }

    /**
     * 下载第二块
     */
    @Test
    public void readFileSeekPartTwo() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //获取输入流，将 hdfs 中的文件写入内存
        FSDataInputStream fis = fileSystem.open(new Path("/hadoop-2.7.2.tar.gz"));
        //设置指定读取的起点
        fis.seek(1024*1024*128);
        //获取输出流
        FileOutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz.part2"));
        //流的对拷
        IOUtils.copyBytes(fis,fos,configuration);
        //关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fileSystem.close();
    }
}
