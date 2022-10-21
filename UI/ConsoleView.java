package Employees.UI;

import Employees.MVP.View;
import Employees.Models.Employee;

import java.util.*;

public class ConsoleView implements View {
    Scanner vs = new Scanner(System.in);
    public void print(Collection<Employee> em) {
        if (em.isEmpty() ) System.out.println("В этом кабинете нет сотрудников");
       else {
            TreeSet<Employee> te = new TreeSet<>(em);
            for (Employee el : te) {
                System.out.println(el);
            }
        }

    }
    public void sortPrint(Collection<Employee> em, Comparator<Employee> comp){
        List<Employee> te = new ArrayList<>(em);
        Collections.sort(te, comp);
        for (Employee el : te) {
            System.out.println(el);
        }
    }
    public String getValue (String title){
        System.out.printf("%s - ", title);
       return vs.nextLine();
    }
}


