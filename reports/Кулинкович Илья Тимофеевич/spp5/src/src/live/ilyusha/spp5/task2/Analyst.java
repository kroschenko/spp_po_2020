package live.ilyusha.spp5.task2;

class Analyst extends Worker {

    public Analyst(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Analyst is analyzing...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Analyst is vacating...");
    }

}
