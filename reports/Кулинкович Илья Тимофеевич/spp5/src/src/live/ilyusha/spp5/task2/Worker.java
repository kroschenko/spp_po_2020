package live.ilyusha.spp5.task2;

abstract class Worker {

    private String name;
    private int age;
    private double salary;
    private double moneyAccount;

    public Worker(String name, int age, double salary, double moneyAccount) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.moneyAccount = moneyAccount;
    }

    /* helper methods */

    public void receiveSalary() {
        moneyAccount += salary;
    }

    public void buyProduct(String product, double price) {
        if (moneyAccount < price) {
            throw new IllegalStateException("Not enough money");
        }
        moneyAccount -= price;
        System.out.printf("%s bought %s for %d\n", name, product, price);
    }

    /* abstract methods */

    public abstract void doWork();
    public abstract void goOnVacation();

    /* codegen */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

}
