class Solution {
    List<Integer> a=new ArrayList<>();
    
    public String encode(List<String> strs) {
        String strs2="";
        for(String s:strs)
        {
            a.add(s.length());
            strs2+=s;
        }
        return strs2;
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int c=0;
        for(int i:a)
        {
            res.add(str.substring(c,i+c));
            c+=i;
        }
        return res;
    }
}
