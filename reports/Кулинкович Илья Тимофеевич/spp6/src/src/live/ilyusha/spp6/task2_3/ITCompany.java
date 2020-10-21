package live.ilyusha.spp6.task2_3;

import java.util.Iterator;

class ITCompany {

    private String name;
    private Employee ceo;

    public ITCompany(String name, Employee ceo) {
        this.name = name;
        this.ceo = ceo;
    }

    /* helper methods */

    private void logSalaries(int padding, Employee employee) {
        Iterator<Employee> iterator = employee.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            next.logSalary(padding + 1);
            logSalaries(padding + 1, next);
        }
    }

    public void logSalaries() {
        System.out.println("====== SALARY LOG BEGIN ======================== ");
        ceo.logSalary(1);
        logSalaries(1, ceo);
        System.out.println("====== SALARY LOG END ========================== ");
    }

    /* codegen */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

}
