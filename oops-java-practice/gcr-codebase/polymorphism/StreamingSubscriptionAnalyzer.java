public class StreamingSubscriptionAnalyzer {
    public static void main(String[] args) {
        Subscription[] subscriptions = {
            new BasicPlan("Nina", "SUB1001"),
            new PremiumPlan("Amit", "SUB1002"),
            new FamilyPlan("Riya", "SUB1003")
        };

        System.out.println("Total monthly revenue: " + calculateTotalRevenue(subscriptions));
        displaySubscribersStartingWith(subscriptions, 'A');
        Subscription expensive = findMostExpensiveSubscription(subscriptions);
        System.out.println("Most expensive subscription: " + expensive.getSubscriberName());
        Subscription searchResult = searchBySubscriptionId(subscriptions, "SUB1002");
        System.out.println("Search SUB1002: " + (searchResult != null ? searchResult.getSubscriberName() : "Not found"));
    }

    public static double calculateTotalRevenue(Subscription[] subscriptions) {
        double total = 0;
        for (Subscription subscription : subscriptions) {
            total += subscription.calculateMonthlyCharge();
        }
        return total;
    }

    public static Subscription searchBySubscriptionId(Subscription[] subscriptions, String id) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriptionId().equals(id)) {
                return subscription;
            }
        }
        return null;
    }

    public static void displaySubscribersStartingWith(Subscription[] subscriptions, char letter) {
        System.out.println("Subscribers starting with " + letter + ":");
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriberName().charAt(0) == letter) {
                System.out.println("- " + subscription.getSubscriberName());
            }
        }
    }

    public static Subscription findMostExpensiveSubscription(Subscription[] subscriptions) {
        Subscription expensive = subscriptions[0];
        for (Subscription subscription : subscriptions) {
            if (subscription.calculateMonthlyCharge() > expensive.calculateMonthlyCharge()) {
                expensive = subscription;
            }
        }
        return expensive;
    }
}

abstract class Subscription {
    private String subscriberName;
    private String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 199.0;
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 399.0;
    }
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 599.0;
    }
}
