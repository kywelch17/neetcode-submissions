class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();
        int result = 0;

        for (String op : operations) {
            System.out.println(op);
            switch (op) {
                case "+":
                    int top1 = record.pop();
                    int top2 = record.peek();
                    record.push(top1);
                    record.push(top1 + top2);
                    result += record.peek();
                    break;
                case "D":
                    int top = record.peek();
                    record.push(top * 2);
                    result += record.peek();
                    break;
                case "C":
                    result -= record.pop();
                    break;
                default:
                    record.push(Integer.parseInt(op));
                    result += record.peek();
            }
        }

        return result;
    }
}