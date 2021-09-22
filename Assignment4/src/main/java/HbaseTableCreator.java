import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseTableCreator {


    public static final String COLUMN_FAMILY_EMPLOYEE = "employee";
    public static final String COLUMN_FAMILY_BUILDING = "building";


    public void createTableBuilding(String tableNameToCreate) throws IOException {

        Configuration config = HBaseConfiguration.create();


        Connection connection = ConnectionFactory.createConnection(config);
        Admin hAdmin = connection.getAdmin();
        if (hAdmin.tableExists(TableName.valueOf(tableNameToCreate))) {
            System.out.println("Table already exists");
            return;
        }
        TableName tname = TableName.valueOf(tableNameToCreate);
        TableDescriptorBuilder tableDescBuilder = TableDescriptorBuilder.newBuilder(tname);

        ColumnFamilyDescriptorBuilder columnDescBuilderBuilding = ColumnFamilyDescriptorBuilder
                .newBuilder(Bytes.toBytes(COLUMN_FAMILY_BUILDING));
        tableDescBuilder.setColumnFamily(columnDescBuilderBuilding.build());

        tableDescBuilder.build();

        hAdmin.createTable(tableDescBuilder.build());
        System.out.println(tableNameToCreate + " table created");
    }

    public void createTableEmployee(String tableNameToCreate) throws IOException {

        Configuration config = HBaseConfiguration.create();


        Connection connection = ConnectionFactory.createConnection(config);
        Admin hAdmin = connection.getAdmin();
        if (hAdmin.tableExists(TableName.valueOf(tableNameToCreate))) {
            System.out.println("Table already exists");
            return;
        }

        TableName tname = TableName.valueOf(tableNameToCreate);
        TableDescriptorBuilder tableDescBuilder = TableDescriptorBuilder.newBuilder(tname);

        ColumnFamilyDescriptorBuilder columnDescBuilderEmployee = ColumnFamilyDescriptorBuilder
                .newBuilder(Bytes.toBytes(COLUMN_FAMILY_EMPLOYEE));
        tableDescBuilder.setColumnFamily(columnDescBuilderEmployee.build());
        tableDescBuilder.build();

        hAdmin.createTable(tableDescBuilder.build());
        System.out.println(tableNameToCreate + " table created");
    }
}
