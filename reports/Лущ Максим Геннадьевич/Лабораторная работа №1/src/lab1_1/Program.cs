using System;

namespace lab1_1
{
    class Program
    {
        static void Main(string[] args)
        {            
            try
            {
                int[] arr = new int[args.Length];
                for (int i = 0; i < args.Length; i++)
                {
                    arr[i] = Convert.ToInt32(args[i]);
                }
                var result = ReverceSort(arr);
                foreach (var item in result)
                {
                    Console.Write($"{item} ");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);               
            }                       
        }
        private static int[] ReverceSort(int[] args)
        {
            Array.Sort(args, (x, y) => y.CompareTo(x));
            return args;
        }
    }
}
