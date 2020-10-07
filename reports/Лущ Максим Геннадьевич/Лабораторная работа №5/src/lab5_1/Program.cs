using System;
using System.Text;

namespace lab5_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Book book = new Encyclopedia();
            book.Read();
            book = new Guide();
            book.Read();
            Guide guide = (Guide)book;
            guide.Read();
        }
    }

    abstract class Book
    {
        public Encoding Encoding { get; set; }
        public string Author { get; set; }
        public string Name { get; set; }
        public int PublishYear { get; set; }
        public string Publisher { get; set; }

        public abstract void Read();
    }
    class Encyclopedia : Book
    {
        public override void Read()
        {
            Console.WriteLine("Read Encyclopedia");
        }
    }
    class Guide : Book
    {
        public override void Read()
        {
            Console.WriteLine("Read Guide");
        }
    }
}
