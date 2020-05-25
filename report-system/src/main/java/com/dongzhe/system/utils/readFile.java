package com.dongzhe.system.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readFile {
	
	public String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }
	
	public static void main(String[] args){
		readFile rf=new readFile();
		String fileName="E:\\mapper\\EnviUnit.java";
		String str=rf.readToString(fileName);
		str=str.replaceAll("/\\*\\*","&start&").replaceAll("\\*/","&end&").replaceAll("\r|\n","");
		//System.out.println(str);
		String rex="&start&.*?;";
		Pattern pat=Pattern.compile(rex);
		Matcher mat=pat.matcher(str);
		while(mat.find()){
			String str1=mat.group();
			int in= str1.lastIndexOf("&");
			String connent= str1.substring(0,in);
			String[] aa= connent.split("&");
			String comment = aa[2];
			String rex1="private.*?;";
			Pattern pat1=Pattern.compile(rex1);
			Matcher mat1=pat1.matcher(str1);
			while(mat1.find()){
				String str2=mat1.group();
				String[] m1=str2.split(" ");
				//字段类型
				String mm2=m1[1];
				mm2=changeUnit(mm2);
				//字段名称
				String mm1=m1[2].split(";")[0];
				char[] srChar=mm1.toCharArray();
				for (char c : srChar) {
					if ((char)c>='A'&&(char)c<='Z') {
						mm1=mm1.replaceAll(String.valueOf(c),"_"+String.valueOf(c).toLowerCase());
					}
				}
				String sql = mm1+" "+mm2+" "+"COMMENT"+" '"+comment+"'"+",";
				System.out.println(sql);
			}
		}
		
	}
	
	public static String changeUnit(String str){
		String s="";
		if(str.equals("Integer")){
			s="int(11)";
		}
		if(str.equals("String")){
			s="varchar(255)";
		}
		if (str.equals("Date")){
			s="datetime";
		}
		return s;
	}

}
