package com.springboot.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController   //注意模板 需要这个
@RequestMapping("/lambda")

public class LambdaController extends BaseController {

//    public static void main(String[] args) {
//
//
//        String a = "11111";
//        System.out.println(analy(a));
//    }
//
//    public static String analy(String a) {
//        String[] b = a.split(",");
//        if(b.length==2){
//            String one = b[0].substring(1);
//            System.out.println(one);
//            String four = b[2].substring(0, b[2].length() - 1);
//            System.out.println(four);
//            String newstr = b[1];
//            String[] e = newstr.split("\\)");
//            if(e.length==2) {
//                String two = e[0];
//                System.out.println(two);
//                String relation = e[1].substring(0, 1);
//                System.out.println(relation);
//                String three = e[1].substring(2);
//                System.out.println(three);
//                try {
//                    Long.parseLong(one);
//                    Long.parseLong(two);
//                    Long.parseLong(three);
//                    Long.parseLong(four);
//                } catch (Exception c) {
//                    return "NaN";
//                }
//                if (Objects.equals("+", relation)) {
//                    Long resultOne = Long.parseLong(one) + Long.parseLong(three);
//                    Long resultTwo = Long.parseLong(two) + Long.parseLong(four);
//                    return "(" + resultOne.toString() + "," + resultTwo.toString() + ")";
//                } else if (Objects.equals("-", relation)) {
//                    Long resultOne = Long.parseLong(one) - Long.parseLong(three);
//                    Long resultTwo = Long.parseLong(two) - Long.parseLong(four);
//                    return "(" + resultOne.toString() + "," + resultTwo.toString() + ")";
//                } else if (Objects.equals("*", relation)) {
//                    Long resultOne = Long.parseLong(one) * Long.parseLong(three) - Long.parseLong(two) * Long.parseLong(four);
//                    Long resultTwo = Long.parseLong(one) * Long.parseLong(four) + Long.parseLong(two) * Long.parseLong(three);
//                    return "(" + resultOne.toString() + "," + resultTwo.toString() + ")";
//                } else if (Objects.equals("/", relation)) {
//                    Long resultOne = (Long.parseLong(one) * Long.parseLong(three) + Long.parseLong(two) * Long.parseLong(four)) / (Long.parseLong(three) ^ 2 + Long.parseLong(four) ^ 2);
//                    Long resultTwo = (Long.parseLong(two) * Long.parseLong(three) - Long.parseLong(one) * Long.parseLong(four)) / (Long.parseLong(three) ^ 2 + Long.parseLong(four) ^ 2);
//                    return "(" + resultOne.toString() + "," + resultTwo.toString() + ")";
//                }
//                return "NaN";
//            }
//            return "NaN";
//        }
//        return "NaN";
//    }
}
