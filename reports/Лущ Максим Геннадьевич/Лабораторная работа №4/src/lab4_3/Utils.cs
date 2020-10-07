using System;
using System.Collections.Generic;
using System.Text;

namespace lab4_3
{
    public enum Appointment { Procedures, Medications, Operations }
    public static class AppointmentExtention
    {
        public static bool ExecuteAppointment(this Appointment appointment, string patientFullname, float healChance = 0.5f)
        {
            Random random = new Random();
            bool isIll = random.NextDouble() < healChance;

            Console.WriteLine("Пациент {0} выполнил направление и {1}", patientFullname, isIll ? "не выздоровел" : "выздоровел");
            return isIll;
        }
    }

}
