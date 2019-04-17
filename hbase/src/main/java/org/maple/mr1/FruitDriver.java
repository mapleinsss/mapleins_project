package org.maple.mr1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @Author Mapleins
 * @Date 2019-04-16 23:27
 * @Description
 */
public class FruitDriver extends Configuration implements Tool {

    private Configuration conf = null;

    @Override
    public int run(String[] strings) throws Exception {

        Job job = Job.getInstance(conf);

        job.setJarByClass(FruitDriver.class);

        //指定 Mapper
        TableMapReduceUtil.initTableMapperJob("fruit", new Scan(), FruitMapper.class, ImmutableBytesWritable.class, Put.class, job);
        //指定 Reducer
        TableMapReduceUtil.initTableReducerJob("fruit_mr", FruitReducer.class, job);
        //提交
        boolean flag = job.waitForCompletion(true);
        return flag ? 0 : 1;
    }

    @Override
    public void setConf(Configuration configuration) {
        this.conf = configuration;
    }

    @Override
    public Configuration getConf() {
        return conf;
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        int i = ToolRunner.run(conf, new FruitDriver(), args);
        System.out.println(i);
    }
}
