using System;

namespace lab1_2
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                var result = ShiftRight(args[0..^1], Convert.ToInt32(args[^1]));
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
        private static T[] ShiftRight<T>(T[] array, int shift)
        {
            shift = shift % array.Length;
            T[] result = new T[array.Length];
            for (int i = 0, j = 0; i < array.Length; i++)
            {
                if (i < shift)
                {
                    result[i] = array[^(shift - i)];
                }
                else if (i >= shift)
                {
                    result[shift + j] = array[i - shift];
                    j++;
                }
            }
            return result;
        }
    }
}
