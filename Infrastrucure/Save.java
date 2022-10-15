package Employees.Infrastrucure;


import Employees.Models.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Employees.UI.Config.pathDb;

public class Save {
    public static void write(Employee em) {


    String fileName = pathDb;

    StringBuilder sb = new StringBuilder();
    sb.append(em.getId());
    sb.append(',');
    sb.append(em.getName());
    sb.append(',');
    sb.append(em.getSurname());
    sb.append(',');

    Date dt = em.getDateOfBirth();
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    sb.append(f.format(dt));
    sb.append(',');

    sb.append(em.getDepartment());
    sb.append(',');
    sb.append(em.getPosition());
        sb.append(',');
    sb.append(em.getCabinetNum());
        sb.append(',');
    sb.append(em.getSalary());
    sb.append('\n');

    try( FileWriter fw = new FileWriter(fileName, true)){

        fw.write(sb.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
