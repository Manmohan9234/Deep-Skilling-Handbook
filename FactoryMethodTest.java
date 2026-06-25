interface StudentType {
    void getCourse();
}

class EngineeringStudent implements StudentType {
    public void getCourse() {
        System.out.println("Student enrolled in Engineering Course");
    }
}

class MedicalStudent implements StudentType {
    public void getCourse() {
        System.out.println("Student enrolled in Medical Course");
    }
}

class CommerceStudent implements StudentType {
    public void getCourse() {
        System.out.println("Student enrolled in Commerce Course");
    }
}

class StudentFactory {

    public StudentType createStudent(String course) {

        if (course.equalsIgnoreCase("Engineering"))
            return new EngineeringStudent();

        if (course.equalsIgnoreCase("Medical"))
            return new MedicalStudent();

        if (course.equalsIgnoreCase("Commerce"))
            return new CommerceStudent();

        return null;
    }
}

public class FactoryMethodTest {

    public static void main(String[] args) {

        StudentFactory factory = new StudentFactory();

        StudentType s1 = factory.createStudent("Engineering");
        s1.getCourse();

        StudentType s2 = factory.createStudent("Medical");
        s2.getCourse();

        StudentType s3 = factory.createStudent("Commerce");
        s3.getCourse();
    }
}