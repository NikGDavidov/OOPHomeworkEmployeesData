package Employees.Models;

import java.util.Date;

public interface Employee extends Comparable <Employee>{

   int getId() ;

    String getName() ;
   String getSurname();
   Date getDateOfBirth();

   int getSalary() ;

   Department getDepartment();

     int getCabinetNum();

   String getPosition();
    void setId(int id) ;


   void setName(String name);
   void setSurname(String surname) ;



    void setSalary(int salary);


    void setDepartment(Department department);


    void setCabinetNum(int cabinetNum) ;


   void setDateOfBirth(Date dateOfBirth);
   void setPosition(String position) ;
   int compareTo(Employee o);
}
