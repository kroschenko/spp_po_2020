using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Security.Cryptography;

namespace lab4_3
{
    class Program
    {
        static void Main(string[] args)
        {
            Hospital hospital = HospitalFactory.CreateHospital(numOfDoctors: 4, numOfNurces: 2);
            Patient[] patients = new Patient[]
            {
                new Patient("Иван Петрович"),
                new Patient("Михаил Викотрович"),
                new Patient("Мария Викторовна"),
                new Patient("Владислав Валентинович"),
                new Patient("Александр Александрович"),
                new Patient("Анастасия Андреевна"),
                new Patient("Мария Андреевна")
            };

            for (int i = 0; i < patients.Length; i++)
            {
                hospital.AddPatient(patients[i]);
            }

            
            hospital.AppointPatient(Appointment.Medications);
            hospital.TreatPatient();

            hospital.TreatPatient(patients[2], "нарушение режима");

        }
    }    
}
