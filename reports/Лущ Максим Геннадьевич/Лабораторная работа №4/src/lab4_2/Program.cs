using System;
using System.Collections.Generic;
using System.Linq;

namespace lab4_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Paragraph paragraph = new Paragraph();
            paragraph.Append("some text ");
            paragraph.AppendLine("End of line");
            paragraph.AppendLine("Second line");
            paragraph.Append("Some text");
            Console.WriteLine(paragraph.Text);
            paragraph.Clear();
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Console.WriteLine("After clear");
            Console.WriteLine(paragraph.Text);
        }
    }

    class Paragraph
    {
        private List<String> _strings;

        public string Text
        {
            get => string.Concat(_strings.Select(x => x.Str));
        }

        public void AppendLine(string newLine)
        {
            Append(newLine + "\n");
        }

        public void Append(string newLine)
        {
            _strings.Add(new String(newLine));
        }    

        public void Clear()
        {
            _strings = new List<String>();
        }

        public Paragraph()
        {
            _strings = new List<String>();
        }

        class String
        {
            public string Str { get; set; }
            public String(string str)
            {
                Str = str;
            }
            public override string ToString()
            {
                return Str;
            }
        }
    }
}
