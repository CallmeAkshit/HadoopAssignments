package com.akshitbansal.assignment2;

import com.akshitbansal.assignment1.HdfsToHBase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class ScanTable{


    public static final String encoding = "UTF-8";
    public static final String rootUrl = "hdfs://localhost:8020";
    public static String internalUrl = "/dataDirectory/Input";
    private static String columnFamily = "Name";
    private static Configuration config = new Configuration();

    private static void insertDataToHbase() throws Exception {

        Table table = null;
        Connection connection = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            HashMap<Integer, String> hm = HdfsToHBase.getColumnMapping();
            Configuration conf = HBaseConfiguration.create();
            connection = ConnectionFactory.createConnection(conf);
            table = connection.getTable(TableName.valueOf("People_Info"));
            File file = new File("/Users/akshitbansal/Desktop/temp.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

                for(int rowID=1; rowID<=100; rowID++)
                {
                    Get g = new Get(Bytes.toBytes(String.valueOf(rowID)));
                    Result result = table.get(g);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i <= 5; ++ i) {

                        sb.append(Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes(hm.get(i)))));
                        if (i == 5) {
                            sb.append(("\n"));
                            continue;
                        }
                        sb.append(",");
                    }

                    bufferedWriter.write(sb.toString());
                }
                //return;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(table != null)
                table.close();
            if(connection != null)
                connection.close();
            if(bufferedWriter != null)
                bufferedWriter.close();
        }
    }

    public static void main(String[] args) throws  Exception{
        insertDataToHbase();
    }
}

