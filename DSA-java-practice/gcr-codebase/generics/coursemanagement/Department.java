package coursemanagement;

import java.util.*;

/**
 * Department class that manages courses of different types
 * Demonstrates:
 * - Upper bounded wildcards: List<? extends CourseType>
 * - Flexibility in handling multiple course types
 */
public class Department {
    private String departmentName;
    private List<Course<? extends CourseType>> courses; // Wildcard for any CourseType

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    /**
     * Add a course of any type (uses wildcard)
     */
    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
        System.out.println("✓ Added course: " + course.getCourseDetails().getCourseName());
    }

    /**
     * Add multiple courses using wildcard
     */
    public void addCourses(List<? extends Course<?>> courseList) {
        for (Course<?> course : courseList) {
            courses.add((Course<? extends CourseType>) course);
        }
    }

    /**
     * Display all courses in department (using wildcard)
     */
    public void displayAllCourses() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("DEPARTMENT: " + departmentName + " | Total Courses: " + courses.size());
        System.out.println("=".repeat(120));

        if (courses.isEmpty()) {
            System.out.println("No courses found!");
            return;
        }

        for (Course<? extends CourseType> course : courses) {
            System.out.println("• " + course);
        }
        System.out.println("=".repeat(120));
    }

    /**
     * Get courses by evaluation type using wildcard
     */
    public void displayCoursesByType(String evaluationType) {
        System.out.println("\n" + "─".repeat(120));
        System.out.println("Courses with Evaluation Type: " + evaluationType);
        System.out.println("─".repeat(120));

        boolean found = false;
        for (Course<? extends CourseType> course : courses) {
            if (course.getCourseDetails().getEvaluationType().equals(evaluationType)) {
                System.out.println("• " + course);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses found with evaluation type: " + evaluationType);
        }
    }

    /**
     * Get total enrolled students across all courses
     */
    public int getTotalEnrolledStudents() {
        return courses.stream()
                .mapToInt(Course::getEnrolledStudents)
                .sum();
    }

    /**
     * Get average course rating
     */
    public double getAverageCourseRating() {
        if (courses.isEmpty()) return 0.0;
        return courses.stream()
                .mapToDouble(Course::getCourseRating)
                .average()
                .orElse(0.0);
    }

    /**
     * Get department statistics
     */
    public void displayStatistics() {
        System.out.println("\n" + "─".repeat(120));
        System.out.println("Department Statistics: " + departmentName);
        System.out.println("─".repeat(120));
        System.out.println("Total Courses: " + courses.size());
        System.out.println("Total Enrolled Students: " + getTotalEnrolledStudents());
        System.out.println("Average Course Rating: " + String.format("%.2f/5.0", getAverageCourseRating()));
        System.out.println("─".repeat(120));
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getCourseCount() {
        return courses.size();
    }
}
