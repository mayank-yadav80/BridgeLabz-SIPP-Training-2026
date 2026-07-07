package resumescreening;

import java.util.*;

/**
 * Generic Resume class with bounded type parameters
 * Demonstrates:
 * - Type Parameters: <T extends JobRole>
 * - Generic filtering and matching
 * - Resume screening with skill matching
 */
public class Resume<T extends JobRole> {
    private String resumeId;
    private String candidateName;
    private String email;
    private int yearsOfExperience;
    private String[] skills;
    private String[] certifications;
    private T targetJobRole;
    private double matchingScore;

    public Resume(String resumeId, String candidateName, String email, int yearsOfExperience, T targetJobRole) {
        this.resumeId = resumeId;
        this.candidateName = candidateName;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.targetJobRole = targetJobRole;
        this.skills = new String[0];
        this.certifications = new String[0];
        this.matchingScore = 0;
    }

    public String getResumeId() {
        return resumeId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getEmail() {
        return email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String[] getSkills() {
        return Arrays.copyOf(skills, skills.length);
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        String[] newSkills = new String[skills.length + 1];
        System.arraycopy(skills, 0, newSkills, 0, skills.length);
        newSkills[skills.length] = skill;
        this.skills = newSkills;
    }

    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }

    public String[] getCertifications() {
        return Arrays.copyOf(certifications, certifications.length);
    }

    public T getTargetJobRole() {
        return targetJobRole;
    }

    public double getMatchingScore() {
        return matchingScore;
    }

    /**
     * Perform resume screening
     */
    public void performScreening() {
        boolean isQualified = targetJobRole.validateCandidateProfile(yearsOfExperience, skills);
        matchingScore = targetJobRole.calculateSkillMatchPercentage(skills);

        System.out.println("\n--- Resume Screening Result ---");
        System.out.println("Candidate: " + candidateName);
        System.out.println("Target Role: " + targetJobRole.getJobTitle());
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Skill Match: " + String.format("%.1f%%", matchingScore));
        System.out.println("Status: " + (isQualified ? "✓ QUALIFIED" : "✗ NOT QUALIFIED"));
    }

    /**
     * Get screening result as boolean
     */
    public boolean isQualified() {
        return targetJobRole.validateCandidateProfile(yearsOfExperience, skills);
    }

    @Override
    public String toString() {
        matchingScore = targetJobRole.calculateSkillMatchPercentage(skills);
        return String.format(
            "Resume{ID='%s', Candidate='%s', Experience=%d years, Target='%s', SkillMatch=%.1f%%, Qualified=%s}",
            resumeId, candidateName, yearsOfExperience, targetJobRole.getJobTitle(), 
            matchingScore, isQualified() ? "Yes" : "No"
        );
    }
}
