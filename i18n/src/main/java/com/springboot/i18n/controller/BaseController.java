package com.springboot.i18n.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseController() {
    }

    public static void main(String[] args) throws Exception{
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

    }

}
