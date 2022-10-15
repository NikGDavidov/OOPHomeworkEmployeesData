package Employees.MVP;
//import TaskScheduler.Core.Infrastructure.Load;
//import TaskScheduler.Core.Infrastructure.Save;
//import TaskScheduler.Core.Infrastructure.TaskPlanner;
//import TaskScheduler.Core.Models.Task;

import Employees.Infrastrucure.EmployeeInfo;
import Employees.Infrastrucure.Load;
import Employees.Infrastrucure.Save;
import Employees.Models.Employee;

import java.util.List;


public class Model {

    EmployeeInfo emInfo;
    private String path;

    public Model(String path) {
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

}
