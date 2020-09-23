using System;
using System.IO;
using System.Linq;
using System.Text;
using System.Collections.Generic;
using System.Xml.Serialization;

namespace lab3_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Library library = new Library("books.xml");

            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("Список книг:");
            foreach (var item in library.Books)
            {
                Console.WriteLine(item);
            }

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Console.WriteLine("Книги старше 1990 года:");
            foreach (var item in library.GetBooksElderThan(1990))
            {
                Console.WriteLine(item);
            }

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Console.WriteLine("Книги взятые на чтение:");
            foreach (var item in library.GetTakenForReading())
            {
                Console.WriteLine(item);
            }

            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Console.WriteLine("Книги взятые на чтение. Информация о читателях:");
            library.GetTakenForReadingWithInfo();


            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Console.WriteLine("Задержанные книги:");
            foreach (var item in library.GetDelayedBooks())
            {
                Console.WriteLine(item);
            }

            Console.ForegroundColor = ConsoleColor.White;
        }
    } 
    class Library
    {
        private List<Book> books = new List<Book>();
        public IReadOnlyCollection<Book> Books { get => books; }
        public void AddBook(Book book) => books.Add(book);
        public Library(string filePath) => ReadInfoFromFile(filePath);    
        public IEnumerable<Book> GetBooksElderThan(int publishYear) => books.Where(x => x.PublishYear > publishYear);
        public IEnumerable<Book> GetTakenForReading() => books.Where(x => x.BookDeliveryDeadline.HasValue);        
        public IEnumerable<Book> GetTakenForReadingWithInfo()
        {
            IEnumerable<Book> result = books.Where(x => x.BookDeliveryDeadline.HasValue);
            foreach (Book book in result)
            {
                Console.WriteLine($"Rader name: {book.ReaderFullName}");
            }
            return result;
        }
        public IEnumerable<Book> GetDelayedBooks() => books.Where(x => x.BookDeliveryDeadline.HasValue).Where(x => DateTime.Now > x.BookDeliveryDeadline);      

        public void ReadInfoFromFile(string path)
        {
            XmlSerializer formatter = new XmlSerializer(typeof(Book[]));
            using (FileStream fs = new FileStream(path, FileMode.Open))
            {
                books = ((Book[])formatter.Deserialize(fs)).ToList();
            }
        }

        public void WriteInfoInFile(string path, bool overwrite = true)
        {
            XmlSerializer formatter = new XmlSerializer(typeof(Book[]));
            using (FileStream fs = new FileStream(path, FileMode.OpenOrCreate))
            {
                formatter.Serialize(fs, books.ToArray());
            }
        }
    }

    [Serializable]
    public class Book
    {
        public int UDKNumber { get; set; }
        public string FullAuthorName { get; set; }
        public string Name { get; set; }
        public int PublishYear { get; set; }
        public int InstancesCount { get; set; }
        public int PagesCount { get; set; }
        public int VolumesCount { get; set; }
        public string ReaderFullName { get; set; }
        public DateTime? BookDeliveryDeadline { get; set; }
        public Book()
        {

        }

        public override string ToString()
        {
            StringBuilder result = new StringBuilder();
            result.Append($"UDKNumber: {UDKNumber},\n");
            result.Append($"Author name: {FullAuthorName},\n");
            result.Append($"Name: {Name},\n");
            result.Append($"Publish year: {PublishYear},\n");
            result.Append($"Instances: {InstancesCount},\n");
            result.Append($"Pages count: {PagesCount},\n");
            result.Append($"Volumes: {VolumesCount},\n");
            result.Append($"Reader: {ReaderFullName},\n");
            result.Append($"Book delivery deadline: {BookDeliveryDeadline};\n");
            return result.ToString();
        }
    }

}

abstract class Mediator
{
    public abstract void Send(string msg, Colleague colleague);
}
abstract class Colleague
{
    protected Mediator mediator;
    public Colleague(Mediator mediator)
    {
        this.mediator = mediator;
    }
}
class ConcreteColleague1 : Colleague
{
    public ConcreteColleague1(Mediator mediator) : base(mediator) { }
    public void Send(string message)
    {
        mediator.Send(message, this);
    }
    public void Notify(string message) { }
}

class ConcreteColleague2 : Colleague
{
    public ConcreteColleague2(Mediator mediator) : base(mediator) { }
    public void Send(string message)
    {
        mediator.Send(message, this);
    }
    public void Notify(string message) { }
}

class ConcreteMediator : Mediator
{
    public ConcreteColleague1 Colleague1 { get; set; }
    public ConcreteColleague2 Colleague2 { get; set; }
    public override void Send(string msg, Colleague colleague)
    {
        if (Colleague1 == colleague)
            Colleague2.Notify(msg);
        else
            Colleague1.Notify(msg);
    }
}