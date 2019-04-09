package org.maple.mapreduce.exercise1.eachSubjectAvgScore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 10:59
 * @Description
 */
public class SubAvgMapper extends Mapper<LongWritable, Text, Text, Text> {

    Text k = new Text("chinese math english");
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] split = line.split(",");
        long chinese = Long.valueOf(split[1]);
        long math = Long.valueOf(split[2]);
        long english = Long.valueOf(split[3]);
        v.set(chinese + "-" + math + "-" + english);
        context.write(k, v);

    }
}
