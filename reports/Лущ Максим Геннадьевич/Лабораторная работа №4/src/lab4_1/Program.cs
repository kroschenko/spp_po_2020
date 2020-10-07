using System;
using System.Collections.Generic;

namespace lab4_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Department department = new Department();
            department.Statuses.AddRange(new List<Department.Status>()
            { 
                new Department.Status() { StatusName = "Director" },
                new Department.Status() { StatusName = "Worker" },
                new Department.Status() { StatusName = "Manager" },
                new Department.Status() { StatusName = "Consulter" },
                new Department.Status() { StatusName = "Junior" },
                new Department.Status() { StatusName = "Middle" },
                new Department.Status() { StatusName = "Senior" },
                new Department.Status() { StatusName = "Tester" },
                new Department.Status() { StatusName = "DevOps" }               
            });

            department.Employees.AddRange(new List<Department.Employee>()
            {
                new Department.Employee(),
                new Department.Employee(),
            });

            department.Employees[0].CurrentStatus = department.Statuses[7];
            department.Employees[0].CurrentStatus = department.Statuses[4];
            department.Employees[0].CurrentStatus = department.Statuses[5];
            department.Employees[0].CurrentStatus = department.Statuses[6];

            department.Employees[1].CurrentStatus = department.Statuses[7];
            department.Employees[1].CurrentStatus = department.Statuses[2];
            department.Employees[1].CurrentStatus = department.Statuses[1];

            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("Список должностей:");
            foreach (var status in department.Statuses)
            {
                Console.WriteLine(status);
            }

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("Предыдущие должности первого сотрудника:");
            foreach (var status in department.Employees[0].PrevStatuses)
            {
                Console.WriteLine(status);
            }

            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.WriteLine("Предыдущие должности второго сотрудника:");
            foreach (var status in department.Employees[0].PrevStatuses)
            {
                Console.WriteLine(status);
            }

            Console.ForegroundColor = ConsoleColor.White;
        }
    }

    class Department
    {
        public List<Employee> Employees { get; set; }
        public List<Status> Statuses { get; set; }
        public Department()
        {
            Statuses = new List<Status>();
            Employees = new List<Employee>();
        }

        internal class Employee
        {
            private List<Status> _prevStatuses;
            private Status _currentStatus;

            public string Info { get; set; }
            public IReadOnlyCollection<Status> PrevStatuses { get => _prevStatuses; }

            public Status CurrentStatus
            {
                get => _currentStatus;
                set
                {
                    if (_currentStatus != null)                    
                        _prevStatuses.Add(_currentStatus);
                    
                    _currentStatus = value;
                }
            }
            public Employee()
            {
                _prevStatuses = new List<Status>();                
            }           
        }        
        internal class Status
        {
            public string StatusName { get; set; }
            public override string ToString()
            {
                return StatusName;
            }
        }
    }

}
