package org.maple.mr2;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-17 22:38
 * @Description
 */
public class HDFSReducer extends TableReducer<NullWritable, Put,NullWritable> {

    @Override
    protected void reduce(NullWritable key, Iterable<Put> values, Context context) throws IOException, InterruptedException {
        for (Put value : values) {
            context.write(NullWritable.get(),value);
        }
    }
}
