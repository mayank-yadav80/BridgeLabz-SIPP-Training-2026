import java.util.*;

public class UndoBufferStack {

    private String[] data;
    private int top;
    private int maxSize;

    public UndoBufferStack(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
        maxSize = maxDepth;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) return false;
        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("Nothing to undo");
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public void display() {
        if (isEmpty()) { System.out.println("[ ]"); return; }
        System.out.print("[ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println(" ] (top)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter max undo depth: ");
        int maxDepth = sc.nextInt();
        sc.nextLine();

        UndoBufferStack stack = new UndoBufferStack(maxDepth);
        while (true) {
            System.out.println("\n1. Push (record edit)  2. Pop (undo)  3. Peek  4. Display  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter edit description: ");
                    String edit = sc.nextLine();
                    if (stack.push(edit)) System.out.println("Edit recorded.");
                    else System.out.println("Undo buffer full! Cannot record more edits.");
                    break;
                case 2:
                    try { System.out.println("Undid: " + stack.pop()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    try { System.out.println("Most recent edit: " + stack.peek()); }
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
