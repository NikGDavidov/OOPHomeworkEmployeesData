package Employees.MVP;

import Employees.Models.Employee;

import java.util.Collection;
import java.util.Comparator;

public interface View {
    public void print(Collection<Employee> employees);
    public void sortPrint(Collection<Employee> employees, Comparator<Employee> comparator);
}
