import autogeneratedProto.Building;
import autogeneratedProto.Employee;
import autogeneratedProto.EmployeeList;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JoinReducer extends TableReducer<IntWritable, Result, ImmutableBytesWritable> {

    @Override
    public void reduce(IntWritable key, Iterable<Result> values, Context context) throws IOException, InterruptedException {

        int cafe_value = 0;


        EmployeeList employeeList = EmployeeList.getDefaultInstance();
        List<Employee> list = new ArrayList<>();


        for (Result result : values) {

            if (result.containsColumn(Bytes.toBytes("employee"), Bytes.toBytes("employee_details"))) {

                Employee employee = Employee.parseFrom(result.value());
                list.add(employee);
            }
            if (result.containsColumn(Bytes.toBytes("building"), Bytes.toBytes("building_details"))) {

                Building building = Building.parseFrom(result.value());
                int cafeteria_code = building.getCafeteriaCode();
                int building_id = building.getBuildingCode();
                cafe_value = cafeteria_code;
                //System.out.println("bui_id= "+building_id+"building cafe= "+cafeteria_code);
            }

        }

        for (Employee employee : list) {
            Put put = enrichCafeteriaCode(employee, cafe_value);
            int employee_id = employee.getEmployeeId();
            context.write(new ImmutableBytesWritable(Bytes.toBytes(employee_id)), put);

        }

    }


    public Put enrichCafeteriaCode(Employee employee, int cafe_value) {

        employee = employee.toBuilder().setCafeteriaCode(cafe_value).build();

        String name = employee.getName();
        int employee_id = employee.getEmployeeId();
        int building_code = employee.getBuildingCode();
        float salary = employee.getSalary();
        String department = employee.getDepartment();
        int floor = employee.getFloorNumber().getNumber();
        int cafeteria_code = employee.getCafeteriaCode();

        //System.out.println("emp_id= "+employee_id+" caf="+cafeteria_code);
        Put put = new Put(Bytes.toBytes(employee_id));
        put.addColumn(Bytes.toBytes("name"), Bytes.toBytes("name"), Bytes.toBytes(name));
        put.addColumn(Bytes.toBytes("building_code"), Bytes.toBytes("building_code"), Bytes.toBytes(building_code + ""));
        put.addColumn(Bytes.toBytes("employee_id"), Bytes.toBytes("employee_id"), Bytes.toBytes(employee_id + ""));
        put.addColumn(Bytes.toBytes("salary"), Bytes.toBytes("salary"), Bytes.toBytes(salary + ""));
        put.addColumn(Bytes.toBytes("department"), Bytes.toBytes("department"), Bytes.toBytes(department + ""));
        put.addColumn(Bytes.toBytes("floor_number"), Bytes.toBytes("floor"), Bytes.toBytes(floor + ""));
        put.addColumn(Bytes.toBytes("cafeteria_code"), Bytes.toBytes("cafeteria_code"), Bytes.toBytes(cafeteria_code + ""));

        return put;

    }
}
