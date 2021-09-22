import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

import java.util.ArrayList;
import java.util.List;

public class JoinJob extends Configured implements Tool {

    public static final String TABLE_NAME_TO_INSERT_ENRICHED_DATA = "empl";

    public static void main(String[] args) throws Exception {
        JoinJob runJob = new JoinJob();
        runJob.run(args);
    }

    @Override
    public int run(String[] arg0) throws Exception {

        List<Scan> scans = new ArrayList<Scan>();

        Scan scan1 = new Scan();
        scan1.setAttribute("scan.attributes.table.name", Bytes.toBytes("emplo"));
        //System.out.println(scan1.getAttribute("scan.attributes.table.name"));
        scans.add(scan1);

        Scan scan2 = new Scan();
        scan2.setAttribute("scan.attributes.table.name", Bytes.toBytes("buildi"));
        //System.out.println(scan2.getAttribute("scan.attributes.table.name"));
        scans.add(scan2);

        Configuration conf = new Configuration();

        Job job = new Job(conf);
        job.setJarByClass(JoinJob.class);


        TableMapReduceUtil.initTableMapperJob(
                scans,
                JoinMapper.class,
                IntWritable.class,
                Result.class,
                job);
        TableMapReduceUtil.initTableReducerJob(
                TABLE_NAME_TO_INSERT_ENRICHED_DATA,
                JoinReducer.class,
                job);
        boolean b = job.waitForCompletion(true);
        System.out.println(b);
        if (job.isSuccessful()) {
            System.out.println("Cafeteria code added to employee table");
        }
        return 0;
    }
}