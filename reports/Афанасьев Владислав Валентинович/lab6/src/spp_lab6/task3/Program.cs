using System;

namespace task3
{
    class Program
    {
        static void Main(string[] args)
        {
            Context matrixPrinter = new Context(new MatrixPrinter());
            matrixPrinter.ExecuteAlgorithm();

            Context laserPrinter = new Context(new LaserPrinter());
            laserPrinter.ExecuteAlgorithm();

            Context colorPrinter = new Context(new ColorPrinter());
            colorPrinter.ExecuteAlgorithm();
        }
    }

    public interface IPrinter
    {
        void Print();
    }

    public class ColorPrinter : IPrinter
    {
        public void Print()
        {
            Console.WriteLine("Color print");
        }
    }

    public class MatrixPrinter : IPrinter
    {
        public void Print()
        {
            Console.WriteLine("Matrix print");
        }
    }

    public class LaserPrinter : IPrinter
    {
        public void Print()
        {
            Console.WriteLine("Laser print");
        }
    }

    public class Context
    {
        public IPrinter ContextPrinter { get; set; }

        public Context(IPrinter type)
        {
            ContextPrinter = type;
        }

        public void ExecuteAlgorithm()
        {
            ContextPrinter.Print();
        }
    }
}
