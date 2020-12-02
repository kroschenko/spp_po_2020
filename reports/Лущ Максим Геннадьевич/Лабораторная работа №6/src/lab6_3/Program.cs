using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace lab6_3
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

            Iterator<ExplorerComponent> displayer = folder1.GetIterator();


            while (!displayer.IsDone())
            {
                Console.WriteLine(displayer.Next().GetInfo());
            }
        }
    }

    abstract class ExplorerComponent
    {
        public abstract Iterator<ExplorerComponent> GetIterator();       
        public virtual void Add(ExplorerComponent component) { }
        public virtual void Remove(ExplorerComponent component) { }
        public virtual string GetInfo() { return string.Empty; }
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

        public override Iterator<ExplorerComponent> GetIterator()
        {
            return new RandomIterator(this);
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

        public override Iterator<ExplorerComponent> GetIterator()
        {
            return null;
        }
    }

    abstract class Iterator<T>
    {
        public abstract T Next();
        public abstract bool IsDone();
        public abstract T CurrentItem { get; }
    }

    class RandomIterator : Iterator<ExplorerComponent>
    {
        private readonly ExplorerComponent _iterable;
        private ExplorerComponent _current;
        private Directory _currentDirectory;
        private Iterator<ExplorerComponent> _directoryIterator;
        private int[] _indexes;
        private int _currentIndex;

        public RandomIterator(ExplorerComponent explorerComponent)
        {
            _iterable = explorerComponent;
            _currentDirectory = _iterable as Directory;

            _indexes = new int[_currentDirectory.Items.Count];
            for (int i = 0; i < _currentDirectory.Items.Count; i++)
            {
                _indexes[i] = i;
            }

            Random random = new Random(DateTime.Now.Millisecond);
            _indexes = _indexes.OrderBy(x => random.Next()).ToArray();

            _currentIndex = 0;
        }
        public override ExplorerComponent CurrentItem { get => _current; }
           

        public override ExplorerComponent Next()
        {
            if (_directoryIterator != null)
            {
                if (!_directoryIterator.IsDone())
                {
                    return _directoryIterator.Next();
                }
                else
                {
                    _directoryIterator = null;
                }
            }

            _current = _currentDirectory.Items.ElementAt(_indexes[_currentIndex]);                

            if (_current is Directory)
            {
                _directoryIterator = (_current as Directory).GetIterator();
            }

            _currentIndex += 1;
            return _current;           
        }
       
        public override bool IsDone()
        {
            bool isDone = _directoryIterator != null ? _directoryIterator.IsDone() : true;          
            return _currentIndex >= _indexes.Length && isDone;
        }
    }



}
