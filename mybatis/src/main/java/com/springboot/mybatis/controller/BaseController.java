package com.springboot.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import com.nimbusds.jose.*;
import com.nimbusds.jose.jwk.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseController() {
    }

    public static void main(String[] args) throws Exception {
//        String clientSecretString = "adf81d34-ffac-47d4-9be0-fa4d2e7316b3";
//        SecretKey clientSecret = new SecretKeySpec(clientSecretString.getBytes("UTF-8"), "HmacSHA256");
//// Convert to JWK format
//        JWK jwk = new OctetSequenceKey.Builder(clientSecret)
//                .keyID(clientSecretString) // give the key some ID (optional)
//                .algorithm(JWSAlgorithm.HS256) // indicate the intended key alg (optional)
//                .build();
//        System.out.println(jwk);
//        Pattern subjectDNPattern = Pattern.compile("CN=*.service.consul");
////        X509Certificate[] certs = ["CN=*.service.consul", "CN=QLOUDFIN.COM"];
////        Optional<String> matchedCertificate = Arrays.stream(certs)
////                .map(certificate -> certificate.getSubjectDN().getName())
////                .filter(subjectdn -> subjectDNPattern.matcher(subjectdn).matches())
////                .findFirst();
//        Boolean a = subjectDNPattern.matcher("CN=*.service.consul").matches();
//        if(subjectDNPattern.matcher("CN=a.service.consul").matches()){
//            System.out.println("success");
//        }
//        if (!matchedCertificate.isPresent()) {
//            // We do quite expensive operation here, so better check the logging level beforehand.
//            if (logger.isDebugEnabled()) {
//                logger.debug("[X509ClientCertificateAuthenticator:authenticate] Couldn't match any certificate for pattern " + subjectDNPattern);
//                logger.debug("[X509ClientCertificateAuthenticator:authenticate] Available SubjectDNs: " +
//                        Arrays.stream(certs)
//                                .map(cert -> cert.getSubjectDN().getName())
//                                .collect(Collectors.toList()));
//            }
//        Date date = new Date();
//        ZonedDateTime parsedDate = ZonedDateTime.parse(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME), DateTimeFormatter.RFC_1123_DATE_TIME);
////        ZonedDateTime parsedDate = ZonedDateTime.parse("Tue, 19 Nov 2019 09:48:43 GMT",DateTimeFormatter.RFC_1123_DATE_TIME);
//        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println(parsedDate);
//        System.out.println(now);
//        String path = "D:/edwinghu/mybatis/src/main/resources/swagger";
//        File file1 = new File(path);
//        if (file1 != null) {
//            File[] fileList = file1.listFiles();
//            for (int i = 0; i < fileList.length; i++) {
//                if (fileList[i].isFile()) {
//                    String fileName = fileList[i].getName();
//                    File file = new File(path+"/"+fileList[i].getName());
//                    BufferedReader reader = null;
//                    StringBuffer sbf = new StringBuffer();
//                    try {
//                        reader = new BufferedReader(new FileReader(file));
//                        String tempStr;
//                        while ((tempStr = reader.readLine()) != null) {
//                            sbf.append(tempStr);
//                        }
//                        reader.close();
//                        System.out.println("文件：" + sbf.toString());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } finally {
//                        if (reader != null) {
//                            try {
//                                reader.close();
//                            } catch (IOException e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    }
//                    System.out.println("文件：" + fileName);
//                }
//            }
//        }
//          List<Integer> list = Arrays.asList(1,3,7,4,2);
//          Collections.sort(list,Comparator.reverseOrder());
//         for(Integer a:list) {
//             System.out.println(a);
//         }
//        List<String> stringList = Arrays.asList("a","c","b");
////        Collections.sort(stringList,Comparator.naturalOrder());
//        Collections.sort(stringList,(a,b)->b.compareTo(a));
//        for(String b:stringList) {
//            System.out.println(b);
//        }
//
//        int[] d = {1,3,2,4,1};
//        Arrays.sort(d,0,3);
//        for(int e:d) {
//            System.out.println(e);
//        }

        int[][] twoWei = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int x = twoWei[0].length;
        int y = twoWei.length;
//        System.out.println(x);
//        System.out.println(y);

        String s = "Test string";
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); //"ll"

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("胡");
        stringBuffer.append("开");
        stringBuffer.append("甲");
        System.out.println(stringBuffer.toString());

        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        BigDecimal d1 = new BigDecimal("123.456789");
        BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
        BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567

        List<String> list = Arrays.asList("A", "B", "C");
        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));

        // 获取当前时间:
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());


        // 获取当前时间:
        Calendar c = Calendar.getInstance();
        int y1 = c.get(Calendar.YEAR);
        int m = 1 + c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y1 + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

    }
}
