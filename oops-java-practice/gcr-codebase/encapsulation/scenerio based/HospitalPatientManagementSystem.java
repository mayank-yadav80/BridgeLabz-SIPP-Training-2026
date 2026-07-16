public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P1001", "Sunita Rao", 45, 2200.0, 8500.0);
        OutPatient outPatient = new OutPatient("P1002", "Aditya Kumar", 30, 1200.0, 950.0);

        System.out.println("Patient Billing Report");
        System.out.println("----------------------");
        inPatient.displayPatientDetails();
        System.out.printf("Calculated Bill: %.2f%n%n", inPatient.calculateBill());

        outPatient.displayPatientDetails();
        System.out.printf("Calculated Bill: %.2f%n", outPatient.calculateBill());
    }
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public InPatient(String patientId, String name, int age, double roomCharges, double treatmentCharges) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    private double treatmentCharges;

    public OutPatient(String patientId, String name, int age, double consultationFee, double treatmentCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.treatmentCharges = treatmentCharges;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + treatmentCharges;
    }
}
