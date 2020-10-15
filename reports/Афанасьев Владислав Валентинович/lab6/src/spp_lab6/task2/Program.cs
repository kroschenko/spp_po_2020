using System;

namespace task2
{
    class Program
    {
        static void Main(string[] args)
        {
            ElectronicCard myCard = new ElectronicCard(new Passport(), new InsurancePolicy(), new BankCard());
            myCard.ShowInfo();
            myCard.ShowInsurance();
            myCard.PayFor();
        }
    }

    class Passport
    {
        public void ShowInfo()
        {
            Console.WriteLine("You show the information");
        }
    }

    class InsurancePolicy
    {
        public void ShowInsurance()
        {
            Console.WriteLine("You show the insurance");
        }
    }

    class BankCard
    {
        public void PayFor()
        {
            Console.WriteLine("You have paid for");
        }
    }

    class ElectronicCard
    {
        Passport passport;
        InsurancePolicy insurancePolic;
        BankCard bankCard;

        public ElectronicCard(Passport pass, InsurancePolicy insur, BankCard bank)
        {
            passport = pass;
            insurancePolic = insur;
            bankCard = bank;
        }

        public void ShowInfo()
        {
            passport.ShowInfo();
        }

        public void ShowInsurance()
        {
            insurancePolic.ShowInsurance();
        }

        public void PayFor()
        {
            bankCard.PayFor();
        }
    }
}
