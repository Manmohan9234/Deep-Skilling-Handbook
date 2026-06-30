<<<<<<< HEAD
class Student {

    private static Student instance;

    private String name;
    private int rollNo;

    private Student() {
        name = "Manmohan Kumar";
        rollNo = 101;
    }

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
    }
}
public class SingletonTest {

    public static void main(String[] args) {

        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();

        student1.displayDetails();

        if (student1 == student2) {
            System.out.println("Only one student object exists.");
        } else {
            System.out.println("Multiple student objects created.");
        }
    }
=======
class Student {

    private static Student instance;

    private String name;
    private int rollNo;

    private Student() {
        name = "Manmohan Kumar";
        rollNo = 101;
    }

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
    }
}
public class SingletonTest {

    public static void main(String[] args) {

        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();

        student1.displayDetails();

        if (student1 == student2) {
            System.out.println("Only one student object exists.");
        } else {
            System.out.println("Multiple student objects created.");
        }
    }
>>>>>>> 07bf603f52ca267bbc8fcd875de0a2201b47b17f
}