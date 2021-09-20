import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HbaseMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put> {

    ImmutableBytesWritable TABLE_NAME_TO_INSERT = new ImmutableBytesWritable(Bytes.toBytes("peopleBulkUpload"));

    public void map(LongWritable key, Text value, Context context) {
        try {

            String[] values = value.toString().split(",");
            String rowKey = values[0];
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(values[1]), Bytes.toBytes(values[2]), Bytes.toBytes(values[3]));
            context.write(TABLE_NAME_TO_INSERT, put);

        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}