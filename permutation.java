class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(curr_path, remaining):
            if not remaining:
                res.append(list(curr_path))
                return
            for i in range(len(remaining)):
                curr_path.append(remaining[i])
                backtrack(curr_path, remaining[:i] + remaining[i+1:])

                curr_path.pop()
        
        backtrack([], nums)
        return res
