public class NotificationSystem {
    public static void main(String[] args) {
        String[] recipientNames = {"Asha", "Vikram", "Meera"};
        String[] messages = {"Welcome to our service.", "Your OTP is 4821.", "New offer available!"};

        Notification[] notifications = {
            new EmailNotification(recipientNames[0], messages[0]),
            new SMSNotification(recipientNames[1], messages[1]),
            new PushNotification(recipientNames[2], messages[2])
        };

        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}

class Notification {
    private String recipientName;
    private String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getMessage() {
        return message;
    }

    public void sendNotification() {
        System.out.println("Sending notification to " + recipientName + ": " + message);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email sent to " + getRecipientName() + ": " + getMessage());
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS sent to " + getRecipientName() + ": " + getMessage());
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Push notification for " + getRecipientName() + ": " + getMessage());
    }
}
