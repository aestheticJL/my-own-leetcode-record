package temp.A;

public class Main {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (s.toString().equals("")) continue;
                else s.delete(s.length()-1,s.length() );
            }else {
                s.append(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (t.toString().equals("")) continue;
                else t.delete(t.length()-1,t.length() );
            }else {
                t.append(T.charAt(i));
            }
        }
        return s.toString().equals(t.toString());
    }
}
