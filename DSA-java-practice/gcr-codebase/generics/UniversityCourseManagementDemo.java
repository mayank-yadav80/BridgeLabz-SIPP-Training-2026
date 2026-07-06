/**
 * Multi-Level University Course Management System - Demo
 * Demonstrates Generic Classes, Wildcards, and Bounded Type Parameters
 */
public class UniversityCourseManagementDemo {
    public static void main(String[] args) {
        System.out.println("\n" + "█".repeat(120));
        System.out.println("MULTI-LEVEL UNIVERSITY COURSE MANAGEMENT SYSTEM");
        System.out.println("█".repeat(120));

        // Create departments
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");
        Department physicsDepartment = new Department("Physics");

        // Create Exam-Based Courses
        System.out.println("\n--- Creating Exam-Based Courses ---");
        ExamCourse javaCore = new ExamCourse("CS101", "Java Core", 4, 100, "Dr. Raj Kumar", 30, 70);
        Course<ExamCourse> javaCoreCourse = new Course<>(javaCore);
        javaCoreCourse.enrollMultipleStudents(120);
        javaCoreCourse.updateCourseRating(4.8);
        
        ExamCourse dbms = new ExamCourse("CS102", "Database Management", 3, 100, "Dr. Priya Singh", 30, 70);
        Course<ExamCourse> dbmsCourse = new Course<>(dbms);
        dbmsCourse.enrollMultipleStudents(95);
        dbmsCourse.updateCourseRating(4.6);

        ExamCourse calculus = new ExamCourse("MATH101", "Calculus I", 4, 100, "Prof. John Smith", 30, 70);
        Course<ExamCourse> calculusCourse = new Course<>(calculus);
        calculusCourse.enrollMultipleStudents(150);
        calculusCourse.updateCourseRating(4.5);

        // Create Assignment-Based Courses
        System.out.println("\n--- Creating Assignment-Based Courses ---");
        AssignmentCourse webDev = new AssignmentCourse("CS201", "Web Development", 3, 100, "Dr. Amit Patel", 8, 100);
        Course<AssignmentCourse> webDevCourse = new Course<>(webDev);
        webDevCourse.enrollMultipleStudents(85);
        webDevCourse.updateCourseRating(4.7);

        AssignmentCourse linearAlgebra = new AssignmentCourse("MATH201", "Linear Algebra", 3, 100, "Prof. Jane Doe", 10, 100);
        Course<AssignmentCourse> linearAlgebraCourse = new Course<>(linearAlgebra);
        linearAlgebraCourse.enrollMultipleStudents(110);
        linearAlgebraCourse.updateCourseRating(4.4);

        // Create Research-Based Courses
        System.out.println("\n--- Creating Research-Based Courses ---");
        ResearchCourse aiResearch = new ResearchCourse("CS301", "AI Research", 4, 100, "Dr. Vikram Singh", "Machine Learning Applications", 100);
        Course<ResearchCourse> aiResearchCourse = new Course<>(aiResearch);
        aiResearchCourse.enrollMultipleStudents(40);
        aiResearchCourse.updateCourseRating(4.9);

        ResearchCourse physics = new ResearchCourse("PHY101", "Quantum Physics", 4, 100, "Prof. Albert White", "Quantum Mechanics", 100);
        Course<ResearchCourse> physicsCourse = new Course<>(physics);
        physicsCourse.enrollMultipleStudents(35);
        physicsCourse.updateCourseRating(4.7);

        // Add courses to departments using wildcard support
        System.out.println("\n--- Adding Courses to Departments ---");
        csDepartment.addCourse(javaCoreCourse);
        csDepartment.addCourse(dbmsCourse);
        csDepartment.addCourse(webDevCourse);
        csDepartment.addCourse(aiResearchCourse);

        mathDepartment.addCourse(calculusCourse);
        mathDepartment.addCourse(linearAlgebraCourse);

        physicsDepartment.addCourse(physicsCourse);

        // Display all courses
        csDepartment.displayAllCourses();
        mathDepartment.displayAllCourses();
        physicsDepartment.displayAllCourses();

        // Display courses by evaluation type
        System.out.println("\n--- Courses by Evaluation Type ---");
        csDepartment.displayCoursesByType("Exam-Based");
        csDepartment.displayCoursesByType("Assignment-Based");
        csDepartment.displayCoursesByType("Research-Based");

        // Display course grades
        System.out.println("\n--- Student Grade Calculations ---");
        System.out.println(String.format("Java Core - Student score 85/100: Grade %.1f", javaCoreCourse.calculateFinalGrade(85)));
        System.out.println(String.format("Web Development - Student score 92/100: Grade %.1f", webDevCourse.calculateFinalGrade(92)));
        System.out.println(String.format("AI Research - Student score 88/100: Grade %.1f", aiResearchCourse.calculateFinalGrade(88)));

        // Display department statistics
        csDepartment.displayStatistics();
        mathDepartment.displayStatistics();
        physicsDepartment.displayStatistics();

        // Overall statistics
        System.out.println("\n" + "=".repeat(120));
        System.out.println("OVERALL UNIVERSITY STATISTICS");
        System.out.println("=".repeat(120));
        
        int totalStudents = csDepartment.getTotalEnrolledStudents() + 
                           mathDepartment.getTotalEnrolledStudents() + 
                           physicsDepartment.getTotalEnrolledStudents();
        
        int totalCourses = csDepartment.getCourseCount() + 
                          mathDepartment.getCourseCount() + 
                          physicsDepartment.getCourseCount();
        
        double avgRating = (csDepartment.getAverageCourseRating() + 
                           mathDepartment.getAverageCourseRating() + 
                           physicsDepartment.getAverageCourseRating()) / 3;
        
        System.out.println("Total Departments: 3");
        System.out.println("Total Courses: " + totalCourses);
        System.out.println("Total Enrolled Students: " + totalStudents);
        System.out.println("Average University Course Rating: " + String.format("%.2f/5.0", avgRating));
        System.out.println("=".repeat(120));

        System.out.println("\n" + "█".repeat(120));
        System.out.println("Generics Benefits Demonstrated:");
        System.out.println("✓ Bounded Type Parameters: <T extends CourseType>");
        System.out.println("✓ Upper Bounded Wildcards: List<? extends CourseType>");
        System.out.println("✓ Type Safety: No ClassCastException");
        System.out.println("✓ Flexible API: Handles multiple course types seamlessly");
        System.out.println("█".repeat(120) + "\n");
    }
}
