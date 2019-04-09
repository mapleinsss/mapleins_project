package org.maple.mapreduce.exercise1.eachSubjectAvgScore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 10:59
 * @Description 求每门学科的平均成绩
 */
public class SubAvgDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"e:/dev/Hadoop/input","e:/dev/Hadoop/output"};

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setMapperClass(SubAvgMapper.class);
        job.setReducerClass(SubAvgReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean flag = job.waitForCompletion(true);
        System.exit(flag ? 0 : 1);

    }
}
