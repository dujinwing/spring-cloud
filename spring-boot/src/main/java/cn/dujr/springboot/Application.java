package cn.dujr.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String change = "";

        String[] array = s.split(" ");
        for (int k = 0; k < array.length; k++) {
            for (int i = array[k].length() - 1; i >= 0; i--) {
                change += array[k].charAt(i);
            }
            change += " ";
        }
        System.out.println(change.trim());

//        for (int i = 0; i < s.length()-1; i++) {
//            if (Character.isSpaceChar(s.charAt(i))) {
//                for ( end = i-1; end >= start; end--) {
//                    System.out.println(s.charAt(end));
////                    System.out.println(change);
//                    change = change + s.charAt(end);
//                }
//                change += " ";
//                start = i+1;
//            }
//        }


//        System.out.println(change);
    }

}

