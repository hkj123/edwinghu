package com.springboot.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import com.nimbusds.jose.*;
import com.nimbusds.jose.jwk.*;
import java.io.*;
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

    public static void main(String[] args) throws Exception{
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
        Map map = new HashMap();
        map.put("1","111111");
        map.put("2","222222");
        System.out.println( map.keySet());

    }

}
