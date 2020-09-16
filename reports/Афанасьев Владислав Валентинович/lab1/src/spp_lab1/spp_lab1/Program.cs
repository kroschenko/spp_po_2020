using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Runtime.InteropServices;

namespace spp_lab1
{
    class Program
    {
        static void task1(string[] args)
        {
            Console.WriteLine("Variant 2, Afanasev Vladislav Valentinovich, PO3");
            Console.WriteLine("Task 1");

            int temp;

            int max = int.MinValue, min = int.MaxValue, sum = 0, mult = 1;
            foreach (var item in args)
            {
                int.TryParse(item, out temp);
                mult *= temp;
                sum += temp;
                if (temp > max) max = temp;
                if (temp < min) min = temp;
            }
            Console.WriteLine("Min: "+min);
            Console.WriteLine("Max: "+max);
            Console.WriteLine("Sum: "+sum);
            Console.WriteLine("Mult: "+mult);
        }
        // -----------------------------------------------------
        static void reverse(double[] array)
        {
            double temp;
            for (int i = 0, k = array.Length - 1; i < array.Length / 2; ++i, --k)
            {
                temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }

        static void task2(string[] args)
        {
            Console.WriteLine("Task 2");

            double [] array = new double[args.Length];
            for(int i = 0; i < args.Length; ++i)
            {
                double.TryParse(args[i], out array[i]);
            }
            
            foreach (var item in array)
            {
                Console.Write(item + " ");
            }

            reverse(array);
            Console.WriteLine();

            foreach (var item in array)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();

        }
        // -----------------------------------------------------
        static bool polindrome(string str)
        {
            bool marker = true;

            string temp = string.Empty;
            string chrs = "!@#,.$%^&*()№;%:?-+/' ";

            for(int i = 0; i < str.Length; ++i)
            {
                for (int j = 0; j < chrs.Length; ++j)
                {
                    if (str[i] == chrs[j]) marker = false;
                    
                }
                
                if (marker) temp += str[i];
                marker = true;
            }

            temp = temp.ToLower();

            string temp_r = temp;

            temp_r = new string(temp_r.Reverse().ToArray());

            if (temp == temp_r) return true;
            else return false;
        }

        static void palin(bool marker)
        {
            if (marker) Console.WriteLine("Palindrome");
            else Console.WriteLine("No palindrome");
        }
        
        static void task3(string[] args)
        {
            string str = string.Empty;
            for (int i = 0; i < args.Length; ++i)
            {
                str += args[i];
            }
            Console.WriteLine("Task 3");      
            palin(polindrome(str));
        }

        static void Main(string[] args)
        {
            //task1(args);
            //task2(args);
            task3(args);
        }
    }
}
