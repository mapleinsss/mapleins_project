package org.maple.mapreduce.exercise1.eachSubjectAvgScore;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-09 11:13
 * @Description
 */
public class SubAvgReducer extends Reducer<Text, Text, Text, Text> {

    Text k = new Text();
    Text v = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        int c = 0;
        int m = 0;
        int e = 0;
        int count = 0;
        for (Text value : values) {
            String line = value.toString();
            String[] split = line.split("-");
            c += Integer.valueOf(split[0]);
            m += Integer.valueOf(split[1]);
            e += Integer.valueOf(split[2]);
            count ++;
        }
        int [] intArr = {c/count,m/count,e/count};
        String keys = key.toString();
        String[] sub = keys.split(" ");

        for (int i = 0; i <3; i++){
            k.set(sub[i]);
            v.set(String.valueOf(intArr[i]));
            context.write(k,v);
        }

    }
}
