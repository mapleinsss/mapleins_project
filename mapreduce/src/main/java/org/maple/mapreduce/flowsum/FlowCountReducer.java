package org.maple.mapreduce.flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-08 23:23
 * @Description
 */
public class FlowCountReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    FlowBean flowBean = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        //1.累加求和
        long sum_upFlow = 0;
        long sum_downFlow = 0;

        for (FlowBean value : values) {
            sum_upFlow += value.getUpFlow();
            sum_downFlow += value.getDownFlow();
        }

        flowBean.setUpFlow(sum_upFlow);
        flowBean.setDownFlow(sum_downFlow);
        flowBean.setSumFlow(sum_downFlow+sum_upFlow);
        //2.写出
        context.write(key,flowBean);

    }
}
