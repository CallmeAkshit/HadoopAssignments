import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellScanner;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class HdfsReducer extends Reducer<ImmutableBytesWritable, Result, Text,NullWritable> {
    @Override
    protected void reduce(ImmutableBytesWritable key, Iterable<Result> values, Context context) throws IOException, InterruptedException {

        for (Result result : values) {
            CellScanner scanner = result.cellScanner();

            while (scanner.advance()) {

                Cell cell = scanner.current();
                Text text = new Text();
                String row = Bytes.toString(CellUtil.cloneRow(cell)) + ",";
                String columnFamily = Bytes.toString(CellUtil.cloneFamily(cell)) + ",";
                String columnName = Bytes.toString(CellUtil.cloneQualifier(cell)) + ",";
                String value = Bytes.toString(CellUtil.cloneValue(cell)) + ",";

                StringBuffer buffer = new StringBuffer();
                buffer.append(row).append(columnFamily).append(columnName).append(value);
                text.set(buffer.toString());

                context.write(text, NullWritable.get());
            }
        }





    }
}

