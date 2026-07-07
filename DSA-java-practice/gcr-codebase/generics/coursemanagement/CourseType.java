package coursemanagement;

/**
 * Abstract base class for different course evaluation types
 * Defines common properties and behaviors for all course types
 */
public abstract class CourseType {
    private String courseId;
    private String courseName;
    private int creditHours;
    private int totalMarks;
    private String instructor;

    public CourseType(String courseId, String courseName, int creditHours, int totalMarks, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.totalMarks = totalMarks;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract String getEvaluationType();

    public abstract double calculateGrade(int obtainedMarks);

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Credits: %d, Total Marks: %d, Instructor: %s, Type: %s",
                courseId, courseName, creditHours, totalMarks, instructor, getEvaluationType());
    }
}
