using System;
using System.Collections.Generic;
using System.Text;

namespace lab4_3
{
    abstract class HospitalWorker : IDisposable
    {
        protected bool _isBusy = false;
        public bool IsBusy { get => _isBusy; }

        public virtual void ExecuteAppointment(IAppointable patient)
        {
            _isBusy = true;
            patient.Treat();
        }

        public void Dispose() => _isBusy = false;
        
    }
    sealed class Doctor : HospitalWorker
    {
        public void MakeAppointment(IAppointable patient, Appointment appointment)
        {
            _isBusy = true;
            patient.GiveAppointment(appointment);
        }


        public override void ExecuteAppointment(IAppointable patient)
        {
            base.ExecuteAppointment(patient);
            Console.WriteLine("Врач выполнил назначение");
        }

    }
    sealed class Nurse : HospitalWorker 
    {
        public override void ExecuteAppointment(IAppointable patient)
        {
            base.ExecuteAppointment(patient);
            Console.WriteLine("Медсестра выполнила назначение");
        }
    }
}
