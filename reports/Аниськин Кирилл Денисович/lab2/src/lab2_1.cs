using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;
namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)

        {

            string directory = Directory.GetCurrentDirectory() + "/";

            string fileName = "file.txt";

            string[] words = new string[0];

            int[] wordsCount = new int[0];

            int size = 0;

            bool check;

            using (StreamReader fs = new StreamReader($"{directory}{fileName}"))

            {

                while (!fs.EndOfStream)

                {

                    check = false;

                    string[] temp = fs.ReadLine().Split(' ');

                    for (int i = 0; i < temp.Length; i++)

                    {

                        for (int j = 0; j < words.Length; j++)

                        {

                            if (temp[i] == words[j])

                            {

                                check = true;

                                wordsCount[j]++;

                                break;

                            }

                        }

                        if (!check)

                        {

                            size++;

                            Array.Resize(ref words, size);

                            Array.Resize(ref wordsCount, size);

                            words[words.Length - 1] = temp[i];

                            wordsCount[words.Length - 1] = 1;

                        }

                    }

                }

            }

            int temp1;

            string temp2;

            for (int i = 0; i < wordsCount.Length - 1; i++)

            {

                for (int j = i + 1; j < wordsCount.Length; j++)

                {

                    if (wordsCount[i] < wordsCount[j])

                    {

                        temp1 = wordsCount[i];

                        wordsCount[i] = wordsCount[j];

                        wordsCount[j] = temp1;

                        temp2 = words[i];

                        words[i] = words[j];

                        words[j] = temp2;

                    }

                }

            }

            for (int i = 0; i < words.Length; i++)

            {

                Console.WriteLine($"{wordsCount[i]} | {words[i]} ");

            }

            Console.ReadKey();

        }
    }
}