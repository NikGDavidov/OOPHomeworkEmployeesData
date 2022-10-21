package Employees.MVP;


import Employees.Models.Model;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new MyCompanyModel(pathDb);
    }

    public void LoadFromFile() {
        view.print( model.load());
        }

    public void add() {
        model.add();

    }
    public void remove() {
        int id=0;
        try {
            id = Integer.parseInt(view.getValue("Введите id записи, которую хотите удалить"));
        } catch (Exception e){
            remove();
        }
        model.remove(id);
        }
        public void filterByCab(){
            view.print (model.filterByCab());

        }
    public void filterByDep(){
        view.print(model.filterByDep());

    }
    public void sortByDep(){

        view.sortPrint(model.load(),(e1,e2)->(e2.getDepartment().compareTo(e1.getDepartment())));

    }
    public void sortByCab(){

        view.sortPrint(model.load(),(e1,e2)->(e1.getCabinetNum()-e2.getCabinetNum()));

    }
    public Model getModel() {
        return model;
    }

}









