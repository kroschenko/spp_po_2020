using System;
using System.Collections.Generic;
using System.Linq;

namespace task2
{
    class Program
    {
        static void Main(string[] args)
        {
            
        }
    }

    class Car
    {
        public int Id { get; set; }
        public string Brand { get; set; }
        public string Model { get; set; }
        public int Year { get; set; }
        public string Color { get; set; }
        public int Price { get; set; }
        public int CarNum { get; set; }
        public int RegNum { get; set; }
        public string FIO_p { get; set; }
        public int PassNum_p { get; set; }

        public void Show()
        {
            Console.WriteLine("_____________________");
            Console.WriteLine("ID: " + Id);
            Console.WriteLine("_____________________");
            Console.WriteLine("Brand: " + Brand);
            Console.WriteLine("Model: " + Model);
            Console.WriteLine("Year: " + Year);
            Console.WriteLine("Color: " + Color);
            Console.WriteLine("Price: " + Price);
            Console.WriteLine("Car number: " + CarNum);
            Console.WriteLine("Registration number: " + RegNum);
            Console.WriteLine("FIO: " + FIO_p);
            Console.WriteLine("Password number: " + PassNum_p);
            Console.WriteLine("_____________________");
        }
    }

    class CarDB
    {
        private List<Car> cars;

        public CarDB()
        {
            // reading from file
        }
        
        public List<Car> GetBrand(string _Brand)
        {
            return cars.Where(i => i.Brand == _Brand).ToList();
        }

        public List<Car> GetModelWithOld(string _Model, int n)
        {
            int CurrentYear = 2020;
            return cars.Where(i => i.Model == _Model && (CurrentYear - i.Year) > n).ToList();
        }

        public List<Car> GetYearWithPrice(int _Year, int _Price)
        { 
            return cars.Where(i => i.Year == _Year && i.Price > _Price).ToList();
        }

        public List<Car> GetCarsHire()
        {
            return cars.Where(i => i.FIO_p != null).ToList();
        }

        public List<Car> GetCarsHireWithInfo()
        {
            var info = cars.Where(i => i.FIO_p != null).ToList();
            foreach (var item in info)
            {
                Console.WriteLine("ID: "+item.Id);
                Console.WriteLine("FIO: " + item.FIO_p);
                Console.WriteLine("Password number: " + item.PassNum_p);
            }
            return info;
        }
    }
}
