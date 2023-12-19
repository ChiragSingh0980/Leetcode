class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length < 1 || M[0].length < 1) return M;
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0, cnt = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, m - 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, n - 1); l++) {
                        temp += M[k][l];
                        cnt++;
                    }
                }
                res[i][j] = temp / cnt;
            }
        }
        return res;
    }
}
