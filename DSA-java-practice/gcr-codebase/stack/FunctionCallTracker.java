import java.util.*;

public class FunctionCallTracker {

    private static class Frame {
        String functionName;
        Frame next;
        Frame(String name, Frame next) { this.functionName = name; this.next = next; }
    }

    private Frame top = null;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("No active call to return from");
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) { System.out.println("[ ]"); return; }
        System.out.print("[ ");
        Frame curr = top;
        while (curr != null) {
            System.out.print(curr.functionName);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println(" ] (top)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FunctionCallTracker stack = new FunctionCallTracker();

        while (true) {
            System.out.println("\n1. Push (call function)  2. Pop (return)  3. Peek  4. Display  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter function name: ");
                    stack.push(sc.nextLine());
                    System.out.println("Function pushed.");
                    break;
                case 2:
                    try { System.out.println("Returned from: " + stack.pop()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    try { System.out.println("Current function: " + stack.peek()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 4:
                    stack.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
