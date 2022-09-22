class Solution {
    public boolean isValid(String s) {
        char[] ch = new char[s.length()];
        int c = 0;
        for (char a : s.toCharArray()) {
            switch(a) {
                case ']': 
                    if (c <= 0 || ch[--c] != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (c <= 0 || ch[--c] != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (c <= 0 || ch[--c] != '{') {
                        return false;
                    }
                    break;
                default:
                    ch[c++] = a;
                    break;
            }
        }
        if (c != 0) {
            return false;
        }
        return true;
    }
}
