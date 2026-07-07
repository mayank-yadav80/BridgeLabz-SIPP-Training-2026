package coursemanagement;

/**
 * ResearchCourse - Course with research-based evaluation
 * Evaluation based on research papers, thesis, and research output
 */
public class ResearchCourse extends CourseType {
    private String researchTopic;
    private int researchWeight; // Weight in final grade

    public ResearchCourse(String courseId, String courseName, int creditHours,
                         int totalMarks, String instructor, String researchTopic, int researchWeight) {
        super(courseId, courseName, creditHours, totalMarks, instructor);
        this.researchTopic = researchTopic;
        this.researchWeight = researchWeight;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public int getResearchWeight() {
        return researchWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }

    @Override
    public double calculateGrade(int obtainedMarks) {
        double percentage = (obtainedMarks * 100.0) / getTotalMarks();
        if (percentage >= 88) return 10.0;
        else if (percentage >= 78) return 9.0;
        else if (percentage >= 68) return 8.0;
        else if (percentage >= 58) return 7.0;
        else if (percentage >= 48) return 6.0;
        else return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Research Topic: %s, Weight: %d%%",
                researchTopic, researchWeight);
    }
}
