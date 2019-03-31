package org.maple.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Mapleins
 * @create 2019-03-31 22:43
 * @description Reduce 阶段
 * Reduce 参数
 *      KEYIN：map 阶段输出的 key
 *      VALUEIN：map 阶段输出的 value
 *      KEYOUT：输出到文件 key 的类型
 *      VALUEOUT：输出到文件 value 的类型
 */
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {

    IntWritable intWritable = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //1.累加求和
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        //2.写出
        intWritable.set(sum);
        context.write(key,intWritable);
    }
}
