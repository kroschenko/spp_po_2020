package live.ilyusha.spp6.task2_3;

public class Main {

    public static void main(String[] args) {
        // task 2
        Employee ceo = new Employee("Raman Harhun", 5, WorkDepartment.LEAD, WorkField.MANAGEMENT);
        ITCompany company = new ITCompany("Harbros Solutions", ceo);
        Employee manager = new Employee("Tsimafei Harhun", 4, WorkDepartment.LEAD, WorkField.MANAGEMENT);
        ceo.addSubordinate(manager);
        Employee worker = new Employee("Ilya Kulinkovich", 10, WorkDepartment.PROJECTS, WorkField.DEVELOPMENT);
        manager.addSubordinate(worker);
        System.out.println(ceo.getSubordinates().get(0).getSubordinates());
        manager.removeAllSubordinates();
        System.out.println(ceo.getSubordinates());
        System.out.println(ceo);

        // task 3
        manager.addSubordinate(worker);
        ceo.addSubordinate(new Employee("Yana Danilyuk", 8, WorkDepartment.PROJECTS, WorkField.DESIGN));
        company.logSalaries();
    }

}
