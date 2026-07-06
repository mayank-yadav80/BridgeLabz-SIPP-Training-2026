/**
 * ProductManager - Implementation of JobRole
 * Specialization for product management positions
 */
public class ProductManager extends JobRole {
    public ProductManager(String jobId, String jobTitle, int minExperienceYears, double minSalary, double maxSalary) {
        super(jobId, jobTitle, minExperienceYears, minSalary, maxSalary);
    }

    @Override
    public String[] getRequiredSkills() {
        return new String[]{
            "Product Management", "Market Research", "Analytics", "Communication",
            "Leadership", "Agile", "Product Strategy", "User Research", "Roadmapping",
            "Stakeholder Management", "Business Acumen"
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

        // Check if candidate has at least 55% of required skills
        double skillMatchPercentage = calculateSkillMatchPercentage(skills);
        return skillMatchPercentage >= 55;
    }

    @Override
    public String toString() {
        return super.toString() + ", Required Skills: Product Management, Analytics, Leadership";
    }
}
