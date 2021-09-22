import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

public class StoreToHdfs {

    // stores serialized file to hdfs
    public void storeSerializedFile(String local_path,String hdfs_output_path) throws IOException {


        InputStream in = new BufferedInputStream(new FileInputStream(local_path));


        Configuration conf = new Configuration();
        Path output = new Path(hdfs_output_path);
        FileSystem fs = FileSystem.get(URI.create(hdfs_output_path),conf);

        if (fs.exists(output)) {                                      // delete existing directory
            fs.delete(output, true);
        }
        System.out.println("Connecting to -- "+conf.get("fs.defaultFS"));

        OutputStream out = fs.create(new Path(hdfs_output_path));

        IOUtils.copyBytes(in, out, 4096, true);

        System.out.println(" copied to HDFS");
    }

}
