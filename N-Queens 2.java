class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count = 0
        cols = [False] * n
        diag1 = [False] * (2 * n) # row + col
        diag2 = [False] * (2 * n) # row - col
        
        def backtrack(row):
            if row == n:
                self.count += 1
                return
            
            for col in range(n):
              
                d1 = row + col
                d2 = row - col + n
                
              
                if cols[col] or diag1[d1] or diag2[d2]:
                    continue
                
              
                cols[col] = diag1[d1] = diag2[d2] = True
                backtrack(row + 1)
                
                cols[col] = diag1[d1] = diag2[d2] = False
        
        backtrack(0)
        return self.count
