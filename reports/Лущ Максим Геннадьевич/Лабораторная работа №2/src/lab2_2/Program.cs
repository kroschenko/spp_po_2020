using System;
using System.IO;

namespace lab2_2
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                if (args.Length == 2 && File.Exists(args[0]))
                {
                    if (Directory.Exists(args[1]))
                    {
                        FileInfo source = new FileInfo(args[0]);
                        source.CopyTo(Path.Combine(args[1], source.Name));
                    }
                    else if (File.Exists(args[1]))
                    {
                        FileInfo source = new FileInfo(args[0]);
                        source.CopyTo(args[1]);
                    }
                }
                else if (args.Length == 3 && args[0][0] == '-' && File.Exists(args[1]))
                {
                    bool rewrite = false;
                    bool delete = false;
                    if (args[0].Contains('f'))
                    {
                        delete = true;
                    }
                    if (args[0].Contains('i'))
                    {
                        char responce = Console.ReadKey().KeyChar;
                        Console.WriteLine();
                        if (responce == 'y')
                        {
                            rewrite = true;
                        }
                    }
                    if (args[0].Contains('n'))
                    {
                        rewrite = false;
                    }

                    if (Directory.Exists(args[2]))
                    {
                        FileInfo source = new FileInfo(args[1]);
                        source.CopyTo(Path.Combine(args[2], source.Name));
                    }
                    else if (File.Exists(args[2]))
                    {
                        FileInfo source = new FileInfo(args[1]);
                        FileInfo dest = new FileInfo(args[2]);
                        if (dest.IsReadOnly && delete)
                        {
                            dest.Attributes = FileAttributes.Normal;
                            dest.Delete();
                            source.CopyTo(Path.Combine(dest.Directory.FullName, source.Name), rewrite);
                        }
                        else
                        {
                            source.CopyTo(args[2], rewrite);
                        }
                    }
                }
                else
                    throw new ArgumentException("Incorrect command format");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
