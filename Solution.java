import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int value = 0;
        int result = 0;
        int loop = 0;
        Map<Character , Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
        }
        for (int url : map.values()){
            if(loop == 0 ){
                value = url;
            } else {
                if(value != url) {
                    if(Math.abs(value - url) >=2) {
                        if(url != 1) {
                            result= -1;
                        }
                    } else {
                        result++;
                    }
                }
            }
            loop++;
        }
        System.out.println("result=>   " +result);
        if(result == 0 || result == 1) {
            return "YES";
        } else {
            return "NO";
        }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
