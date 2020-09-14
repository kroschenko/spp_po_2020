using System;

namespace lab3_1
{
    class Program
    {
        static void Main(string[] args)
        {
            RectExample();        

        }
        private static void RectExample()
        {
            Rectangle first = new Rectangle();
            Rectangle second = new Rectangle(3, 4);

            Console.WriteLine(first.IsExist());
            Console.WriteLine(second.Perimeter());

            first.Height = 4;
            first.Width = 4;

            Console.WriteLine(first.IsSquare());
            Console.WriteLine(second.Area());

            Console.WriteLine(first.Equals(second));
            second.Width = 4;
            Console.WriteLine(first.Equals(second));
            Console.WriteLine(second.Equals(first));

            Console.WriteLine(first);
        }
    }

    class Rectangle
    {
        private float _width;
        private float _height;
        public float Width { get => _width; set => _width = value; }
        public float Height { get => _height; set => _height = value; }

        public Rectangle() { }
        public Rectangle(float width, float height)
        {
            _width = width;
            _height = height;
        }

        public float Perimeter() => IsExist() ? Width * 2 + Height * 2 : 0;
        public float Area() => IsExist() ? Width * Height : 0;
        public bool IsSquare() => Width == Height && IsExist();
        public bool IsExist() => Width > 0 && Height > 0;

        public override bool Equals(object obj)
        {
            Rectangle other = obj as Rectangle;
            if (other == null)
            {
                return false;
            }

            if (other.GetType() == GetType())
            {
                return Width == other.Width && Height == other.Height;
            }
            else
            {
                return false;
            }
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Width, Height);
        }

        public override string ToString()
        {
            return $"Width:{Width} - Height:{Height}";
        }
    }
}
