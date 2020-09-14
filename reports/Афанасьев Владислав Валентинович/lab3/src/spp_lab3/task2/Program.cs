using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Xml;
using System.Xml.Serialization;

namespace task2
{
    class Program
    {
        static void Main(string[] args)
        {
            CarDB db = new CarDB();

            // writing for testing

            //Car obj1 = new Car()
            //{
            //    Id = 1,
            //    Brand = "Lada",
            //    Model = "154",
            //    Year = 1980,
            //    Color = "green",
            //    Price = 300,
            //    CarNum = 6544,
            //    RegNum = 45475
            //};
            //db.Add(obj1);

            //Car obj2 = new Car()
            //{
            //    Id = 2,
            //    Brand = "Mercedes",
            //    Model = "154",
            //    Year = 1995,
            //    Color = "gray",
            //    Price = 2500,
            //    CarNum = 6344,
            //    RegNum = 454375
            //};
            //db.Add(obj2);

            //Car obj3 = new Car()
            //{
            //    Id = 3,
            //    Brand = "Renault",
            //    Model = "567",
            //    Year = 2005,
            //    Color = "green",
            //    Price = 5500,
            //    CarNum = 6544,
            //    RegNum = 45475
            //};
            //db.Add(obj3);

            //Car obj4 = new Car()
            //{
            //    Id = 4,
            //    Brand = "Lada5",
            //    Model = "154",
            //    Year = 1985,
            //    Color = "blue",
            //    Price = 350,
            //    CarNum = 6544,
            //    RegNum = 45475,
            //    FIO_p = "Astapov Peter",
            //    PassNum_p = 865849
            //};
            //db.Add(obj4);

            //db.Writer();

            Console.WriteLine("\nModel with old");
            foreach (var item in db.GetModelWithOld("154", 5))
            {   
                item.Show();
            }

            Console.WriteLine("\nYear with price");
            foreach (var item in db.GetYearWithPrice(1985, 300))
            {   
                item.Show();
            }

            Console.WriteLine("\nHire with info");
            foreach (var item in db.GetCarsHireWithInfo())
            {     
                item.Show();
            }
        }
    }

    [Serializable]
    public class Car
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
        private List<Car> cars = new List<Car>();

        public void Add(Car _car)
        {
            cars.Add(_car);
        }

        public CarDB()
        {
            if(File.Exists("cars.xml"))
            {
                Reader();
            }
        }

        public void Reader()
        {
            XmlSerializer formatter = new XmlSerializer(typeof(Car[]));
            using (FileStream fs = new FileStream("cars.xml", FileMode.OpenOrCreate))
            {
                Car[] newcars = (Car[])formatter.Deserialize(fs);

                cars = newcars.ToList();
            }
        }

        public void Writer()
        {
            XmlSerializer formatter = new XmlSerializer(typeof(Car[]));
            using (FileStream fs = new FileStream("cars.xml", FileMode.OpenOrCreate))
            {
                formatter.Serialize(fs, cars.ToArray());
            }
        }

        public List<Car> GetCars()
        {
            return cars;
        }

        public List<Car> GetBrand(string _Brand)
        {
            return cars.Where(i => i.Brand == _Brand).ToList();
        }

        public List<Car> GetModelWithOld(string _Model, int n)
        {
            int CurrentYear = 2020;
            return cars.Where(i => (i.Model == _Model) && ((CurrentYear - i.Year) > n)).ToList();
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
