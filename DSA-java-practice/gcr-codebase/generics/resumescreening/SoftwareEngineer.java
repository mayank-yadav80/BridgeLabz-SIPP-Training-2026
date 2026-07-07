package resumescreening;

/**
 * SoftwareEngineer - Implementation of JobRole
 * Specialization for software engineering positions
 */
public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String jobId, String jobTitle, int minExperienceYears, double minSalary, double maxSalary) {
        super(jobId, jobTitle, minExperienceYears, minSalary, maxSalary);
    }

    @Override
    public String[] getRequiredSkills() {
        return new String[]{
            "Java", "Python", "C++", "Problem Solving", "Data Structures", 
            "Algorithms", "OOP", "Database Design", "Git", "REST APIs"
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

        // Check if candidate has at least 50% of required skills
        double skillMatchPercentage = calculateSkillMatchPercentage(skills);
        return skillMatchPercentage >= 50;
    }

    @Override
    public String toString() {
        return super.toString() + ", Required Skills: Java, Python, C++, DSA, Algorithms";
    }
}
