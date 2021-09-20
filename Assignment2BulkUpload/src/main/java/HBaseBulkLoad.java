import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.tool.BulkLoadHFiles;

import java.io.IOException;

public class HBaseBulkLoad {

    //This function takes HFile path in Hdfs and bulk uploads data into the the table
    public void doBulkUpload(Path pathToHFile, TableName tableName) {
        try {
            Configuration config = HBaseConfiguration.create();

            BulkLoadHFiles.create(config).bulkLoad(tableName, pathToHFile);

            System.out.println("successful upload");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
