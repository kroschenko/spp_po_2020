import java.util.ArrayList;

public class task2{
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        Manager manager = new Manager("Dima", 30, 3);
        workers.add(manager);
        manager.sayHello();
        manager.getSalary();

        Analyst analyst = new Analyst("Elena", 31, 7);
        workers.add(analyst);
        analyst.sayHello();
        analyst.getSalary();
        analyst.getCountOfWorkingHours();

        Programmer programmer = new Programmer("QWEERTY");
        programmer.sayHello();
        programmer.getSalary();
        programmer.getCurrentProjectName();

        Tester tester = new Tester("DFG", 6);
        tester.sayHello();
        tester.getSalary();
        tester.getCurrentProjectName();


    }
}

interface Worker{
    void getSalary();
    void sayHello();
}



class Manager implements Worker{
    
    String position;
    int salary;
    String name;
    int age;
    int experience;
    int bonus;

    public Manager(String name, int age, int experience){
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = 200;
        this.position = "manager";
        this.bonus = 100;
    }
    

    public void getSalary() {
        System.out.println("My salary is " + (salary + bonus));
    }

    public void sayHello(){
        System.out.println("Hello! My name is " + name +" .I am a " + position + "! " + "I'm " + age + ".");
    }

}

 class Analyst implements Worker{
    
    String position;
    int salary;
    String name;
    int age;
    int experience;
    int bonus = 250;

    public Analyst(String name, int age, int experience){
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = 250;
        this.position = "analyst";
        this.bonus = 250;
    }
    

    public void getSalary() {
        System.out.println("My salary is " + (salary + bonus));
    }

    public void sayHello(){
        System.out.println("Hello! My name is " + name +" .I am a " + position + "! " + "I'm " + age + ". My experience is " + experience + " years.");
    }

    public void getCountOfWorkingHours(){
       System.out.println("My working hours: " + (experience > 5 ? 8 : 10));
    }

}

 class Programmer implements Worker{
    
    String position;
    int salary;
    String projectName;
    int bonus;

    public Programmer(String projectName){
       this.projectName = projectName;
        this.salary = 1000;
        this.position = "programmer";
        this.bonus = 500;
    }
    

    public void getSalary() {
        System.out.println("My salary is " + (salary + bonus));
    }
    

    public void getCurrentProjectName(){
       System.out.println("My current project is " + projectName);
    }

    public void sayHello(){
        System.out.println("Hello! I am a " + position + "!");
    }

}

 class Tester implements Worker{
    
    String position;
    int salary;
    int experience;
    String projectName;
    int bonus;

    public Tester(String projectName, int experience){
        this.projectName = projectName;
        this.experience = experience;
        this.salary = 800;
        this.position = "tester";
        this.bonus = 700;
    }
    

    public void getSalary() {
        System.out.println("My salary is " + (salary + bonus));
    }
    
    public void sayHello(){
        System.out.println("Hello! I am a " + position + "! My experience is " + experience  + " years.");
    }

    public void getCurrentProjectName(){
       System.out.println("My current project is " + projectName);
    }

}