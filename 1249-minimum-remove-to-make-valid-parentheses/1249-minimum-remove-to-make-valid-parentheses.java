class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        // First pass
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
                result.append(ch);
            }
            else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    result.append(ch);
                }
            }
            else {
                result.append(ch);
            }
        }

        // Remove extra '(' from right to left
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);

            if (ch == '(' && balance > 0) {
                balance--;
            }
            else {
                answer.append(ch);
            }
        }

        return answer.reverse().toString();
    }
}