package Employees.UI;

import Employees.MVP.View;
import Employees.Models.Employee;

import java.util.*;

public class ConsoleView implements View {
    public void print(Collection<Employee> em) {
        TreeSet<Employee> te = new TreeSet<>(em);
        for (Employee el : te) {
            System.out.println(el);
        }

    }
    public void sortPrint(Collection<Employee> em, Comparator<Employee> comp){
        List<Employee> te = new ArrayList<>(em);
        Collections.sort(te, comp);
        for (Employee el : te) {
            System.out.println(el);
        }
    }
}


