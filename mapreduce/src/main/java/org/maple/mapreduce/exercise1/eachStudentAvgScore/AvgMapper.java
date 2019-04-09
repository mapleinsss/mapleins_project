package org.maple.mapreduce.exercise1.eachStudentAvgScore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 10:25
 * @Description
 */
public class AvgMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    Text k = new Text();
    LongWritable v = new LongWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String val = value.toString();
        String[] split = val.split(",");
        String name = split[0];
        long chinese = Long.valueOf(split[1]);
        long math = Long.valueOf(split[2]);
        long english = Long.valueOf(split[3]);
        long avg = (chinese + math + english) / 3;
        k.set(name);
        v.set(avg);
        context.write(k,v);
    }
}
