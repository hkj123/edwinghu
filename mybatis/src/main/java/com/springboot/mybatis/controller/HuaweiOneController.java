package com.springboot.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Scanner;

@RestController   //注意模板 需要这个
@RequestMapping("/lambda")

public class HuaweiOneController extends BaseController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = null;
        if(sc.hasNext()){
            in=sc.nextLine();
        }
        if (Objects.isNull(in)){
            System.out.println("error");
        }
        String[] b = in.split("@");
        String result = "";
        if(b.length==1){
            System.out.println(b[0].substring(0,b[0].length()));
        }else if(b.length==2){
            String[] all = b[0].split(",");
            String[] reduce = b[1].split(",");
            if(all.length==0||reduce.length==0){
                System.out.println("error");
            }else{
                for(String e:all){
                    int count = 0;
                    for(String f:reduce){
                        String[] c=e.split(":");
                        String[] d=f.split(":");
                        if(c.length!=2||d.length!=2){
                            System.out.println("error");
                        }
                        Integer c1=0;
                        Integer d1=0;
                        try{
                            c1 = Integer.parseInt(c[1]);
                            d1 = Integer.parseInt(d[1]);
                        }catch (Exception h){
                            System.out.println("error");
                        }
                        if(Objects.equals(c[0],d[0])){
                            Integer num = c1-d1;
                            count++;
                            result = result+ c[0]+":"+num.toString()+",";
                        }
                    }
                    if(count==0){
                        result = result+e;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
