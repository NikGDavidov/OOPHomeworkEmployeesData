package Employees.MVP;
//import TaskScheduler.Core.Infrastructure.Load;
//import TaskScheduler.Core.Infrastructure.Save;
//import TaskScheduler.Core.Infrastructure.TaskPlanner;
//import TaskScheduler.Core.Models.Task;

import Employees.Infrastrucure.EmployeeInfo;
import Employees.Infrastrucure.Filter;
import Employees.Infrastrucure.Load;
import Employees.Infrastrucure.Save;
import Employees.Models.Employee;
import Employees.Models.Model;
import Employees.Models.MyCompanyEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyCompanyModel implements Model {

    EmployeeInfo emInfo;
    private String path;

    public MyCompanyModel(String path) {
        emInfo = new EmployeeInfo();
        this.path = path;
    }



    public List<Employee> load() {
          return  Load.read();
    }


    public void save(Employee em) {
                Save.write(em);
            }

    public void add (){
        emInfo.add();

    }
    public void remove(int id){
        emInfo.remove(id);
    }

    public EmployeeInfo empoyeeInfo() {
        return this.emInfo;
    }

    public List filterByCab(){
        Scanner sc= new Scanner (System.in);
        int cabNum = Integer.parseInt(sc.nextLine());
        List<Employee> em = this.load();
        return Filter.filterByCab(em,cabNum);

    }
    public List filterByDep(){
        Employee temp = new MyCompanyEmployee();
        this.emInfo.signDepartment(temp);
        List<Employee> sorted = new ArrayList<>();
        List<Employee> em = this.load();
        return Filter.filterByDep(em,temp);
          }
}
