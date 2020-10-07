using System;
using System.Collections.Generic;
using System.Linq;

namespace lab4_3
{
    class Hospital
    {
        private List<Doctor> _doctors;
        private List<HospitalWorker> _nurses;

        private Queue<IAppointable> _patients;
        private Queue<IAppointable> _appointPatients;

        public IReadOnlyCollection<Doctor> Doctors { get => _doctors; }
        public IReadOnlyCollection<HospitalWorker> Nurces { get => _nurses; }
        public IReadOnlyCollection<IAppointable> Patients { get => _patients.ToList(); }
        public IReadOnlyCollection<IAppointable> AppointPatients { get => _appointPatients.ToList(); }

        public Hospital()
        {
            _doctors = new List<Doctor>();
            _nurses = new List<HospitalWorker>();

            _patients = new Queue<IAppointable>();
            _appointPatients = new Queue<IAppointable>();
        }

        public Hospital(IEnumerable<Doctor> doctors, IEnumerable<Nurse> nurses) : this()
        {
            _doctors.AddRange(doctors);
            _nurses.AddRange(nurses);
        }

        public void AddPatient(IAppointable patient)
        {
            _patients.Enqueue(patient);
        }

        public void AddDoctor(Doctor doctor)
        {
            _doctors.Add(doctor);
        }

        public void AddNurce(Nurse nurse)
        {
            _nurses.Add(nurse);
        }

        public void AppointPatient(Appointment appointment)
        {
            if (_patients.Count > 0)
            {
                IAppointable first = _patients.Dequeue();
                _doctors.Find(x => !x.IsBusy).MakeAppointment(first, appointment);
                _appointPatients.Enqueue(first);
                Console.WriteLine("");
            }
            else            
                throw new Exception("В больнице отсутствуют пациенты");
                      
        }

        public void TreatPatient()
        {
            if (_appointPatients.Count > 0)
            {
                IAppointable first = _appointPatients.Dequeue();
                HospitalWorker worker = _nurses.Find(x => !x.IsBusy) ??_doctors.Find(x => !x.IsBusy) as HospitalWorker;

                if (worker == null)                
                    throw new Exception("В больнице отсутствуют свободные врачи и медсёстры");                
                else
                {
                    worker.ExecuteAppointment(first);
                    if (first.IsIll)
                    {
                        _patients.Enqueue(first);
                        Console.WriteLine("Пациент не выздоровел и остаётся в больнице");
                    }
                    else
                    {
                        Console.WriteLine("Пациент выздоровел и выписан из больницы");
                    }
                }

            }
            else            
                throw new Exception("В больнице отсутствуют пациенты");
            
        }

        public void TreatPatient(IAppointable patient, string reason)
        {
            var patients = _patients.ToList();
            var appointPatients = _appointPatients.ToList();

            patients.Remove(patient);
            appointPatients.Remove(patient);

            _patients = new Queue<IAppointable>(patients);
            _appointPatients = new Queue<IAppointable>(appointPatients);
        }

        public void DisposeDoctor(int index)
        {
            if (index < 0 || index >= Doctors.Count)            
                throw new ArgumentOutOfRangeException();            
            else            
                _doctors[index].Dispose();            
        }

        public void DisposeNurce(int index)
        {
            if (index < 0 || index >= Doctors.Count)            
                throw new ArgumentOutOfRangeException();            
            else
                _nurses[index].Dispose();
        }
    }
}
