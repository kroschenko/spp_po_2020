using System;
using System.Dynamic;

namespace task1
{
    class Program
    {
        static void Main(string[] args)
        {
            Client pclient = new Client(new PetroleFactory());
            pclient.TestingRun();
            Client dclient = new Client(new DieselFactory());
            dclient.TestingRun();
        }
    }

    abstract class AbstractFactory
    {
        public abstract PassengerCar CreatePassengerCar();
        public abstract TruckCar CreateTruckCar();
    }

    class DieselFactory : AbstractFactory
    {
        public override PassengerCar CreatePassengerCar()
        {
            return new DieselPassengerCar();
        }

        public override TruckCar CreateTruckCar()
        {
            return new DieselTruckCar();
        }
    }

    class PetroleFactory : AbstractFactory
    {
        public override PassengerCar CreatePassengerCar()
        {
            return new PetrolePassengerCar();
        }

        public override TruckCar CreateTruckCar()
        {
            return new PetroleTruckCar();
        }
    }

    abstract class PassengerCar 
    {
        public abstract void GetInfo();
    }

    abstract class TruckCar 
    {
        public abstract void GetInfo();
    }

    class DieselPassengerCar : PassengerCar 
    {
        public override void GetInfo()
        {
            Console.WriteLine("Diesel passenger car is working");
        }
    }

    class PetrolePassengerCar : PassengerCar 
    {
        public override void GetInfo()
        {
            Console.WriteLine("Petrole passenger car is working");
        }
    }

    class DieselTruckCar : TruckCar 
    {
        public override void GetInfo()
        {
            Console.WriteLine("Diesel truck car is working");
        }
    }

    class PetroleTruckCar : TruckCar 
    {
        public override void GetInfo()
        {
            Console.WriteLine("Petrole truck car is working");
        }
    }

    class Client
    {
        private AbstractFactory _factory;

        public Client(AbstractFactory factory)
        {
            _factory = factory;
        }

        public PassengerCar GetPassengerCar()
        {
            return _factory.CreatePassengerCar();
        }

        public TruckCar GetTruckCar()
        {
            return _factory.CreateTruckCar();
        }

        public void TestingRun() {
            GetPassengerCar().GetInfo();
            GetTruckCar().GetInfo();
        }
    }
}
