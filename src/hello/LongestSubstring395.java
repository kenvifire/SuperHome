package hello;

public class LongestSubstring395 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(k <=1) return n;
        if(n < k || n == 0) return 0;
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < n && j < n && i <= j){

        }

    }

    public static void main(String[] args) {
        int k =3;
        String s = "abdc";
        LongestSubstring395 find = new LongestSubstring395();
        int res = find.longestSubstring(s,k);
        System.out.println(res);

    }
}
