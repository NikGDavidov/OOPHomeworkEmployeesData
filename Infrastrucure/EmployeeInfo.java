package Employees.Infrastrucure;


import Employees.Models.Department;
import Employees.Models.Employee;
import Employees.Models.MyCompanyEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Employees.UI.Config.pathDb;

public class EmployeeInfo {
    private List<Employee> employees;

    public EmployeeInfo() {
        employees = new ArrayList<Employee>();
    }

    public void add() {
        Scanner sc1 = new Scanner(System.in);
        Employee employee = new MyCompanyEmployee();
        System.out.println("Введите имя сотрудника");
        employee.setName(sc1.nextLine());
        System.out.println("Введите фамилию сотрудника");
        employee.setSurname(sc1.nextLine());
        System.out.println("Введите дату его рождения в формате dd/MM/yyyy");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String temp = sc1.nextLine();
        try {
            employee.setDateOfBirth(simpleDateFormat.parse(temp));
        } catch (ParseException e) {
            System.out.println("ошибка ввода даты");
            add();
        }
        signDepartment(employee);
//        System.out.println("Выберите наименование отдела: введите 1 для MANAGERIAL, 2 - ACCOUNTS, 3 - SALES, 4 - LOGISTICS, 5 - STOCK");
//        String key = sc1.nextLine();
//        switch (key) {
//            case "1":
//                employee.setDepartment(Department.MANAGERIAL);
//                break;
//            case "2":
//                employee.setDepartment(Department.ACCOUNT);
//                break;
//            case "3":
//                employee.setDepartment(Department.SALES);
//                break;
//            case "4":
//                employee.setDepartment(Department.LOGISTIC);
//                break;
//            case "5":
//                employee.setDepartment(Department.STOCK);
//                break;
//            default:
//                System.out.println("Такого департамента нет");
//                add();
//                break;
//        }

        System.out.println("Наименование доолжности");
        employee.setPosition(sc1.nextLine());
        System.out.println("Введите номер кабинета");
        employee.setCabinetNum(Integer.parseInt(sc1.nextLine()));
        System.out.println("Назначте  зарплату");
        employee.setSalary(Integer.parseInt(sc1.nextLine()));

        employee.setId(new Date().hashCode() % 1000 * (-1));

        Save.write(employee);

    }

    public void remove(int id) {
        ArrayList<Employee> em = (ArrayList) Load.read();
        for (int i = 0; i < em.size(); i++) {
            if (em.get(i).getId() == id)
            {em.remove(i);
                System.out.println("Запись удалена");
            }
        }
        File file = new File(pathDb);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        for (int i = 0; i < em.size(); i++) {
            Save.write(em.get(i));
        }
    }

    public void signDepartment(Employee employee) {
       Scanner sc2 = new Scanner(System.in);

        System.out.println("Выберите наименование отдела: введите 1 для MANAGERIAL, 2 - ACCOUNTS, 3 - SALES, 4 - LOGISTICS, 5 - STOCK");
        String key = sc2.nextLine();
        switch (key) {
            case "1":
                employee.setDepartment(Department.MANAGERIAL);
                break;
            case "2":
                employee.setDepartment(Department.ACCOUNT);
                break;
            case "3":
                employee.setDepartment(Department.SALES);
                break;
            case "4":
                employee.setDepartment(Department.LOGISTIC);
                break;
            case "5":
                employee.setDepartment(Department.STOCK);
                break;
            default:
                System.out.println("Такого департамента нет");
                add();
                break;
        }
    }
}

