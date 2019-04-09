package org.maple.mapreduce.flowsum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-08 23:14
 * @Description
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    Text k = new Text();
    FlowBean v = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.获取一行
        String line = value.toString();
        //2.切割 \t
        String[] fields = line.split("\t");
        //3.封装对象
        k.set(fields[1]);//封装手机号
        long upFlow = Long.parseLong(fields[3]);
        long downFlow = Long.parseLong(fields[4]);
        v.setUpFlow(upFlow);
        v.setDownFlow(downFlow);
        //4.写出
        context.write(k,v);

    }
}
