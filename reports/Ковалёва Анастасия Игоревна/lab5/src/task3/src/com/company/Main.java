package com.company; import java.util.ArrayList;

interface Do {
    void work(Course obj);
}

class Archive {
    Optional.Student student;
    int mark;
    Archive(Optional.Student student,int mark)  {
        this.student = student;
        this.mark = mark;
    }
    void show() {
        student.show();
        System.out.println("Mark: " + mark);
        System.out.println();
    }
}

class Optional {
    private ArrayList<Archive> arh;
    private ArrayList<Course> arr;

    Optional() {
        arh = new ArrayList<Archive>();
        arr = new ArrayList<Course>();
    }

    void add(Course obj) {
        arr.add(obj);
    }

    void showCourse() {
        for (Course course: arr) {
            course.show();
        }
    }

    void showArchive() {
        for (Archive archive: arh) {
            archive.show();
        }
    }

    class Teacher extends Person implements Do {
        Teacher(String name) {
            super(name);
        }

        void addCourse(Course course) {
            work(course);
        }

        public void work(Course obj) {
            add(obj);
        }

        void setMark(Student student, int mark) {
            if (student.isLearning()) {
                student.setMark(mark);
                Archive archive = new Archive(student, mark);
                arh.add(archive);
            }
        }
    }

    class Student extends Person implements Do {
        int mark;
        Course studCourse;
        boolean learn;

        Student(String name) {
            super(name);
            learn = false;
        }
        public void work(Course obj) {
            if (arr.contains(obj)) {
                studCourse = obj;
                System.out.println("Added course");
                learn = true;
            } else {
                System.out.println("No such course");
            }
        }

        boolean isLearning() {
            return learn;
        }

        void setMark(int mark) {
            this.mark = mark;
        }

        void show() {
            System.out.print("Student name:");
            super.show();
            studCourse.show();
        }
    }
}

abstract class Person {
    String name;
    Person() {
        name = "";
    }
    Person(String name) {
        this.name=name;
    }
    void show() {
        System.out.println(name);
    }
}

class Course {
    int num;
    String title;
    Course() {
        num = 0;
        title = "";
    }
    Course(String title, int num) {
        this.title=title;
        this.num=num;
    }
    void show() {
        System.out.println("Course num: " + num);
        System.out.println("Course name: " + title);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Optional class1 = new Optional();

        Optional.Teacher teacher1= class1.new Teacher("Alex");
        Optional.Teacher teacher2= class1.new Teacher("Kate");

        Course mathCourse = new Course("Math",1);
        Course historyCourse = new Course("History",2);
        Course englishCourse = new Course("English",3);

        teacher1.addCourse(mathCourse);
        teacher2.addCourse(historyCourse);
        teacher2.addCourse(englishCourse);

        Optional.Student student1 = class1.new Student("Liz");
        Optional.Student student2 = class1.new Student("Nastya");

        student2.work(englishCourse);
        student1.work(historyCourse);

        teacher2.setMark(student1,9);
        teacher1.setMark(student2,7);

        class1.showCourse();
        System.out.println("-----------------");
        class1.showArchive();
    }
}

