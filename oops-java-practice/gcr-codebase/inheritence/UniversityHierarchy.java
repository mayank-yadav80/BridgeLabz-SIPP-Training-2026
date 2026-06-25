public class UniversityHierarchy {
    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("Alice Kumar", 3.9, "Building AI Models");

        System.out.println(gradStudent);
        System.out.println("Is GradStudent a Student? " + (gradStudent instanceof Student));
        System.out.println("Is GradStudent a Person? " + (gradStudent instanceof Person));

        Student studentReference = gradStudent;
        System.out.println("Student reference: " + studentReference);

        Person personReference = gradStudent;
        System.out.println("Person reference: " + personReference);
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

class Student extends Person {
    private final String studentId;
    private double gpa;

    public Student(String name, String studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, double gpa, String thesisTitle) {
        super(name, "G-" + name.toUpperCase().replaceAll("\\s+", ""), gpa);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return "GradStudent{" +
                "name='" + getName() + '\'' +
                ", studentId='" + getStudentId() + '\'' +
                ", gpa=" + getGpa() +
                ", thesisTitle='" + thesisTitle + '\'' +
                '}';
    }
}
