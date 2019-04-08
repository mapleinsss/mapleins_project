package org.maple.mapreduce.flowsum;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-08 23:29
 * @Description
 */
public class FlowCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        args = new String[]{"mapreduce/input","mapreduce/output"};

        Configuration conf = new Configuration();
        //1.获取 Job 对象
        Job job = Job.getInstance(conf);
        //2.设置 Jar 存储位置
        job.setJarByClass(FlowCountDriver.class);
        //3.关联 Map 和 Reduce 类
        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);
        //4.设置 Mapper 阶段输出的 key 和 value 类型
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        //5.设置最终数据输出的 key 和 value 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        //6.设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //7.提交job
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
