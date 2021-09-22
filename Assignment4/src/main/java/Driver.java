import autogeneratedProto.Building;
import autogeneratedProto.BuildingList;
import autogeneratedProto.EmployeeList;
import com.google.protobuf.InvalidProtocolBufferException;
import org.checkerframework.checker.units.qual.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
    public static final String userDirectory = System.getProperty("user.dir");
    public static final String PATH = userDirectory+"/src/main/resources/";

    public static final String EMPLOYEE_TABLE_NAME="emplo";
    public static final String BUILDING_TABLE_NAME="buildi";

    public static final String EMPLOYEE_HDFS_OUTPUT_PATH ="hdfs://localhost:8020/dataDirectory/employeeSerializeFile";
    public static final String BUILDING_HDFS_OUTPUT_PATH ="hdfs://localhost:8020/dataDirectory/buildingSerializeFile";




    // It Stores employee and building serializedfile to hdfs and creates building and employee table.

    public static void main(String[] args) throws IOException {
        String inputPathToBuildingSerializedFile = PATH + "buildingSerializedFile";
        String inputPathToEmployeeSerializedFile = PATH + "employeeSerializedFile";

        StoreToHdfs storeToHdfs=new StoreToHdfs();
        storeToHdfs.storeSerializedFile(inputPathToEmployeeSerializedFile,EMPLOYEE_HDFS_OUTPUT_PATH);
        storeToHdfs.storeSerializedFile(inputPathToBuildingSerializedFile,BUILDING_HDFS_OUTPUT_PATH);


        HbaseTableCreator hbaseTableCreator=new HbaseTableCreator();
        hbaseTableCreator.createTableBuilding(BUILDING_TABLE_NAME);
        hbaseTableCreator.createTableEmployee(EMPLOYEE_TABLE_NAME);

    }
}
