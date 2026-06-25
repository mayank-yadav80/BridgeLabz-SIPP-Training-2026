public class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    public static void main(String[] args) {
        String[] patientNames = {"Aarav Singh", "Neha Joshi", "Rohan Mehta"};
        String[] patientIds = {"P12345", "INVALID", "P67890"};
        int[] heartRates = {72, 98, 85};
        double[] temperatures = {36.8, 38.5, 37.2};

        HealthMonitoringSystem system = new HealthMonitoringSystem();
        system.generateHealthReport(patientNames, patientIds, heartRates, temperatures);
    }

    private void generateHealthReport(String[] names, String[] ids, int[] heartRates, double[] temps) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Patient: " + names[i]);
            // HeartRateMonitor.super.displayHealthTips();
            boolean validId = TemperatureMonitor.isPatientIdValid(ids[i]);
            System.out.println("Patient ID valid: " + validId);
            if (validId) {
                System.out.println("Heart Rate: " + heartRates[i] + " bpm");
                System.out.println("Temperature: " + temps[i] + " °C");
                System.out.println("Overall Status: " + evaluateHealth(heartRates[i], temps[i]));
            } else {
                System.out.println("Overall Status: Invalid patient ID");
            }
            System.out.println();
        }
    }

    private String evaluateHealth(int heartRate, double temperature) {
        if (heartRate < 60 || heartRate > 100 || temperature >= 38.0) {
            return "Needs medical attention";
        }
        return "Stable";
    }
}

interface HeartRateMonitor {
    void monitorHeartRate(int heartRate);

     void displayHealthTips() ;
}

interface TemperatureMonitor {
    void monitorTemperature(double temperature);

    default void displayHealthTips() {
        System.out.println("TemperatureMonitor Tip: Stay hydrated and rest when feverish.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("P[0-9]{5}");
    }
}

class HealthMonitoringSystemImpl implements HeartRateMonitor, TemperatureMonitor {
    @Override
    public void monitorHeartRate(int heartRate) {
        System.out.println("Monitoring heart rate: " + heartRate + " bpm");
    }

    @Override
    public void monitorTemperature(double temperature) {
        System.out.println("Monitoring temperature: " + temperature + " °C");
    }

    @Override
    public void displayHealthTips() {
        System.out.println("Combined health tip: maintain fitness, hydrate, and check vitals regularly.");
    }

    public boolean isPatientIdValid(String patientId) {
        return TemperatureMonitor.isPatientIdValid(patientId);
    }
}
