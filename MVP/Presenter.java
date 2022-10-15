package Employees.MVP;


import Employees.Models.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        List<Employee> em = model.load();
        view.print(em);
        }

    public void add() {
        model.add();
               // new Contact(view.getFirstName(), view.getLastName(), view.getDescription()));
    }
    public void remove() {
        System.out.println("Введите id записи, которую хотите удалить");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int id=0;
        try {
            id = Integer.parseInt(r.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.remove(id);
        }
        public void filterByCab(){
            Scanner sc= new Scanner (System.in);
            int cabNum = Integer.parseInt(sc.nextLine());
            List<Employee> sorted = new ArrayList<>();
            List<Employee> em = model.load();
            for (Employee el:em) {
                if (el.getCabinetNum()==cabNum) sorted.add(el);
            }
            if (!sorted.isEmpty())view.print(sorted);
            else System.out.println("В этом кабинете нет сотрудников");
        }
    public void filterByDep(){
        Employee  temp = new Employee();
        model.emInfo.signDepartment(temp);
        List<Employee> sorted = new ArrayList<>();
        List<Employee> em = model.load();
        for (Employee el:em) {
            if (el.getDepartment().equals(temp.getDepartment())) sorted.add(el);
        }
        if (!sorted.isEmpty())view.print(sorted);
        else System.out.println("В этом отделе нет сотрудников");
    }
    public void sortByDep(){
        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getDepartment().compareTo(e1.getDepartment());
            }
        };
        view.sortPrint(model.load(),comp);

    }
    public void sortByCab(){
        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getCabinetNum() - (e2.getCabinetNum());
            }
        };
        view.sortPrint(model.load(),comp);

    }
    public Model getModel() {
        return model;
    }

}









