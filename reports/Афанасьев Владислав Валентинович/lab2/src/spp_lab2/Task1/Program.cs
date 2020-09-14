using System;
using System.IO;

namespace spp_lab2
{
    class Program
    {
        static void task1(string[] args)
        {
            string value = string.Empty;
            string temp = string.Empty;
            bool marker = true;
            string chrs = "!@#,.$%^&*()№;%:?-+/'";

            if (!File.Exists(args[0])) throw new Exception("File not exists");

            using (StreamReader sr = new StreamReader(args[0]))
            {
                while ((value = sr.ReadLine()) != null)
                {
                    for (int i = 0; i < value.Length; ++i)
                    {
                        for (int j = 0; j < chrs.Length; ++j)
                        {
                            if (value[i] == chrs[j]) marker = false;
                        }

                        if (marker) temp += value[i];
                        marker = true;
                    }

                    string[] str_rev = temp.Split();
                    Array.Reverse(str_rev);
                    foreach (var i in str_rev)
                    {
                        Console.Write(i + ' ');
                    }

                    Console.WriteLine();

                    temp = string.Empty;
                }
            }
        }

        static void Main(string[] args)
        {
            try
            {
                task1(args);
            }
            catch(Exception Ex)
            {
                Console.WriteLine(Ex.Message);
            }
        }
    }
}
