class Solution {
    public String largestGoodInteger(String num) {
        String maxi = "000";
        int c = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            String s = num.substring(i, i + 3);
            if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
                if (s.compareTo(maxi) >= 0) {
                    maxi = s;
                }
                ++c;
            }
        }
        if (c == 0) {
            return "";
        }
        return maxi;
    }
}