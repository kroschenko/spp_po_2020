package live.ilyusha.spp5.task2;

class Manager extends Worker {

    public Manager(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Manager is managing...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Manager is vacating...");
    }

}
