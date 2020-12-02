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

            string directory1 = Directory.GetCurrentDirectory() + @"\";

            string directory2 = Directory.GetCurrentDirectory() + @"\";

            string firstFile = "";

            string secondFile = "";

            Console.WriteLine("Введите команду:");

            string[] command = Console.ReadLine().Split(' ');

            int iShag = 1, lNull = 0;

            Alignment alignment = Alignment.left;

            if (command.Length < 3)

                return;

            for (int i = 0; i < command.Length; i++)

            {

                if (i == 0)

                    if (command[i] != "nl")

                        return;

                if (command[i] == "-i")

                {

                    i++;

                    iShag = Convert.ToInt32(command[i]);

                }

                if (command[i] == "-l")

                {

                    i++;

                    lNull = Convert.ToInt32(command[i]);

                }

                if (command[i] == "-n")

                {

                    i++;

                    switch (command[i])

                    {

                        case "ln":

                            alignment = Alignment.left;

                            break;

                        case "rn":

                            alignment = Alignment.right;

                            break;

                        case "rz":

                            alignment = Alignment.rightWithNull;

                            break;

                        default:

                            Console.WriteLine("something go wrong");

                            return;

                    }

                }

                if (i == command.Length - 2)

                    if (command[i].Contains(".txt"))

                    {

                        firstFile += command[i];

                        secondFile += command[++i];

                    }

                    else

                    {

                        firstFile += command[++i];

                    }

            }

            int count = 0;

            int num = 1;

            string[] words = new string[0];

            using (StreamReader fs = new StreamReader($@"{directory1}{firstFile}"))

            {

                while (!fs.EndOfStream)

                {

                    count++;

                    string temp = fs.ReadLine();

                    if (lNull == 0)

                        if (temp == "")

                        {

                            Array.Resize(ref words, count);

                            words[words.Length - 1] = temp;

                            continue;

                        }

                    Array.Resize(ref words, count);

                    words[words.Length - 1] = Numbering(temp, alignment, num);

                    num += iShag;

                }

            }

            for (int i = 0; i < words.Length; i++)

            {

                Console.WriteLine(words[i]);

            }

            if (secondFile != "")

            {

                using (StreamWriter sw = new StreamWriter($@"{directory2}{secondFile}"))

                {

                    for (int i = 0; i < words.Length; i++)

                        sw.WriteLine(words[i]);

                }

            }

            Console.ReadKey();

        }

        static string Numbering(string str, Alignment alignment, int num)

        {

            switch (alignment)

            {

                case Alignment.left:

                    str = num + ". " + str;

                    break;

                case Alignment.right:

                    str = str + " ." + num;

                    break;

                case Alignment.rightWithNull:

                    string result = String.Format("{0:D10}", num);

                    str = str + " ." + result;

                    break;

            }

            return str;

        }

        enum Alignment

        {

            left,

            right,

            rightWithNull

        }
    }
}