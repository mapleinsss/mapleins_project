package org.maple.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Mapleins
 * @create 2019-03-31 22:26
 * @description map 阶段
 * Mapper 参数
 *      KEYIN：输入数据的 key 类型
 *      VALUEIN：输入数据的 value 类型
 *      KEYOUT：输出数据的 key 类型
 *      VALUEOUT：输出的数据 value 类型
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    Text text = new Text();
    IntWritable intWritable = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.Alen Alex：第一行的数据 输入的为 Text，转换成 String 方便操作
        String line = value.toString();
        //2.切分单词
        String[] words = line.split(" ");
        //3.循环写出
        for (String word : words) {
            //写出使用 context.write(key,value)
            text.set(word); //单词 String 转换为 Text
            context.write(text,intWritable);
        }
    }

}
