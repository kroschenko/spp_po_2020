using System;
using System.Collections.Generic;

namespace lab1_3
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string str = string.Concat(args[0..^1]);
                Console.WriteLine(PangramEng(str, Convert.ToInt32(args[^1])));
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }           
        }

        private static bool PangramEng(string str, int precision = 2)
        {
            str = str.ToLower();
            char[] arrEn = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
            Dictionary<char, int> pairs = new Dictionary<char, int>();
            for (int i = 0; i < arrEn.Length; i++)
            {
                pairs.Add(arrEn[i], 0);
            }

            for (int i = 0; i < str.Length; i++)
            {
                if (pairs.ContainsKey(str[i]))
                {
                    pairs[str[i]] += 1;
                }
            }

            int numOfLetters = 0;
            foreach (var item in pairs)
            {
                if (item.Value > 0)
                {
                    numOfLetters += 1;
                }
            }

            return (numOfLetters > arrEn.Length - precision && numOfLetters <= arrEn.Length);
        }
    }
}
