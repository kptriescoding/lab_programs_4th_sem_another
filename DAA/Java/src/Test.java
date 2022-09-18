import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;
class RegExpr7 {
    public static void main(String args[]) {
        Pattern pat = Pattern.compile("([A-Z]+)[a-z ]+([0-9]+)([a-z]+)");
        Matcher mat = pat.matcher("\"the price of PINEAPPLE 2020abc \"");
        System.out.println(mat.groupCount());
        while(mat.find()) {
            System.out.println(mat.group());
//            String str = "\"the price of PINEAPPLE 2020abc \"";
//            System.out.println(str.substring(29));
            System.out.println("Match: " + mat.group(2) + " " + mat.start(2) + " " + mat.end());
        }
    }
}