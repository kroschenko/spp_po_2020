using System;
using System.Collections.Generic;
using System.Text;

namespace lab4_3
{
    interface IAppointable
    {
        void Treat();
        public void GiveAppointment(Appointment appointment);

        public bool IsIll { get; set; }
    }
    sealed class Patient: IAppointable
    {
        public readonly string fullname;
        private Appointment? _appointment;
        private bool _isIll;

        public bool IsIll
        {
            get => _isIll;
            set
            {
                if (_isIll == false && value == true)
                {
                    Console.WriteLine("Больница пытается сделать здорового пациента больным");
                    return;
                }

                _isIll = value;
            }
        }

        public Patient(string fullname)
        {
            this.fullname = fullname;
            _isIll = true;
        }

        public void Treat()
        {
            if (_appointment.HasValue && IsIll)
            {
                Console.WriteLine("Пациента лечат");
                IsIll = _appointment.Value.ExecuteAppointment(fullname);
                _appointment = null;
            }
            else
                throw new Exception($"У пациента {fullname} отсутствует направление.");
        }

        public void GiveAppointment(Appointment appointment)
        {
            Console.WriteLine($"Пациенту {fullname} выдали направление {appointment}");
            _appointment = appointment;
        }
       
    }
}
