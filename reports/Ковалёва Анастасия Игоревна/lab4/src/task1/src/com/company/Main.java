package com.company;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setId("12345");
        Account.info info = account.new info(100, 50, 400);
        info.show();
    }
}

class Account {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    class info {
        int takes;
        int payments;
        int income;

        info(int takes, int payments, int income) {
            this.takes = takes;
            this.payments = payments;
            this.income = income;
        }

        public void setTakes(int takes) {
            this.takes = takes;
        }

        public void setPayments(int payments) {
            this.payments = payments;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public void show() {
            System.out.println("id: " + id);
            System.out.println("Withdrawal: " + takes);
            System.out.println("Payments: " + payments);
            System.out.println("Income: " + income);
        }
    }
}
