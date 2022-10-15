package Employees.Infrastrucure;

import Employees.Models.Department;
import Employees.Models.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Employees.UI.Config.pathDb;

public class Load {
    public static List<Employee> read()  {
        List <Employee> em = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathDb));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i =0; i<records.size(); i++){
            String s = records.get(i).toString();
            String emField [] = s.split(", ");
            Employee e = new Employee();
            e.setId(Integer.parseInt(emField[0].replace("[","")));
            e.setName(emField[1]);
            e.setSurname(emField[2]);

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                e.setDateOfBirth(f.parse(emField[3]));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
          //  e.setDepartment(emField[4]);
            switch (emField[4]){

                case "MANAGERIAL)":
                    e.setDepartment(Department.MANAGERIAL);
                    break;
                case "ACCOUNT":
                    e.setDepartment(Department.ACCOUNT);
                    break;
                case "SALES":
                    e.setDepartment(Department.SALES);
                    break;
                case "LOGISTIC":
                    e.setDepartment(Department.LOGISTIC);
                    break;
                case "STOCK":
                    e.setDepartment(Department.STOCK);
                    break;
            }
            e.setPosition(emField[5]);

            e.setCabinetNum(Integer.parseInt(emField[6]));
            e.setSalary(Integer.parseInt(emField[7].replace("]","")));

            em.add(e);
        }
        return em;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}

