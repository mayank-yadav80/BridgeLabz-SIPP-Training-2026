public class ContentModerationPlatform {
    public static void main(String[] args) {
        String[] posts = {
            "Buy cheap watches now",
            "I hate this product",
            "This is a great new feature",
            "Click here to win a prize",
            "This is offensive and rude"
        };

        ContentModerator moderator = new ContentModerator();
        for (String post : posts) {
            moderator.displayModerationPolicy();
            boolean spam = moderator.isSpam(post);
            boolean offensive = moderator.isOffensive(post);
            String status = spam ? "Spam post" : offensive ? "Offensive post" : "Valid post";
            System.out.println(post + " => " + status + "\n");
        }
    }
}

interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("TextModeration policy: filter abusive and offensive language.");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("SpamDetection policy: detect promotional and phishing content.");
    }

    static boolean containsRestrictedWords(String post) {
        if (post == null) {
            return false;
        }
        String lower = post.toLowerCase();
        return lower.contains("click here") || lower.contains("buy cheap") || lower.contains("win a prize") || lower.contains("free prize");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public boolean isOffensive(String post) {
        if (post == null) {
            return false;
        }
        String lower = post.toLowerCase();
        return lower.contains("hate") || lower.contains("offensive") || lower.contains("rude");
    }

    @Override
    public boolean isSpam(String post) {
        return SpamDetection.containsRestrictedWords(post);
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("Combined moderation policy: protect users from spam and offensive content.");
    }
}
