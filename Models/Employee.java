package Employees.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Employee> {


    private int id;
    private String Name;
    private String Surname;
    private Date dateOfBirth;
    private int salary;
    private Department department;
    private String position;
    int cabinetNum;


    public Employee() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public int getCabinetNum() {
        return cabinetNum;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }



    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCabinetNum(int cabinetNum) {
        this.cabinetNum = cabinetNum;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "id " + id +
                ", " + Name + " " +
                 Surname + " " +
                ", Дата рождения " + new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth) +
                ", Зарплата " + salary + " руб."+
                ", Отдел " + department + " " +
                ", Кабинет №" + cabinetNum;
    }
        @Override
        public int compareTo(Employee o) {
            int result =o.getSalary()-( this.getSalary());
            if (result == 0)
                result = this.getSurname().compareTo(o.getSurname());

            return result;
        }


    }


