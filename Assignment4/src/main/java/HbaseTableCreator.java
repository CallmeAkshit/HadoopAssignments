import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseTableCreator {


    private static final String COLUMN_FAMILY_EMPLOYEE = "employee";
    private static final String COLUMN_FAMILY_BUILDING = "building";
    private static final String TABLE_ALREADY_EXISTS = "Table already exists";
    private static final String TABLE_CREATED =  " table created";


    public void createTableBuilding(String tableNameToCreate) throws IOException {

        Configuration config = HBaseConfiguration.create();


        Connection connection = ConnectionFactory.createConnection(config);
        Admin hAdmin = connection.getAdmin();
        if (hAdmin.tableExists(TableName.valueOf(tableNameToCreate))) {
            System.out.println(TABLE_ALREADY_EXISTS);
            return;
        }
        TableName tname = TableName.valueOf(tableNameToCreate);
        TableDescriptorBuilder tableDescBuilder = TableDescriptorBuilder.newBuilder(tname);

        ColumnFamilyDescriptorBuilder columnDescBuilderBuilding = ColumnFamilyDescriptorBuilder
                .newBuilder(Bytes.toBytes(COLUMN_FAMILY_BUILDING));
        tableDescBuilder.setColumnFamily(columnDescBuilderBuilding.build());

        tableDescBuilder.build();

        hAdmin.createTable(tableDescBuilder.build());
        System.out.println(tableNameToCreate + TABLE_CREATED);
    }

    public void createTableEmployee(String tableNameToCreate) throws IOException {

        Configuration config = HBaseConfiguration.create();


        Connection connection = ConnectionFactory.createConnection(config);
        Admin hAdmin = connection.getAdmin();
        if (hAdmin.tableExists(TableName.valueOf(tableNameToCreate))) {
            System.out.println(TABLE_ALREADY_EXISTS);
            return;
        }

        TableName tname = TableName.valueOf(tableNameToCreate);
        TableDescriptorBuilder tableDescBuilder = TableDescriptorBuilder.newBuilder(tname);

        ColumnFamilyDescriptorBuilder columnDescBuilderEmployee = ColumnFamilyDescriptorBuilder
                .newBuilder(Bytes.toBytes(COLUMN_FAMILY_EMPLOYEE));
        tableDescBuilder.setColumnFamily(columnDescBuilderEmployee.build());
        tableDescBuilder.build();

        hAdmin.createTable(tableDescBuilder.build());
        System.out.println(tableNameToCreate + TABLE_CREATED);
    }
}
