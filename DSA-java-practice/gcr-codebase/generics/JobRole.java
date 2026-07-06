/**
 * Abstract base class for different job roles
 * Defines common properties and required skills for all job roles
 */
public abstract class JobRole {
    private String jobId;
    private String jobTitle;
    private int minExperienceYears;
    private double minSalary;
    private double maxSalary;

    public JobRole(String jobId, String jobTitle, int minExperienceYears, double minSalary, double maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minExperienceYears = minExperienceYears;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getMinExperienceYears() {
        return minExperienceYears;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public abstract String[] getRequiredSkills();

    public abstract double calculateSkillMatchPercentage(String[] candidateSkills);

    public abstract boolean validateCandidateProfile(int yearsOfExperience, String[] skills);

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Exp: %d+ years, Salary: ₹%.0f - ₹%.0f",
                jobId, jobTitle, minExperienceYears, minSalary, maxSalary);
    }
}
