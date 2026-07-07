package coursemanagement;

/**
 * Generic Course Management class
 * Demonstrates:
 * - Bounded type parameters: <T extends CourseType>
 * - Wildcard usage for flexible operations: List<? extends CourseType>
 */
public class Course<T extends CourseType> {
    private T courseDetails;
    private int enrolledStudents;
    private double courseRating;

    public Course(T courseDetails) {
        this.courseDetails = courseDetails;
        this.enrolledStudents = 0;
        this.courseRating = 0.0;
    }

    public T getCourseDetails() {
        return courseDetails;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void enrollMultipleStudents(int count) {
        enrolledStudents += count;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void updateCourseRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.courseRating = rating;
    }

    public double getCourseRating() {
        return courseRating;
    }

    /**
     * Calculate final grade for a student
     */
    public double calculateFinalGrade(int obtainedMarks) {
        return courseDetails.calculateGrade(obtainedMarks);
    }

    /**
     * Get course information
     */
    public String getCourseInfo() {
        return courseDetails.toString();
    }

    @Override
    public String toString() {
        return String.format("%s | Enrolled: %d students | Rating: %.1f/5.0",
                courseDetails, enrolledStudents, courseRating);
    }
}
