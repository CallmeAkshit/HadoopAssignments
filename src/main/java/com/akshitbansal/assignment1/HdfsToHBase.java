package com.akshitbansal.assignment1;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.net.URI;
import java.util.HashMap;

public class HdfsToHBase {

    public static final String encoding = "UTF-8";
    public static final String rootUrl = "hdfs://localhost:8020";
    public static String internalUrl = "/dataDirectory/Input";
    private static String columnFamily = "Name";
    private static Configuration config = new Configuration();

    public static String getPath(String url) {
        return rootUrl + url;
    }

    private static void insertDataToHbase(String[] record,
                                          int rowId,
                                          HashMap<Integer, String> hm) throws Exception {

        Table table = null;
        Connection connection = null;
        try
        {
            Configuration conf = HBaseConfiguration.create();
            connection = ConnectionFactory.createConnection(conf);
            table = connection.getTable(TableName.valueOf("People_Info"));
            Put p = new Put(Bytes.toBytes(String.valueOf(rowId)));
            for(int i = 0; i < record.length; ++ i) {
                String qualifier = hm.get(i);
                if(qualifier != null)
                p.addColumn(Bytes.toBytes(columnFamily),
                        Bytes.toBytes(qualifier),
                        Bytes.toBytes(record[i]));
            }

            table.put(p);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(table != null)
                table.close();
            if(connection != null)
                connection.close();
        }
    }

    private static FileSystem getInputFileSystem() throws Exception {
        try {
            FileSystem fs = FileSystem.get(new URI(rootUrl),config);
            return fs;
        } catch (Exception e) {
            throw new Exception("Invalid HDFS path");
        }
    }

    private static void storeDataInHbase(FileSystem hdfs,
                                         String uri,
                                         HashMap<Integer, String> hm) throws Exception{

        config.set("fs.defaultFS", rootUrl);
        FileSystem fileSystem = FileSystem.get(config);
        FileStatus[] fileStatus = hdfs.listStatus(new Path(uri));
        Path[] paths  = FileUtil.stat2Paths(fileStatus);
        int rowId = 1;
        for(Path path : paths) {
            FSDataInputStream inputStream = fileSystem.open(path);
            String out = IOUtils.toString(inputStream, encoding).split("\n")[1];
            String[] record = out.split(",");
            insertDataToHbase(record,rowId, hm);
            rowId++;
            inputStream.close();
        }
        fileSystem.close();
    }

    public static HashMap<Integer, String> getColumnMapping() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(0, "Name");
        hm.put(1, "Age");
        hm.put(2, "Company");
        hm.put(3, "Building_code");
        hm.put(4, "Phone_Number");
        hm.put(5, "Address");
        return hm;
    }

    public static void main(String[] args) throws Exception {

       FileSystem fs = getInputFileSystem();
       String uri = getPath(internalUrl);
       HashMap<Integer, String> hm = getColumnMapping();
       storeDataInHbase(fs, uri, hm);
    }
}
