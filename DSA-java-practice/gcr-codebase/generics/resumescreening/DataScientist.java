package resumescreening;

/**
 * DataScientist - Implementation of JobRole
 * Specialization for data science positions
 */
public class DataScientist extends JobRole {
    public DataScientist(String jobId, String jobTitle, int minExperienceYears, double minSalary, double maxSalary) {
        super(jobId, jobTitle, minExperienceYears, minSalary, maxSalary);
    }

    @Override
    public String[] getRequiredSkills() {
        return new String[]{
            "Python", "R", "Machine Learning", "Statistics", "Data Analysis",
            "SQL", "Pandas", "NumPy", "Scikit-learn", "Data Visualization", "TensorFlow"
        };
    }

    @Override
    public double calculateSkillMatchPercentage(String[] candidateSkills) {
        String[] requiredSkills = getRequiredSkills();
        int matchCount = 0;

        for (String candidateSkill : candidateSkills) {
            for (String requiredSkill : requiredSkills) {
                if (candidateSkill.equalsIgnoreCase(requiredSkill)) {
                    matchCount++;
                    break;
                }
            }
        }

        return (double) matchCount / requiredSkills.length * 100;
    }

    @Override
    public boolean validateCandidateProfile(int yearsOfExperience, String[] skills) {
        if (yearsOfExperience < getMinExperienceYears()) {
            return false;
        }

        // Check if candidate has at least 60% of required skills
        double skillMatchPercentage = calculateSkillMatchPercentage(skills);
        return skillMatchPercentage >= 60;
    }

    @Override
    public String toString() {
        return super.toString() + ", Required Skills: Python, R, ML, Statistics, SQL";
    }
}
