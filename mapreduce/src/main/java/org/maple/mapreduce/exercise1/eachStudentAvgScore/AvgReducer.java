package org.maple.mapreduce.exercise1.eachStudentAvgScore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 10:34
 * @Description
 */
public class AvgReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        for (LongWritable value : values) {
            context.write(key, value);
        }
    }
}
