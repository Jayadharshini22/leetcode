import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
            
                if (currentVal != '.') {
                    
                    String rowKey = "row" + i + currentVal;
                    String colKey = "col" + j + currentVal;
                    String boxKey = "box" + (i / 3) * 3 + (j / 3) + currentVal;

            
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
