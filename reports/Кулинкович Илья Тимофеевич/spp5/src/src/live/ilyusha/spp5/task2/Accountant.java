package live.ilyusha.spp5.task2;

class Accountant extends Worker {

    public Accountant(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Accountant is accounting...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Accountant is vacating...");
    }

}
