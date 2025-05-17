public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
