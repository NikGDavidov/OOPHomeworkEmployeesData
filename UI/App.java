package Employees.UI;


import Employees.MVP.Presenter;
import Employees.MVP.View;

import java.util.Scanner;

import static Employees.UI.Config.pathDb;
public class App {

    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, pathDb);
        start(presenter);
    }

    public static void start(Presenter presenter) {
        System.out.println();
        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                try (Scanner scanner = new Scanner(System.in)) {
                    while (true) {
                        System.out.println("Введите опцию - 1 - добавить запись; 2- вывести записи на экран; 3 - удалить запись; " +
                                "4 - выборка и сортировка сотрудников");
                        String key = scanner.next();
                        System.out.print("\033[H\033[J");
                        switch (key) {
                            case "1":
                                presenter.add();

                                break;
                            case "2":
                                presenter.LoadFromFile();
                                break;
                            case "3":
                                presenter.remove();
                                break;
                            case "4":
                                sort (presenter);
                            default:
                                System.out.println("Такой команды нет");
                                break;
                        }
                    }
                }
            }


        }
    }


    public static void sort(Presenter presenter){

        System.out.println("Для вывода сотрудников по департаменту введите 1; для вывода сотрудников по номеру кабинета введите 2;");
        System.out.println("для сортировки по департаментам введите 3; для сортировки по кабинетам введите 4.");
        Scanner scn= new Scanner(System.in);


        String key = scn.nextLine();
        System.out.print("\033[H\033[J");
        switch (key) {
            case "1":
                presenter.filterByDep();
                start(presenter);
                break;
            case "2":
                System.out.println("Введите номер кабинета");
                presenter.filterByCab();
                start(presenter);
                break;
            case "3":
                presenter.sortByDep();
                start(presenter);
                break;
            case "4":
                presenter.sortByCab();
                start(presenter);
                break;
            default:
                System.out.println("Такой команды нет");
                sort(presenter);
                break;
        }

    }
}