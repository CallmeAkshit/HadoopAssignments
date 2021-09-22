import autogeneratedProto.Building;
import autogeneratedProto.BuildingList;
import autogeneratedProto.Employee;
import autogeneratedProto.EmployeeList;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.Arrays;

class EmployeeMapper extends Mapper<NullWritable, BytesWritable, ImmutableBytesWritable, Put> {

    private static final String EMPLOYEE_TABLE_NAME="empl";
    private static final String EMPLOYEE = "employee";
    private static final String EMPLOYEE_DETAIL = "employee_details";

    ImmutableBytesWritable TABLE_NAME_TO_INSERT = new ImmutableBytesWritable(Bytes.toBytes(EMPLOYEE_TABLE_NAME));

    public void map(NullWritable key, BytesWritable value, Context context) {
        try {

            byte b[]=value.getBytes();
            EmployeeList employeeList=EmployeeList.PARSER.parseFrom(Arrays.copyOf(value.getBytes(), value.getLength()));

            for(Employee employee:employeeList.getEmployeesList()){
                int employee_id=employee.getEmployeeId();
                byte byteArray[]=employee.toByteArray();

                Put put = new Put(Bytes.toBytes(employee_id));
                put.addColumn(Bytes.toBytes(EMPLOYEE), Bytes.toBytes(EMPLOYEE_DETAIL), byteArray);
                context.write(TABLE_NAME_TO_INSERT, put);
            }



        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}

class BuildingMapper extends Mapper<NullWritable, BytesWritable, ImmutableBytesWritable, Put> {

    private static final String EMPLOYEE_TABLE_NAME="buildi";
    private static final String BUILDING = "building";
    private static final String BUILDING_DETAILS = "building_details";

    ImmutableBytesWritable TABLE_NAME_TO_INSERT = new ImmutableBytesWritable(Bytes.toBytes(EMPLOYEE_TABLE_NAME));

    public void map(NullWritable key, BytesWritable value, Context context) {
        try {

            byte b[]=value.getBytes();
            BuildingList buildingList=BuildingList.PARSER.parseFrom(Arrays.copyOf(value.getBytes(), value.getLength()));

            for(Building building:buildingList.getBuildingList()){
                int building_code=building.getBuildingCode();
                byte byteArray[]=building.toByteArray();

                Put put = new Put(Bytes.toBytes(building_code));
                put.addColumn(Bytes.toBytes(BUILDING), Bytes.toBytes(BUILDING_DETAILS), byteArray);
                context.write(TABLE_NAME_TO_INSERT, put);
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
