package org.maple.mr2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @Author Mapleins
 * @Date 2019-04-17 22:38
 * @Description
 */
public class HDFSDriver extends Configuration implements Tool {

    Configuration configuration = new Configuration();

    @Override
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(configuration);
        //设置主类
        job.setJarByClass(HDFSDriver.class);
        //设置 mapper
        job.setMapperClass(HDFSMapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Put.class);
        //设置 reducer
        TableMapReduceUtil.initTableReducerJob("fruit2", HDFSReducer.class, job);
        //设置 输入路径
        FileInputFormat.setInputPaths(job,args[0]);
        //提交任务
        boolean flag = job.waitForCompletion(true);
        return flag ? 0 : 1;
    }

    @Override
    public void setConf(Configuration conf) {
        this.configuration = conf;
    }

    @Override
    public Configuration getConf() {
        return configuration;
    }

    public static void main(String[] args) throws Exception {
        Configuration configuration = HBaseConfiguration.create();
        int i = ToolRunner.run(configuration, new HDFSDriver(), args);
        System.exit(i);
    }
}
