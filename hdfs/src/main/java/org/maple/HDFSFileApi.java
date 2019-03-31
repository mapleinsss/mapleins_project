package org.maple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.net.URI;

/**
 * @author Mapleins
 * @create 2019-03-19 21:26
 * @description hdfs 客户端操作 包括 文件上传、文件下载、删除、改名、详情查看 以及 文件文件夹的判断
 */
public class HDFSFileApi {

    /**
     * 文件的上传操作
     */
    @Test
    public void testCopyFromLocalFile() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        fs.copyFromLocalFile(new Path("e:/hello.txt"), new Path("/helloWorld.txt")); //上传到根目录，斜杠后面跟的是新的文件名称
        fs.close();
    }

    /**
     * 文件下载
     */
    @Test
    public void testCopyToLocalFile() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //fs.copyToLocalFile(new Path("/helloWorld.txt"),new Path("e:/helloWorld.txt"));
        /*
         * @param delSrc 是否删除源文件
         *          whether to delete the src
         * @param src
         *          path
         * @param dst
         *          path
         * @param useRawLocalFileSystem 是否关闭本地校验
         *          whether to use RawLocalFileSystem as local file system or not.
         */
        fs.copyToLocalFile(false, new Path("/helloWorld.txt"), new Path("e:/helloWorld.txt"), true);
        fs.close();
    }

    /**
     * 文件删除
     */
    @Test
    public void testDelete() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
    /*
        @Param1 路径
        @Param2 是否递归删除，文件必须是true
     */
        fs.delete(new Path("/hello.txt"), true);
        fs.close();
    }

    /**
     * 文件名更改
     */
    @Test
    public void testRename() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        fs.rename(new Path("/helloWorld.txt"), new Path("/hello.txt"));
        fs.close();
    }

    /**
     * 文件详情查看
     */
    @Test
    public void testListFile() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //查看文件信息
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next(); //文件状态信息
            //文件名称
            System.out.println("文件名称:" + fileStatus.getPath().getName());
            //文件权限
            System.out.println("文件权限" + fileStatus.getPermission());
            //获取文件长度
            System.out.println("文件长度" + fileStatus.getLen());
            //获取文件块信息,存储位置
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                StringBuilder sb = new StringBuilder();
                for (String host : hosts) {
                    sb.append(host + " ---");
                }
                System.out.println("存放的主机在:" + sb);
            }
            System.out.println("-----------next-------------");
        }
        fs.close();
    }

    /**
     * 文件和文件夹判断
     */
    @Test
    public void testListStatus() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "root");
        //判断操作
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isFile()) {//文件
                System.out.println("file:" + fileStatus.getPath().getName());
            } else {//文件夹
                System.out.println("dir:" + fileStatus.getPath().getName());
            }
        }
        fs.close();
    }

}