package resumescreening;

/**
 * AI-Driven Resume Screening System - Demo
 * Demonstrates Generic Classes, Generic Methods, Bounded Type Parameters, and Wildcards
 */
public class AIResumeScreeningDemo {
    public static void main(String[] args) {
        System.out.println("\n" + "█".repeat(120));
        System.out.println("AI-DRIVEN RESUME SCREENING SYSTEM");
        System.out.println("█".repeat(120));

        // Create screening pipelines for different positions
        ResumeScreeningPipeline swePipeline = new ResumeScreeningPipeline("Software Engineer Position");
        ResumeScreeningPipeline dsPipeline = new ResumeScreeningPipeline("Data Scientist Position");
        ResumeScreeningPipeline pmPipeline = new ResumeScreeningPipeline("Product Manager Position");

        // Define job roles
        SoftwareEngineer seRole = new SoftwareEngineer("JR001", "Senior Software Engineer", 3, 800000, 2000000);
        DataScientist dsRole = new DataScientist("JR002", "Machine Learning Engineer", 2, 1000000, 2500000);
        ProductManager pmRole = new ProductManager("JR003", "Senior Product Manager", 4, 1200000, 3000000);

        System.out.println("\n--- Job Roles Details ---");
        System.out.println(seRole);
        System.out.println(dsRole);
        System.out.println(pmRole);

        // Create software engineer resumes
        System.out.println("\n\n--- Screening Software Engineer Resumes ---");
        
        Resume<SoftwareEngineer> resume1 = new Resume<>("R001", "Rajesh Kumar", "rajesh@email.com", 5, seRole);
        resume1.setSkills(new String[]{"Java", "Python", "Data Structures", "Algorithms", "OOP", "Git", "REST APIs"});
        resume1.setCertifications(new String[]{"Oracle Certified Associate Java Programmer"});
        swePipeline.submitResume(resume1);

        Resume<SoftwareEngineer> resume2 = new Resume<>("R002", "Priya Singh", "priya@email.com", 2, seRole);
        resume2.setSkills(new String[]{"Java", "C++"});
        dsPipeline.submitResume(resume2); // Will not qualify for SE (2 years < 3 required)

        Resume<SoftwareEngineer> resume3 = new Resume<>("R003", "Amit Patel", "amit@email.com", 6, seRole);
        resume3.setSkills(new String[]{"Java", "Python", "C++", "Problem Solving", "Data Structures", 
                                       "Algorithms", "OOP", "Database Design", "Git", "REST APIs"});
        resume3.setCertifications(new String[]{"AWS Solutions Architect"});
        swePipeline.submitResume(resume3);

        Resume<SoftwareEngineer> resume4 = new Resume<>("R004", "Neha Sharma", "neha@email.com", 4, seRole);
        resume4.setSkills(new String[]{"Java", "Python", "SQL", "MongoDB"});
        swePipeline.submitResume(resume4);

        // Create data scientist resumes
        System.out.println("\n\n--- Screening Data Scientist Resumes ---");
        
        Resume<DataScientist> resume5 = new Resume<>("R005", "Vikram Singh", "vikram@email.com", 3, dsRole);
        resume5.setSkills(new String[]{"Python", "R", "Machine Learning", "Statistics", "Data Analysis", 
                                       "SQL", "Pandas", "NumPy", "Scikit-learn", "TensorFlow"});
        resume5.setCertifications(new String[]{"Google Cloud Certified Data Engineer"});
        dsPipeline.submitResume(resume5);

        Resume<DataScientist> resume6 = new Resume<>("R006", "Deepika Gupta", "deepika@email.com", 2, dsRole);
        resume6.setSkills(new String[]{"Python", "Machine Learning", "Statistics"});
        dsPipeline.submitResume(resume6);

        Resume<DataScientist> resume7 = new Resume<>("R007", "Arjun Nair", "arjun@email.com", 4, dsRole);
        resume7.setSkills(new String[]{"Python", "R", "Machine Learning", "Statistics", "Data Analysis", 
                                       "SQL", "Pandas", "Data Visualization"});
        resume7.setCertifications(new String[]{"Andrew Ng's Machine Learning Specialization"});
        dsPipeline.submitResume(resume7);

        // Create product manager resumes
        System.out.println("\n\n--- Screening Product Manager Resumes ---");
        
        Resume<ProductManager> resume8 = new Resume<>("R008", "Meera Desai", "meera@email.com", 5, pmRole);
        resume8.setSkills(new String[]{"Product Management", "Market Research", "Analytics", "Communication", 
                                       "Leadership", "Agile", "Product Strategy", "User Research"});
        resume8.setCertifications(new String[]{"Pragmatic Marketing Certified", "Scrum Product Owner"});
        pmPipeline.submitResume(resume8);

        Resume<ProductManager> resume9 = new Resume<>("R009", "Sanjay Verma", "sanjay@email.com", 3, pmRole);
        resume9.setSkills(new String[]{"Analytics", "Communication", "Agile"});
        pmPipeline.submitResume(resume9);

        Resume<ProductManager> resume10 = new Resume<>("R010", "Anjali Khanna", "anjali@email.com", 6, pmRole);
        resume10.setSkills(new String[]{"Product Management", "Market Research", "Analytics", "Communication", 
                                        "Leadership", "Agile", "Product Strategy", "User Research", 
                                        "Stakeholder Management", "Business Acumen"});
        resume10.setCertifications(new String[]{"MBA - Product Management", "Certified Scrum Product Owner"});
        pmPipeline.submitResume(resume10);

        // Display all screened resumes
        System.out.println("\n\n--- ALL SCREENING RESULTS ---");
        swePipeline.displayScreenedResumes();
        dsPipeline.displayScreenedResumes();
        pmPipeline.displayScreenedResumes();

        // Display qualified candidates
        System.out.println("\n\n--- QUALIFIED CANDIDATES ---");
        swePipeline.displayQualifiedCandidates();
        dsPipeline.displayQualifiedCandidates();
        pmPipeline.displayQualifiedCandidates();

        // Display top candidates
        System.out.println("\n\n--- TOP CANDIDATES ---");
        swePipeline.displayTopCandidates(3);
        dsPipeline.displayTopCandidates(2);
        pmPipeline.displayTopCandidates(2);

        // Display pipeline statistics
        System.out.println("\n\n--- PIPELINE STATISTICS ---");
        swePipeline.displayStatistics();
        dsPipeline.displayStatistics();
        pmPipeline.displayStatistics();

        // Overall statistics
        System.out.println("\n" + "=".repeat(120));
        System.out.println("OVERALL HIRING STATISTICS");
        System.out.println("=".repeat(120));
        
        int totalResumes = swePipeline.getTotalResumes() + dsPipeline.getTotalResumes() + pmPipeline.getTotalResumes();
        int totalQualified = swePipeline.getQualifiedCount() + dsPipeline.getQualifiedCount() + pmPipeline.getQualifiedCount();
        
        System.out.println("Total Positions: 3");
        System.out.println("Total Resumes Screened: " + totalResumes);
        System.out.println("Total Qualified Candidates: " + totalQualified);
        System.out.println("Overall Qualification Rate: " + String.format("%.1f%%", 
            (double) totalQualified / totalResumes * 100));
        System.out.println("=".repeat(120));

        System.out.println("\n" + "█".repeat(120));
        System.out.println("Generics Benefits Demonstrated:");
        System.out.println("✓ Generic Classes: Resume<T extends JobRole>");
        System.out.println("✓ Generic Methods: submitResume() method");
        System.out.println("✓ Bounded Type Parameters: Ensures only valid job roles");
        System.out.println("✓ Upper Bounded Wildcards: List<? extends JobRole> for flexible collections");
        System.out.println("✓ Type Safety: No ClassCastException during screening");
        System.out.println("✓ Polymorphism: Different job roles handled uniformly");
        System.out.println("█".repeat(120) + "\n");
    }
}
