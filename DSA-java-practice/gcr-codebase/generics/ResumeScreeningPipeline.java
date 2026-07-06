import java.util.*;
import java.util.stream.*;

/**
 * Resume Screening Pipeline
 * Demonstrates:
 * - Upper bounded wildcards: List<? extends JobRole>
 * - Wildcard methods for handling multiple job roles
 * - Flexible screening process
 */
public class ResumeScreeningPipeline {
    private String pipelineName;
    private List<Resume<? extends JobRole>> screenedResumes; // Wildcard for any JobRole type
    private List<Resume<? extends JobRole>> qualifiedCandidates;

    public ResumeScreeningPipeline(String pipelineName) {
        this.pipelineName = pipelineName;
        this.screenedResumes = new ArrayList<>();
        this.qualifiedCandidates = new ArrayList<>();
    }

    /**
     * Submit a resume for screening using generic method
     */
    public <T extends JobRole> void submitResume(Resume<T> resume) {
        resume.performScreening();
        screenedResumes.add(resume);
        
        if (resume.isQualified()) {
            qualifiedCandidates.add(resume);
            System.out.println("✓ Candidate added to qualified pool");
        }
    }

    /**
     * Submit multiple resumes using wildcard
     */
    public void submitResumes(List<? extends Resume<?>> resumes) {
        for (Resume<?> resume : resumes) {
            screenedResumes.add((Resume<? extends JobRole>) resume);
        }
    }

    /**
     * Display all screened resumes
     */
    public void displayScreenedResumes() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("SCREENING PIPELINE: " + pipelineName + " | Total Resumes: " + screenedResumes.size());
        System.out.println("=".repeat(120));

        if (screenedResumes.isEmpty()) {
            System.out.println("No resumes submitted yet!");
            return;
        }

        for (Resume<? extends JobRole> resume : screenedResumes) {
            System.out.println("• " + resume);
        }
        System.out.println("=".repeat(120));
    }

    /**
     * Display only qualified candidates
     */
    public void displayQualifiedCandidates() {
        System.out.println("\n" + "─".repeat(120));
        System.out.println("QUALIFIED CANDIDATES | Total: " + qualifiedCandidates.size());
        System.out.println("─".repeat(120));

        if (qualifiedCandidates.isEmpty()) {
            System.out.println("No qualified candidates!");
            return;
        }

        for (Resume<? extends JobRole> resume : qualifiedCandidates) {
            System.out.println("• " + resume);
        }
        System.out.println("─".repeat(120));
    }

    /**
     * Get qualified resumes for a specific job role using wildcard
     */
    public <T extends JobRole> List<Resume<T>> getQualifiedResumesForRole(Class<T> roleType) {
        List<Resume<T>> filteredResumes = new ArrayList<>();
        
        for (Resume<? extends JobRole> resume : qualifiedCandidates) {
            if (roleType.isInstance(resume.getTargetJobRole())) {
                filteredResumes.add((Resume<T>) resume);
            }
        }

        return filteredResumes;
    }

    /**
     * Get top candidates by skill match score
     */
    public List<Resume<? extends JobRole>> getTopCandidates(int count) {
        return qualifiedCandidates.stream()
                .sorted((r1, r2) -> Double.compare(r2.getMatchingScore(), r1.getMatchingScore()))
                .limit(count)
                .collect(Collectors.toList());
    }

    /**
     * Get average skill match score
     */
    public double getAverageSkillMatchScore() {
        if (screenedResumes.isEmpty()) return 0;
        
        return screenedResumes.stream()
                .mapToDouble(Resume::getMatchingScore)
                .average()
                .orElse(0);
    }

    /**
     * Get qualification rate
     */
    public double getQualificationRate() {
        if (screenedResumes.isEmpty()) return 0;
        
        return (double) qualifiedCandidates.size() / screenedResumes.size() * 100;
    }

    /**
     * Display pipeline statistics
     */
    public void displayStatistics() {
        System.out.println("\n" + "─".repeat(120));
        System.out.println("PIPELINE STATISTICS: " + pipelineName);
        System.out.println("─".repeat(120));
        System.out.println("Total Resumes Screened: " + screenedResumes.size());
        System.out.println("Qualified Candidates: " + qualifiedCandidates.size());
        System.out.println("Qualification Rate: " + String.format("%.1f%%", getQualificationRate()));
        System.out.println("Average Skill Match: " + String.format("%.1f%%", getAverageSkillMatchScore()));
        System.out.println("─".repeat(120));
    }

    /**
     * Get top 5 candidates
     */
    public void displayTopCandidates(int count) {
        System.out.println("\n" + "─".repeat(120));
        System.out.println("TOP " + count + " CANDIDATES");
        System.out.println("─".repeat(120));

        List<Resume<? extends JobRole>> topCandidates = getTopCandidates(count);
        int rank = 1;
        for (Resume<? extends JobRole> resume : topCandidates) {
            System.out.println(rank + ". " + resume);
            rank++;
        }
        System.out.println("─".repeat(120));
    }

    public int getTotalResumes() {
        return screenedResumes.size();
    }

    public int getQualifiedCount() {
        return qualifiedCandidates.size();
    }
}
