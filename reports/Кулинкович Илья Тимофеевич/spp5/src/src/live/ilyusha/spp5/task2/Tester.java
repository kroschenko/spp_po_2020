package live.ilyusha.spp5.task2;

class Tester extends Worker {

    public Tester(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Tester is testing...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Tester is vacating...");
    }

}
