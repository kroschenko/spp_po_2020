package live.ilyusha.spp5.task2;

class Developer extends Worker {

    public Developer(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Developer is developing...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Developer is vacating...");
    }

}
