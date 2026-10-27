class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.empty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            min = Math.min(min, val);
        }
    }
    
    public void pop() {
        if (stack.empty()) {
            return;
        }

        long pop = stack.pop();
        if (pop < 0) {
            min -= pop;
        }
    }
    
    public int top() {
        long peek = stack.peek();
        if (peek > 0) {
            return (int) (peek + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
