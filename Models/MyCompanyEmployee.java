package Employees.Models;

import java.text.SimpleDateFormat;

public class MyCompanyEmployee extends CompanyEmployee implements Comparable<Employee> {

    public MyCompanyEmployee() { super();}

    @Override
    public String toString() {
        return "id " + getId() +
                ", " + getName() + " " +
                 getSurname() + " " +
                ", Дата рождения " + new SimpleDateFormat("yyyy-MM-dd").format(getDateOfBirth()) +
                ", Зарплата " + getSalary() + " руб."+
                ", Отдел " + getDepartment() + " " +
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


