using System;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using System.Text;

namespace lab4_3
{
    static class HospitalFactory
    {
        public static Hospital CreateHospital(int numOfDoctors, int numOfNurces)
        {
            Hospital result = new Hospital();
            for (int i = 0; i < numOfDoctors; i++)
            {
                result.AddDoctor(new Doctor());
            }
            for (int i = 0; i < numOfNurces; i++)
            {
                result.AddNurce(new Nurse());
            }
            return result;
        }
    }
}
