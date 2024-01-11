class Solution {
    int n, m;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int i, String p, int j) {
        if (j >= m) return i >= n;

        char pc = p.charAt(j);
        if (j+1 < m && p.charAt(j + 1) == '*') {
            if (dfs(s, i, p, j+2)) return true; // when * reuslts in 0, move j
            if (i < n && (pc == '.' || s.charAt(i) == pc)) return dfs(s, i+1, p, j); // when * reuslts not as 0, move i
            return false;
        }
        if (i < n && (pc == '.' || s.charAt(i) == pc)) { // next pc not equal to '*'
            return dfs(s, i+1, p, j+1);
        }
        return false;
    }
}