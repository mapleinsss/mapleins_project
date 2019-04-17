package org.maple.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @Author Mapleins
 * @Date 2019-04-12 9:07
 * @Description
 */
public class Test1 {

    private static Admin admin = null;
    private static Connection connection = null;
    private static Configuration conf = null;

    static {
        //获取 HBase 配置文件
//        HBaseConfiguration conf = new HBaseConfiguration();
        conf = HBaseConfiguration.create();
        //设置zk
        conf.set("hbase.zookeeper.quorum", "hadoop102");
        //获取 HBase 管理员对象
//        HBaseAdmin admin = new HBaseAdmin(conf);
        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void close(Connection connection, Admin admin) {
        if (connection != null) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (admin != null) {
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断表是否存在
     *
     * @param tableName 表名
     * @return
     * @throws IOException
     */
    public static boolean tableExist(String tableName) throws IOException {
        boolean flag = admin.tableExists(TableName.valueOf(tableName));
        return flag;
    }

    /**
     * 创建表
     * @param tableName 表名
     * @param cfs       列族
     */
    public static void createTable(String tableName, String... cfs) throws IOException {
        if (tableExist(tableName)) {
            System.out.println("表已经存在");
            return;
        }
        //创建表描述器
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        //添加列族
        for (String cf : cfs) {
            //创建列描述器
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);
//            hColumnDescriptor.setMaxVersions(); 设置版本，不设置默认为1
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        //创建表
        admin.createTable(hTableDescriptor);
        System.out.println("表创建成功");
    }

    /**
     * 删除表
     *
     * @param tableName
     * @throws IOException
     */
    public static void deleteTable(String tableName) throws IOException {
        //删除表先使表不可用
        admin.disableTable(TableName.valueOf(tableName));
        //执行删除操作
        admin.deleteTable(TableName.valueOf(tableName));
        System.out.println("表以删除");
    }

    /**
     * 插入数据
     * @param tableName 表名
     * @param rowKey    主键
     * @param cf        列族
     * @param cn        列名
     * @param value     值
     * @throws IOException
     */
    public static void putData(String tableName, String rowKey, String cf, String cn, String value) throws IOException {
        // 获取 HTable 对象
//        HTable hTable = new HTable(conf,TableName.valueOf(tableName));
        Table hTable = connection.getTable(TableName.valueOf(tableName));
        // 创建 Put 对象
        Put put = new Put(Bytes.toBytes(rowKey));
        // 添加数据
        put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cn), Bytes.toBytes(value));
        // 添加操作
        hTable.put(put);
        // 关闭资源
        hTable.close();
    }

    /**
     * 删除表数据
     *
     * @param tableName 表名
     * @param rowKey    键
     * @param cf        列族
     * @param cn        列
     * @throws IOException
     */
    public static void delete(String tableName, String rowKey, String cf, String cn) throws IOException {
        // 获取 table 对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        // 创建 delete 对象
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        //byte [] family, byte [] qualifier, long timestamp 重载的方法，如果不加时间戳 删除最近的，加了删除时间戳版本
//        delete.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cn)); //会出现问题，例如只有一个版本的情况下，添加了一条数据覆盖了之前的数据，然后执行删除，此时再查，会显示之前被覆盖的数据
        //删除所有版本的
        delete.addColumns(Bytes.toBytes(cf), Bytes.toBytes(cn));
        // 删除操作
        table.delete(delete);
        // 关闭资源
        table.close();
    }

    //查

    /**
     * 全表扫描，不能根据版本号查询
     *
     * @param tableName 表名
     * @throws IOException
     */
    public static void scanTable(String tableName) throws IOException {
        // 获取 table 对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        // 构建扫描器
        Scan scan = new Scan();
        //可以设置起始位置和结束位置
//        scan.setStartRow(Bytes.toBytes(1));
//        scan.setStopRow(Bytes.toBytes(2));
        ResultScanner scanner = table.getScanner(scan);
        // 遍历 rowKey
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            // 遍历 单元格
            for (Cell cell : cells) {
                String rowKey = Bytes.toString(CellUtil.cloneRow(cell));
                String family = Bytes.toString(CellUtil.cloneFamily(cell));
                String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
                String value = Bytes.toString(CellUtil.cloneValue(cell));
                System.out.println("rowKey:" + rowKey + " family:" + family + " qualifier:" + qualifier + " value:" + value);
            }
        }
        table.close();
    }


    /**
     * 获取指定列和列族的数据
     * @param tableName 表名
     * @param rowKey 键
     * @param cf 列族
     * @param cn 列
     * @throws IOException
     */
    public static void getData(String tableName, String rowKey, String cf, String cn) throws IOException {
        // 获取 table 对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        // 获取 get 对象
        Get get = new Get(Bytes.toBytes(rowKey));
        // 指定到列族
//        get.addFamily(Bytes.toBytes(cf));
        //  指定列族和列
        get.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn));
        // 设置版本
//        get.setMaxVersions();
        Result result = table.get(get);
        Cell[] cells = result.rawCells();
        // 遍历 单元格
        for (Cell cell : cells) {
            String rk = Bytes.toString(CellUtil.cloneRow(cell));
            String family = Bytes.toString(CellUtil.cloneFamily(cell));
            String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value = Bytes.toString(CellUtil.cloneValue(cell));
            System.out.println("----------------------rowKey:" + rk + " family:" + family + " qualifier:" + qualifier + " value:" + value);
        }

    }


    public static void main(String[] args) throws Exception {

        //tableExist
//        System.out.println(tableExist("student"));
//        System.out.println(tableExist("tableName"));

//        createTable("employees","person");

//        deleteTable("employees");

//        putData("stuff","1001","info","name","lisi");

//        delete("stuff", "1001", "info", "name");

//        scanTable("student");

        getData("student","1","info","name");

        close(connection, admin);

    }
}
