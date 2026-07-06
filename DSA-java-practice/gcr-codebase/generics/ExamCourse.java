/**
 * ExamCourse - Course with exam-based evaluation
 * Evaluation based primarily on written/practical exams
 */
public class ExamCourse extends CourseType {
    private int midtermWeight; // 30% typically
    private int finalExamWeight; // 70% typically

    public ExamCourse(String courseId, String courseName, int creditHours, 
                     int totalMarks, String instructor, int midtermWeight, int finalExamWeight) {
        super(courseId, courseName, creditHours, totalMarks, instructor);
        this.midtermWeight = midtermWeight;
        this.finalExamWeight = finalExamWeight;
    }

    public int getMidtermWeight() {
        return midtermWeight;
    }

    public int getFinalExamWeight() {
        return finalExamWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }

    @Override
    public double calculateGrade(int obtainedMarks) {
        double percentage = (obtainedMarks * 100.0) / getTotalMarks();
        if (percentage >= 90) return 10.0;
        else if (percentage >= 80) return 9.0;
        else if (percentage >= 70) return 8.0;
        else if (percentage >= 60) return 7.0;
        else if (percentage >= 50) return 6.0;
        else return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Midterm: %d%%, Final Exam: %d%%",
                midtermWeight, finalExamWeight);
    }
}
