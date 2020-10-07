using System;

namespace lab5_2
{
    class Program
    {
        static void Main(string[] args)
        {
            //Dog dog = new Dog("Владос", 5000, 0.4f);
            //Cat cat = new Cat("Смэрть", 5000, 0.4f);
            //dog.Damage = 100;
            //cat.Damage = 90;
            //Fight(dog, cat);'

            HomeAnimal[] animals = new HomeAnimal[3];
            animals[0] = new Dog("Master", 100, 0.2f, 10);
            animals[1] = new Cat("Shadow", 100, 0.5f, 10);
            animals[2] = new Parrot("Death");

            animals[1].Hit(animals[2]);
            animals[0].Hit(animals[1]);
            animals[1].Heal(10);

        }

        static void Fight(HomeAnimal first, HomeAnimal second)
        {
          
            while (first.IsAlive && second.IsAlive)
            {
                if (first.IsAlive)
                {
                    first.Hit(second);
                }
                if (second.IsAlive)
                {
                    second.Hit(first);
                }
                Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }

    abstract class HomeAnimal
    {
        public readonly string name;
        private float _health;
        private float _maxHealth;
        private bool _isAlive;

        public float Health { get => _health; }
        public bool IsAlive { get => _isAlive; }

        public HomeAnimal(string name, float health)
        {
            this.name = name;
            _isAlive = true;
            _health = health;
            _maxHealth = health;    
        }
        public void Heal(int health)
        {
            _health += health;
            if (_health > _maxHealth)            
                _health = _maxHealth;


            Console.WriteLine($"Животное по кличке {name} излечили на {health} hp. Текущее здоровье:{_health}");
        }

        public virtual void ApplyDamage(float damage)
        {
            _health -= damage;
            if (_health <= 0)
            {
                Die();
            }
        }
        protected virtual void Die()
        {
            _isAlive = false;
        }
        public abstract void Hit(HomeAnimal animal);
    }

    class Dog : HomeAnimal
    {
        private float _damage;
        private float _resist;

        public float Damage
        {
            get => _damage;
            set
            {
                if (value > 0)
                    _damage = value;
                else
                    Console.WriteLine("Урон должен быть больше нуля");
            }
        }
        public float Resist 
        { 
            set
            {
                if (value >= 0 && value < 1f)                
                    _resist = value;                
                else                
                    Console.WriteLine("Сопротивление должно быть в промежутке: [0, 1)");                
            }
        }

        public Dog(string name, float health, float resist, float damage) : base(name, health)
        {
            Resist = resist;
            Damage = damage;
        }
               
        public override void ApplyDamage(float damage)
        {
            damage = damage - _resist * damage;
            Console.WriteLine($"Собака получает {damage} урона с учётом сопротивления. Текущее здоровье: {Health}");
            base.ApplyDamage(damage);
        }

        protected override void Die()
        {
            Console.WriteLine($"Собаку по кличке {name} съели");
            base.Die();
        }

        public override void Hit(HomeAnimal animal)
        {
            Console.WriteLine($"Собака {name} наносит урон животному по кличке {animal.name}. Урон: {Damage}");
            animal.ApplyDamage(Damage);
        }
    }

    class Cat : HomeAnimal
    {
        private float _damage;
        private float _evasionChance;
        public float Damage 
        { 
            get => _damage;
            set
            {
                if (value > 0)
                    _damage = value;
                else
                    Console.WriteLine("Урон должен быть больше нуля");
            }
        }
        public float EvasionChance
        {
            set
            {
                if (value > 0 && value < 1f)
                    _evasionChance = value;
                else
                    Console.WriteLine("Шанс уворота должен быть в промежутке: [0, 1)");
            }
        }
        public Cat(string name, float health, float evasionChance, float damage) : base(name, health)
        {
            EvasionChance = evasionChance;
            Damage = damage;
        }
        public override void ApplyDamage(float damage)
        {
            Random random = new Random();
            if (random.NextDouble() < _evasionChance)
            {
                Console.WriteLine($"Кот уворачивается от удара. Текущее здоровье: {Health}");
            }
            else
            {
                Console.WriteLine($"Кот получает {damage} урона. Текущее здоровье: {Health}");
                base.ApplyDamage(damage);
            }            
        }
        protected override void Die()
        {
            Console.WriteLine($"Кота по кличке {name} съели");
            base.Die();
        }

        public override void Hit(HomeAnimal animal)
        {
            Console.WriteLine($"Кот {name} наносит урон животному по кличке {animal.name}. Урон: {Damage}");
            animal.ApplyDamage(Damage);
        }
    }

    class Parrot : HomeAnimal
    {
        public Parrot(string name) : base(name, health: 1) { }
        protected override void Die()
        {
            Console.WriteLine($"Попугая по кличке {name} съели");
            base.Die();
        }

        public override void Hit(HomeAnimal animal) 
        {
            Console.WriteLine("У попугая слишком мало урона");
        }
    }
}
