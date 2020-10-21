package live.ilyusha.spp5.task2;

class Designer extends Worker {

    public Designer(String name, int age, double salary, double moneyAccount) {
        super(name, age, salary, moneyAccount);
    }

    @Override
    public void doWork() {
        System.out.println("Designer is designing...");
    }

    @Override
    public void goOnVacation() {
        System.out.println("Designer is vacating...");
    }

}
