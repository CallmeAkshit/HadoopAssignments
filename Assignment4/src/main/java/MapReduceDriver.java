import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat2;
import org.apache.hadoop.hbase.tool.BulkLoadHFiles;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;


public class MapReduceDriver {

    public static final String EMPLOYEE_TABLE_NAME = "emplo";
    public static final String BUILDING_TABLE_NAME = "buildi";


    public static final String EMPLOYEE_HFILE_OUTPUT_PATH = "hdfs://localhost:8020/dataDirectory/employee_hfile/";
    public static final String BUILDING_HFILE_OUTPUT_PATH = "hdfs://localhost:8020/dataDirectory/building_hfile/";
    public static final String EMPLOYEE_HDFS_INPUT_PATH = Driver.EMPLOYEE_HDFS_OUTPUT_PATH;
    public static final String BUILDING_HDFS_INPUT_PATH = Driver.BUILDING_HDFS_OUTPUT_PATH;
    public static final String DEFAULT_FS = "fs.defaultFS";
    private static final String HDFS_INPUT_URL = "hdfs://localhost:8020/";
    private static final String HDFS_IMPL = "fs.hdfs.impl";
    private static final String FILE_IMPL = "fs.file.impl";
    private static final String BULK_LOADING_MESSAGE = "Bulk Loading HBase Table::";


    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Class<EmployeeMapper> employeeMapperClass = EmployeeMapper.class;
        Class<BuildingMapper> buildingMapperClass = BuildingMapper.class;
        driver(EMPLOYEE_TABLE_NAME, EMPLOYEE_HDFS_INPUT_PATH, EMPLOYEE_HFILE_OUTPUT_PATH, employeeMapperClass,null);
        driver(BUILDING_TABLE_NAME, BUILDING_HDFS_INPUT_PATH, BUILDING_HFILE_OUTPUT_PATH, null,buildingMapperClass);
    }

    public static void driver(String tableToInsert, String hdfsInputPath, String hfileOutputPath, Class<EmployeeMapper> employeeMapperClass,Class<BuildingMapper> buildingMapperClass) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration configuration = new Configuration();


        configuration.set(DEFAULT_FS, HDFS_INPUT_URL);
        configuration.set(HDFS_IMPL, org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        configuration.set(FILE_IMPL, org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Path output = new Path(hfileOutputPath);
        FileSystem hdfs = FileSystem.get(URI.create(hfileOutputPath), configuration);

        if (hdfs.exists(output)) {                                      // delete existing directory
            hdfs.delete(output, true);
        }
        Job job = Job.getInstance(configuration);

        job.setJarByClass(MapReduceDriver.class);
        job.setJobName(BULK_LOADING_MESSAGE + tableToInsert);
        job.setInputFormatClass(WholeFileInputFormat.class);
        //job.setInputFormatClass(TextInputFormat.class);

        //TextInputFormat.setInputPaths(job, hdfsInputPath);
        FileInputFormat.setInputPaths(job, hdfsInputPath);

        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        if(employeeMapperClass!=null)
            job.setMapperClass(employeeMapperClass);
        else
            job.setMapperClass(buildingMapperClass);


        FileOutputFormat.setOutputPath(job, new Path(hfileOutputPath));
        job.setMapOutputValueClass(Put.class);


        TableName tableName = TableName.valueOf(tableToInsert);
        try (Connection conn = ConnectionFactory.createConnection(configuration);
             Table tablee = conn.getTable(tableName);
             RegionLocator regionLocator = conn.getRegionLocator(tableName)) {
            HFileOutputFormat2.configureIncrementalLoad(job, tablee, regionLocator);
        }

        boolean b = job.waitForCompletion(true);
        System.out.println(b);

        if (job.isSuccessful()) {

            //It bulk uploads data into the the table

            try {
                Configuration config = HBaseConfiguration.create();

                BulkLoadHFiles.create(config).bulkLoad(tableName, new Path(hfileOutputPath));

                System.out.println("successful upload to "+tableToInsert+" table");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
