package coursemanagement;

/**
 * AssignmentCourse - Course with assignment-based evaluation
 * Evaluation based on coursework, assignments, and projects
 */
public class AssignmentCourse extends CourseType {
    private int numAssignments;
    private int assignmentWeight; // Weight in final grade

    public AssignmentCourse(String courseId, String courseName, int creditHours,
                           int totalMarks, String instructor, int numAssignments, int assignmentWeight) {
        super(courseId, courseName, creditHours, totalMarks, instructor);
        this.numAssignments = numAssignments;
        this.assignmentWeight = assignmentWeight;
    }

    public int getNumAssignments() {
        return numAssignments;
    }

    public int getAssignmentWeight() {
        return assignmentWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }

    @Override
    public double calculateGrade(int obtainedMarks) {
        double percentage = (obtainedMarks * 100.0) / getTotalMarks();
        if (percentage >= 85) return 10.0;
        else if (percentage >= 75) return 9.0;
        else if (percentage >= 65) return 8.0;
        else if (percentage >= 55) return 7.0;
        else if (percentage >= 45) return 6.0;
        else return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Assignments: %d, Weight: %d%%",
                numAssignments, assignmentWeight);
    }
}
