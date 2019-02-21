package com.sptwin.xy.utils;

import java.io.*;

public class FileUtil {
    public static void writeJson(String json, String filePath){
        BufferedWriter bw = null;
        try{
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(json);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null != bw){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String readJson(String filePath){
        BufferedReader br = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String ch = null;
            while ((ch =  br.readLine()) != null){
                sb.append(ch);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null != br){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
