package Employees.Infrastrucure;

import Employees.Models.Employee;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static List filterByCab(List <Employee> em, int cabNum){

        List<Employee> filtered = new ArrayList<>();

        for (Employee el:em) {
            if (el.getCabinetNum()==cabNum) filtered.add(el);
        }
      return filtered;
    }
    public static List filterByDep(List <Employee> em, Employee temp){
        List<Employee> filtered = new ArrayList<>();

        for (Employee el:em) {
            if (el.getDepartment().equals(temp.getDepartment())) filtered.add(el);
        }
        return filtered;
    }
}
