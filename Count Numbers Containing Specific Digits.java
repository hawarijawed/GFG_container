/*
You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9. 
Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.
*/
class Solution {
    public int countValid(int n, int[] arr) {
        // code here
                // Step 1: Mark digits from arr in a set
        Set<Integer> requiredDigits = new HashSet<>();
        for (int digit : arr) {
            requiredDigits.add(digit);
        }

        // Step 2: Build allowed digits (i.e., 0–9 excluding arr[])
        Set<Integer> remainingDigits = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            if (!requiredDigits.contains(i)) {
                remainingDigits.add(i);
            }
        }

        // If remainingDigits is empty, no "bad" number can be formed
        if (remainingDigits.isEmpty()) {
            return (int) Math.pow(10, n - 1) * 9;
        }

        // Step 3: Count bad numbers using only remaining digits
        int badFirstDigitChoices = 0;
        for (int d : remainingDigits) {
            if (d != 0) {
                badFirstDigitChoices++;
            }
        }

        int r = remainingDigits.size();
        int total = (int) Math.pow(10, n - 1) * 9;
        int bad = 0;
        if (badFirstDigitChoices > 0) {
            bad = (int) (badFirstDigitChoices * Math.pow(r, n - 1));
        }

        return total - bad;

    }
}
