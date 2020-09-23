using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace lab2_1
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                var result = NumOfPalindroms(args[0]);
                Console.WriteLine($"Num of palindroms:{result.Item1}");
                foreach (var item in result.Item2)
                {
                    Console.WriteLine(item);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }           

        }
        private static (int, IEnumerable<string>) NumOfPalindroms(string path)
        {
            IEnumerable<string> result = null;
            using (StreamReader reader = new StreamReader(path))
            {
                string temp = reader.ReadToEnd().ToLower();
                result = Regex.Split(temp, @"[^а-я]").Where(x => !string.IsNullOrEmpty(x));
            }
            result = result.Where(x => IsPalindrom(x));
            return (result.Count(), result);

        }
        private static bool IsPalindrom(string word) => word == new string(word.Reverse().ToArray()) && word.Length >= 3;
    }
}
