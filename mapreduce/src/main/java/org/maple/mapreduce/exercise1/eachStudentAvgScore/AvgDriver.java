package org.maple.mapreduce.exercise1.eachStudentAvgScore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 10:38
 * @Description 算出每个学生的平均成绩
 */
public class AvgDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"e:/dev/Hadoop/input","e:/dev/Hadoop/output"};

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setMapperClass(AvgMapper.class);
        job.setReducerClass(AvgReducer.class);
        job.setJarByClass(AvgDriver.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }

}
