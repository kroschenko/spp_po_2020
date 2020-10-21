using System;
using System.Collections.Generic;

namespace lab6_2
{
    class Program
    {
        static void Main(string[] args)
        {
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
            Console.WriteLine(folder1.GetInfo());
        }
    }

    abstract class ExplorerComponent
    {
        public virtual void Add(ExplorerComponent component) { }
        public virtual void Remove(ExplorerComponent component) { }
        public virtual string GetInfo() { return string.Empty; }
    }

    class Directory : ExplorerComponent
    {
        private List<ExplorerComponent> _explorer;

        public string Name { get; set; }

        public Directory() => _explorer = new List<ExplorerComponent>();
        public Directory(string name) : this() => Name = name;

        public override void Add(ExplorerComponent component) => _explorer.Add(component);
        public override void Remove(ExplorerComponent component) => _explorer.Remove(component);
        public override string GetInfo() => Name;
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
    }
}
