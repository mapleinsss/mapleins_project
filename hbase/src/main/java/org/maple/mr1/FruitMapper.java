package org.maple.mr1;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-16 22:35
 * @Description
 */

/**
 * TableMapper<KEYOUT, VALUEOUT> extends Mapper<ImmutableBytesWritable, Result, KEYOUT, VALUEOUT>
 *     这里的前两个参数是写死的
 *      ImmutableBytesWritable：是rowkey
 *      Result:是值
 *      所以我们 map 阶段可以直接输出同样的keyout
 */
public class FruitMapper extends TableMapper<ImmutableBytesWritable, Put> {

    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {
        // 构建put对象
        Put put = new Put(key.get());

        Cell[] cells = value.rawCells();

        for (Cell cell : cells) {
            if("name".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))){
                put.add(cell);
            }
        }
        context.write(key,put);
    }
}
