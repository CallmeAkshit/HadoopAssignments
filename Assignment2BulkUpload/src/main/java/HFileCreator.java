import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat2;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;

public class HFileCreator {



    public static final String TABLE_NAME_TO_INSERT="peopleBulkUpload";

    public void createHFile(String inputPath) throws IOException, InterruptedException, ClassNotFoundException {


        Configuration configuration  =new Configuration();


        configuration.set("fs.defaultFS", "hdfs://localhost:8020/");
        configuration.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        configuration.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());


        Job job = Job.getInstance(configuration);
        Path output = new Path("hdfs://localhost:8020/dataDirectory/temp100");
        FileSystem hdfs = FileSystem.get(URI.create("hdfs://localhost:8020/dataDirectory/temp101"),configuration);

        if (hdfs.exists(output)) {                                      // delete existing directory
            hdfs.delete(output, true);
        }
        job.setJarByClass(HFileCreator.class);
        job.setJobName("Bulk Loading HBase Table::"+TABLE_NAME_TO_INSERT);
        job.setInputFormatClass(TextInputFormat.class);
        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        job.setMapperClass(HbaseMapper.class);
        FileInputFormat.addInputPaths(job, inputPath);

        FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:8020/dataDirectory/temp101/"));
        job.setMapOutputValueClass(Put.class);


        TableName tableName = TableName.valueOf("peopleBulkUpload");
        try (Connection conn = ConnectionFactory.createConnection(configuration);
             Table tablee = conn.getTable(tableName);
             RegionLocator regionLocator = conn.getRegionLocator(tableName)) {
            HFileOutputFormat2.configureIncrementalLoad(job, tablee, regionLocator);
        }

        boolean b = job.waitForCompletion(true);
        System.out.println(b);

        HBaseBulkLoad hBaseBulkLoad=new HBaseBulkLoad();
        hBaseBulkLoad.doBulkUpload(new Path("hdfs://localhost:8020/dataDirectory/temp101/"), tableName);

        if (job.isSuccessful()) {
            System.out.println("Bulk Load Successful");
        } else {

        }


    }
}
