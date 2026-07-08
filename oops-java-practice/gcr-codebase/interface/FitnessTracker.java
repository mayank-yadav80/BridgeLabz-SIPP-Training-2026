public class FitnessTracker {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice("FitPro X1");
        device.logActivity("Running 30 minutes");
        device.logActivity("Cycling 20 km");
        device.sendAlert("Low battery");
        System.out.println(device.generateReport());
        device.resetData();
        System.out.println("After reset: " + device.generateReport());
    }
}

interface Trackable {
    void logActivity(String activity);

    default void resetData() {
        System.out.println("Activity data reset to defaults.");
    }
}

interface Reportable {
    String generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String deviceModel;
    private StringBuilder activityLog = new StringBuilder();

    public FitnessDevice(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public void logActivity(String activity) {
        activityLog.append(activity).append("\n");
        System.out.println("Logged: " + activity);
    }

    @Override
    public String generateReport() {
        return "Fitness Device: " + deviceModel + "\nActivities:\n" + (activityLog.length() == 0 ? "No activities logged." : activityLog.toString());
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
    }
}
