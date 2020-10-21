using System;
namespace lab6_1
{  
    class Program
    {
        static void Main(string[] args)
        {
            Services services = Services.CreateBuilder().Travel("New-York", 1000).Accomodation("hotel", 100).
                Nutrition("all included", 345).MusiemsVisiting("all", 203);
            Console.WriteLine(services.SumCost());
        }

        public class Services
        {
            public Service Travel { get; set; }
            public Service Accomodation { get; set; }
            public Service Nutrition { get; set; }
            public Service MusiemsVisiting { get; set; }
            public Service ExhibitionsVisiting { get; set; }
            public Service ExcursionsVisiting { get; set; }

            public int SumCost()
            {
                int result = 0;
                result += Travel?.Cost ?? 0;
                result += Accomodation?.Cost ?? 0;
                result += Nutrition?.Cost ?? 0;
                result += MusiemsVisiting?.Cost ?? 0;
                result += ExhibitionsVisiting?.Cost ?? 0;
                result += ExcursionsVisiting?.Cost ?? 0;
                return result;
            }

            public static ServiceBuilder CreateBuilder()
            {
                return new ServiceBuilder();
            }
        }

        public class Service
        {
            public string Name { get; set; }
            public int Cost { get; set; }

            public Service(string name, int cost)
            {
                Name = name;
                Cost = cost;
            }
        }

        public class ServiceBuilder
        {
            private Services _services;
            public ServiceBuilder()
            {
                _services = new Services();
            }
            public ServiceBuilder Travel(string name, int cost)
            {
                _services.Travel = new Service(name, cost);
                return this;
            }
            public ServiceBuilder Accomodation(string name, int cost)
            {
                _services.Accomodation = new Service(name, cost);
                return this;
            }
            public ServiceBuilder Nutrition(string name, int cost)
            {
                _services.Nutrition = new Service(name, cost);
                return this;
            }
            public ServiceBuilder MusiemsVisiting(string name, int cost)
            {
                _services.MusiemsVisiting = new Service(name, cost);
                return this;
            }
            public ServiceBuilder ExhibitionsVisiting(string name, int cost)
            {
                _services.ExhibitionsVisiting = new Service(name, cost);
                return this;
            }
            public ServiceBuilder ExcursionsVisiting(string name, int cost)
            {
                _services.ExcursionsVisiting = new Service(name, cost);
                return this;
            }

            public static implicit operator Services(ServiceBuilder builder)
            {
                return builder._services;
            }
        }
    }
}
