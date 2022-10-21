package Employees.Models;

import Employees.Infrastrucure.EmployeeInfo;

import java.util.List;


public interface Model {
    public List<Employee> load() ;


    public void save(Employee em);
    public void add ();

    public void remove(int id);

    public EmployeeInfo empoyeeInfo();

    public List filterByCab();


    public List filterByDep();
}