import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base Case: If we have picked k numbers, add a copy of the list to results
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: i <= n - (k - current.size()) + 1
        // This ensures there are enough numbers left in the range [i, n] to reach size k
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            // 1. Choose the number
            current.add(i);
            
            // 2. Explore further (move to the next number)
            backtrack(i + 1, n, k, current, result);
            
            // 3. Backtrack (remove the number to try the next one in the loop)
            current.remove(current.size() - 1);
        }
    }
}
