import java.util.*;

public class MergeKSortedLogs {

    static class LogEntry {
        int timestamp;
        String message;

        LogEntry(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }

        @Override
        public String toString() {
            return "[" + timestamp + "] " + message;
        }
    }

    static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                           sources.get(b[0]).get(b[1]).timestamp);

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0], elemIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elemIdx));
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of servers: ");
        int k = sc.nextInt();

        List<List<LogEntry>> sources = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            System.out.print("Enter number of log entries for server " + (i + 1) + ": ");
            int count = sc.nextInt();
            List<LogEntry> entries = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                System.out.print("Timestamp and message: ");
                int ts = sc.nextInt();
                String msg = sc.next();
                entries.add(new LogEntry(ts, msg));
            }
            sources.add(entries);
        }

        List<LogEntry> merged = mergeKSortedLogs(sources);
        System.out.println("Merged timeline:");
        for (LogEntry entry : merged) {
            System.out.println("  " + entry);
        }
        sc.close();
    }
}
