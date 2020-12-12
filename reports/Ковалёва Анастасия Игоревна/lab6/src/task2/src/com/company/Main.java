package com.company;

interface UniversalCardInterface {
    void functionality();
}

class UniversalCard implements UniversalCardInterface {
    @Override
    public void functionality() {
        System.out.println("Universal card functionality: ");
    }
}

class Decorator implements UniversalCardInterface {
    private UniversalCardInterface card;

    Decorator(UniversalCardInterface card) {
        this.card = card;
    }

    @Override
    public void functionality() {
        card.functionality();
    }
}

class CreditCardDecorator extends Decorator {
    CreditCardDecorator(UniversalCardInterface card) {
        super(card);
    }

   @Override
    public void functionality() {
        super.functionality();
        System.out.println("- credit card actions");
    }
}

class PassportCreditDecorator extends Decorator {
    PassportCreditDecorator(UniversalCardInterface card) {
        super(card);
    }

    @Override
    public void functionality() {
        super.functionality();
        passportAction();
    }

    void passportAction() {
        System.out.println("- passport");
    }
}

class InsurancePolicyDecorator extends Decorator {
    InsurancePolicyDecorator(UniversalCardInterface card) {
        super(card);
    }
    private boolean hasPolicy = false;

    @Override
    public void functionality() {
        super.functionality();
        getInsurancePolicyAction();
    }

    void getInsurancePolicyAction() {
        System.out.println("- insurance policy");
    }
}

public class Main {
    public static void main(String[] args) {
        UniversalCardInterface card = new InsurancePolicyDecorator(new PassportCreditDecorator(new CreditCardDecorator(new UniversalCard())));
        card.functionality();

    }
}