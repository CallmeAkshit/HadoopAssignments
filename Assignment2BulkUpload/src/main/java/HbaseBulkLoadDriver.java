import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

public class HbaseBulkLoadDriver extends Configured implements Tool {

    public static final String TABLE_TO_READ_FROM="People_Info";
    public static final String TABLE_NAME_TO_INSERT="peopleBulkUpload";

    public static void main(String[] args) {
        try {

            int response = ToolRunner.run(HBaseConfiguration.create(), new HbaseBulkLoadDriver(),new String[]{""});
            if(response == 0) {
                System.out.println("Job is successfully completed...");
            } else {
                System.out.println("Job failed...");
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }


    // This function reads data from hbase using MR job and loads it into a file in hdfs
    @Override
    public int run(String[] strings) throws Exception {
        Configuration configuration  =new Configuration();

        configuration.set("fs.defaultFS", "hdfs://localhost:8020/");
        configuration.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        configuration.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Job job = Job.getInstance(configuration);


        Path output = new Path("hdfs://localhost:8020/dataDirectory/temp100");
        FileSystem hdfs = FileSystem.get(URI.create("hdfs://localhost:8020/dataDirectory/temp100"),configuration);

        if (hdfs.exists(output)) {                                      // delete existing directory
            hdfs.delete(output, true);
        }


        Scan scan = new Scan();
        scan.setCaching(500);
        scan.setCacheBlocks(false);

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("hdfs://localhost:8020/dataDirectory/temp100"));

        job.setReducerClass(HdfsReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        TableMapReduceUtil.initTableMapperJob(TableName.valueOf("People_Info"),
                scan,
                HdfsMapper.class,
                ImmutableBytesWritable.class,
                Result.class,
                job);


        boolean b = job.waitForCompletion(true);
        System.out.println(job.isSuccessful());

        if(job.isSuccessful()){
            HFileCreator hFileCreator=new HFileCreator();
            hFileCreator.createHFile("hdfs://localhost:8020/dataDirectory/temp100/part-r-00000");
        }

       return b?0:1;

    }
}
