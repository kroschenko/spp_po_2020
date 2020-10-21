using System;
using System.Collections.Generic;
using System.Linq;

namespace lab6_3
{
    class Program
    {
        static void Main(string[] args)
        {
            IDisplayer displayer = new ConsoleRandomDisplayer();


            ExplorerComponent folder1 = new Directory("Folder1");
            ExplorerComponent folder2 = new Directory("folder2");
            ExplorerComponent folder3 = new Directory("folder3");

            ExplorerComponent text = new File("text", DateTime.Now + TimeSpan.FromTicks(TimeSpan.TicksPerDay), 1000, "txt");
            ExplorerComponent exe = new File("pe", DateTime.Now + TimeSpan.FromTicks(TimeSpan.TicksPerDay * 2), 4356, "exe");
            ExplorerComponent png = new File("photo", DateTime.Now, 1000, "png");

            folder1.Add(folder2);
            folder1.Add(text);
            folder1.Add(exe);

            folder2.Add(folder3);
            folder2.Add(png);

            folder1.Display(displayer);
        }
    }

    abstract class ExplorerComponent: IDisplayable
    {
        public virtual void Add(ExplorerComponent component) { }
        public virtual void Remove(ExplorerComponent component) { }
        public virtual string GetInfo() { return string.Empty; }

        public abstract void Display(IDisplayer directory);
    }

    class Directory : ExplorerComponent
    {
        private List<ExplorerComponent> _items;

        public IReadOnlyCollection<ExplorerComponent> Items { get => _items; }

        public string Name { get; set; }

        public Directory() => _items = new List<ExplorerComponent>();
        public Directory(string name) : this() => Name = name;

        public override void Add(ExplorerComponent component) => _items.Add(component);
        public override void Remove(ExplorerComponent component) => _items.Remove(component);
        public override string GetInfo() => Name;

        public override void Display(IDisplayer directory)
        {
            directory.DisplayItem(this);
        }
    }

    class File : ExplorerComponent
    {
        public string Name { get; set; }
        public DateTime? CreationDate { get; set; }
        public uint Size { get; set; }
        public string Extension { get; set; }

        public File() { }
        public File(string name, DateTime date, uint size, string extension)
        {
            Name = name;
            CreationDate = date;
            Size = size;
            Extension = extension;
        }

        public override string GetInfo() => $"{Name} - {Extension} - {CreationDate} - {Size}";

        public override void Display(IDisplayer directory)
        {
            directory.DisplayItem(this);
        }
    }

    interface IDisplayable
    {
        void Display(IDisplayer directory);
    }

    interface IDisplayer
    {
        void DisplayItem(Directory directory);
        void DisplayItem(File directory);
    }

    class ConsoleRandomDisplayer : IDisplayer
    {
        public void DisplayItem(Directory directory)
        {
            int[] indexes = new int[directory.Items.Count];
            for (int i = 0; i < directory.Items.Count; i++)
            {
                indexes[i] = i;
            }

            Random random = new Random(DateTime.Now.Millisecond);
            indexes = indexes.OrderBy(x => random.Next()).ToArray();


            Console.WriteLine(directory.GetInfo());
            foreach (int index in indexes)
            {
                 directory.Items.ElementAt(index).Display(this);
            }
        }

        public void DisplayItem(File directory)
        {
            Console.WriteLine("\t" + directory.GetInfo());
        }
    }

}
