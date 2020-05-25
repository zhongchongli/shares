package com.dongzhe.web.controller.tool;

//import com.dongzhe.common.json.JSONObject;

import com.alibaba.fastjson.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author Lenovo
 * @date 2020/5/15 11:04
 */

public class Formula {
    private int leftBracket = 0;//左括号个数
    private int rightBracket = 0;//右括号个数
    private int startL = 0;//左括号的位置
    private int startR = 0;//右括号的位置
    private double answer = 0;
    private String leftNumber = "0";
    private String rightNumber = "0";
    public String Msg = "";
    private String formula="";
    private int[] sym = new int[4];
    private Vector<String> list = new Vector<String>();//用来存放从字符串解析出来的字符
    static Vector<Integer> paras = new Vector<Integer>();//用来存放变量参数


    /*
     *构造方法，以要算的公式为参数
     */
    public Formula(String calRule){
        this.setFormula(calRule);
    }

    /*
     * 获得左括号数
     */
    private int getLeftBracket(String calRule) {
        leftBracket = 0;
        startL = calRule.indexOf("(");
        if (startL != -1) {
            calRule = calRule.substring(startL + 1, calRule.length());
        }
        while (startL != -1) {
            leftBracket++;
            startL = calRule.indexOf("(");
            calRule = calRule.substring(startL + 1, calRule.length());
        }
        return leftBracket;
    }


    /*
     * 设置格式
     */
    public void setFormula(String calRule){
        formula=replaceSubtration(calRule.trim());
        formula="("+formula+")";
    }

    /*
     * 为了使公式中支持负数，使用“`”表示减号，使用“-”表示负号，把所有减号换成“‘”
     */
    private String replaceSubtration(String vstr){
        String tmp="";
        String result="";
        int startS = vstr.indexOf("-");
        if (startS !=-1) {
            if (startS > 0) {
                tmp = vstr.substring(startS - 1, startS);
                if (!"+".equals(tmp) && !"-".equals(tmp) && !"*".equals(tmp) &&!"/".equals(tmp) &&
                        !"(".equals(tmp)){
                    result = result + vstr.substring(0, startS) + "`";
                }
                else {
                    result = result + vstr.substring(0, startS + 1);
                }
            }
            else {
                result = result + vstr.substring(0, startS + 1);
            }
            vstr = vstr.substring(startS + 1);
        }
        while (startS != -1) {
            startS = vstr.indexOf("-");
            if (startS > 0) {
                tmp = vstr.substring(startS - 1, startS);
                if (!"+".equals(tmp) && !"-".equals(tmp) && !"*".equals(tmp) &&!"/".equals(tmp) &&
                        !"(".equals(tmp)) {
                    result = result + vstr.substring(0, startS) + "`";
                }else {
                    result = result + vstr.substring(0, startS + 1);
                }
            }else {
                result = result + vstr.substring(0, startS + 1);
            }
            vstr = vstr.substring(startS + 1);
        }
        result+=vstr;
        return result;
    }


    public String getFormula(){
        return formula.replace('`','-').substring(1,formula.length()-1);
    }


    /*
     * 获得右括号数
     */
    private int getRightBracket(String calRule) {
        rightBracket = 0;
        startR = calRule.indexOf(")");
        if (startR != -1) {
            calRule = calRule.substring(startR + 1, calRule.length());
        }
        while (startR != -1) {
            rightBracket++;
            startR = calRule.indexOf(")");
            calRule = calRule.substring(startR + 1, calRule.length());
        }
        return rightBracket;
    }


    /*
    /*对比左右括号个数
    */
    private boolean compareToLR() {
        int lb = getLeftBracket(formula);
        int rb = getRightBracket(formula);
        boolean CTLR = false;
        if (lb == rb) {
            Msg = "";
            CTLR = true;
        } else if (lb > rb) {
            Msg = "左括弧的个数多于右括弧，请检查！";
            CTLR = false;
        } else {
            Msg = "左括弧的个数少于右括弧，请检查！";
            CTLR = false;
        }
        return CTLR;
    }
    /*
    /*检查公式中是否存在非法字符如(+、-)等
    */
    private boolean checkFormula(){
        boolean isOk=true;
        String[] bracket =new String[2];
        String[] sign=new String[4];
        bracket[0]="(";
        bracket[1]=")";
        sign[0]="+";
        sign[1]="`";
        sign[2]="*";
        sign[3]="/";
        String vstr="";
        for(int i=0;i<bracket.length;i++){
            for(int j=0;j<sign.length;j++){
                if (i==0) {
                    vstr = bracket[i] + sign[j];
                }else {
                    vstr = sign[j] + bracket[i];
                }
                if (formula.indexOf(vstr)>0){
                    Msg="公式中存在非法字符"+vstr;
                    isOk=false;
                    return isOk;
                }
            }
        }
        for(int i=0;i<sign.length;i++){
            for(int j=0;j<sign.length;j++){
                vstr=sign[i]+sign[j];
                if (formula.indexOf(vstr)>0){
                    Msg="公式中存在非法字符"+vstr;
                    isOk=false;
                    return isOk;
                }
            }
        }
        if (formula.indexOf("()")>0){
            Msg="公式中存在非法字符()";
            isOk=false;
        }
        return isOk;
    }

    /*
     *判断输入的字符串是否合法
     */
    public boolean checkValid(){
        if ((formula==null) || (formula.trim().length()<=0) ) {
            Msg="请设置属性calRule!";
            return false;
        }
        return (compareToLR()&&checkFormula());
    }


    /*返回公式执行结果
     */
    public double getResult(){
        String formulaStr = "", calRule = "";
        double value = 0.0;
        calRule = this.formula;
        if (checkValid()) {
            for (int i = 0; i < leftBracket; i++) {
                int iStart=calRule.lastIndexOf("(") + 1;
                //获得最里层括号里的内容
                formulaStr = calRule.substring(iStart, iStart+calRule.substring(iStart).indexOf(")")).trim();
                symbolParse(formulaStr);
                value = parseString();
                iStart=calRule.lastIndexOf("(");
                int iEnd=calRule.substring(iStart).indexOf(")")+1;
                calRule = calRule.substring(0,iStart).trim() +
                        value +
                        calRule.substring(iStart+iEnd, calRule.length()).trim();
            }
        }
        double tmp = Math.pow(10, 10);
        value = Math.round(value * tmp) / tmp;
        System.out.println(Msg);
        return value;
    }
    public void FormulaStr(String calRule) {
        String formulaStr = "";
        if (checkValid()) {
            for (int i = 0; i < leftBracket; i++) {
                formulaStr = calRule.substring(calRule.lastIndexOf("(") + 1, calRule.indexOf(")")).trim();
                symbolParse(formulaStr);
                double value = parseString();
                String.valueOf(value);
                System.out.println("formulaStr=" + formulaStr);
                //formulaVal = Double.parseDouble(formulaStr);
                System.out.println("formulaVal=" + value);
                calRule = calRule.substring(0, calRule.lastIndexOf("(")).trim() + value + calRule.substring(calRule.indexOf(")") + 1,                                                       calRule.length()).trim();
                System.out.println("calRule=" + calRule);
            }
        }
    }


    /*
    /*抽取最终括号内数据到List
    */
    private void symbolParse(String str) {
        list.clear();
        int count = 0;
        for (int i = 0; i < 4; i++) {
            compareMin(str);
            while (sym[i] != -1) {
                String insStr = str.substring(0, sym[i]).trim();
                //判断insStr是否含有字母
                if(containsLetter(insStr)) {
                    insStr = Integer.toString(parseLetter(insStr, paras.get(count)));
                }
                list.add(insStr);
                insStr = str.substring(sym[i], sym[i] + 1).trim();
                list.add(insStr);

                str = str.substring(sym[i] + 1, str.length()).trim();
                compareMin(str);
                count++;
            }
        }
        if (sym[0] == -1 && sym[1] == -1 && sym[2] == -1 & sym[3] == -1) {
            if(containsLetter(str)) {
                str = Integer.toString(parseLetter(str, paras.get(count)));
            }
            list.add(str);
        }
    }

    public boolean containsLetter(String insStr) {
        boolean isLetter = false;

        for(int i=0; i<insStr.length(); i++) {
            char ch = insStr.charAt(i);
            if(Character.isLetter(ch)) {
                isLetter = true;
            }
        }
        return isLetter;
    }

    public int parseLetter(String insStr, int para) {

        if(insStr.charAt(0) == '-') {
            para = 0-para;
        }
        return para;
    }

    /*
   /*循环比较赋SubString起始值
   */
    private void compareMin(String str) {
        int sps = str.indexOf("`");//减法subtration
        sym[0] = sps;
        int spa = str.indexOf("+");//加法addition
        sym[1] = spa;
        int spd = str.indexOf("/");//除法division
        sym[2] = spd;
        int spm = str.indexOf("*");//乘法multiplication
        sym[3] = spm;
        for (int i = 1; i < sym.length; i++) {
            for (int j = 0; j < sym.length - i; j++) {
                if (sym[j] > sym[j + 1]) {
                    int temp = sym[j];
                    sym[j] = sym[j + 1];
                    sym[j + 1] = temp;
                }
            }
        }
    }


    private double parseString()
            throws NumberFormatException, StringIndexOutOfBoundsException {
        try{
            calculate();
            return answer;
        }catch(Exception e){
            Msg="错误：" + e.getMessage();
            return 0.0;
        }
    }


    /*
     * 计算
     */
    private void calculate() {
        /*
        /*处理除法
        */
        int spd = list.indexOf("/");
        while (spd != -1) {
            leftNumber = list.get(spd - 1).toString();
            rightNumber = list.get(spd + 1).toString();
            list.remove(spd - 1);
            list.remove(spd - 1);
            list.remove(spd - 1);
            double ln = Double.valueOf(leftNumber).doubleValue();
            double rn = Double.valueOf(rightNumber).doubleValue();
            double answer = ln / rn;
            list.add(spd - 1, String.valueOf(answer));
            spd = list.indexOf("/");
        }
        /*
        /*处理乘法
        */
        int spm = list.indexOf("*");
        while (spm != -1) {
            leftNumber = list.get(spm - 1).toString();
            rightNumber = list.get(spm + 1).toString();
            list.remove(spm - 1);
            list.remove(spm - 1);
            list.remove(spm - 1);
            double ln = Double.valueOf(leftNumber).doubleValue();
            double rn = Double.valueOf(rightNumber).doubleValue();
            double answer = ln * rn;
            list.add(spm - 1, String.valueOf(answer));
            spm = list.indexOf("*");
        }
        /*
        /*处理减法
        */
        int sps = list.indexOf("`");
        while (sps != -1) {
            leftNumber = list.get(sps - 1).toString();
            rightNumber = list.get(sps + 1).toString();
            list.remove(sps - 1);
            list.remove(sps - 1);
            list.remove(sps - 1);
            double ln = Double.valueOf(leftNumber).doubleValue();
            double rn = Double.valueOf(rightNumber).doubleValue();
            double answer = ln - rn;
            list.add(sps - 1, String.valueOf(answer));
            sps = list.indexOf("`");
        }
        /*
        /*处理加法
        */
        int spa = list.indexOf("+");
        while (spa != -1) {
            leftNumber = list.get(spa - 1).toString();
            rightNumber = list.get(spa + 1).toString();
            list.remove(spa - 1);
            list.remove(spa - 1);
            list.remove(spa - 1);
            double ln = Double.valueOf(leftNumber).doubleValue();
            double rn = Double.valueOf(rightNumber).doubleValue();
            double answer = ln + rn;
            list.add(spa - 1, String.valueOf(answer));
            spa = list.indexOf("+");
        }
        if (list.size() != 0) {
            String result = list.get(0).toString();
            if (result == null || result.length() == 0) {result = "0";}
            answer = Double.parseDouble(list.get(0).toString());
        }
    }

    public static void main(String[] args) {
        //region
        /*
        float zonglfs = 10F;
        float a5 = 5F;
        float a4 = 4F;
        float a6 = 6F;
        float a7 = 7F;
        float zongjs = 20F;
        String ff = "zonglfs*a5+a4+a6+a7*zongjs";

//        Formula test1 = new Formula("zonglfs*a5+a4+a6+a7*zongjs");//测试常规的运算公式

        paras.add(10);//为公式里的变量存数据
        paras.add(5);//为公式里的变量存数据
        paras.add(4);
        paras.add(6);
        paras.add(7);
        paras.add(20);

        Formula test2 = new Formula("zonglfs*a5+a4+a6+a7*zongjs");//把两个变量分别替换成4和3再进行计算

//        System.out.println(test1.getResult());
        System.out.println(test2.getResult());
         */
        //endregion
        //region
        /*
            ScriptEngineManager manager = new ScriptEngineManager();
            final ScriptEngine engine = manager.getEngineByName("js");

            if (engine == null)
            {
                System.err.println("No engine for JavaScript" );
                System.exit(1);
            }
            try{
                String s = "2+2+(8-2)/3"; //此行可变为从文件读入的表达式串。
                System.out.print(s + "=");
                Object result = engine.eval(s);
                System.out.println((int)(double)result);
            }catch (Exception e){}
         */
        //endregion
        String s = "zonglfs*(a5+a4+a1)+a11+a6+a7*zongjs";
        String json = "{\"zonglfs\":\"a17\",\"a5\":\"a14\",\"a4\":\"a13\",\"a6\":\"a15\",\"a7\":\"a16\",\"zongjs\":\"a18\",\"a1\":\"a12\",\"a11\":\"a19\"}";
//        StringTokenizer st = new StringTokenizer(s,"+,-,*,/,(,),（,）",true);
//        while(st.hasMoreElements()){
//            System.out.println(st.nextElement());
//        }
//        System.out.println("----------------------------------");
        String[] ss = s.split("\\b");
        String s9 = "";
        for(int i=0;i<ss.length;i++){
            s9 += ss[i] + " ";
            System.out.println(ss[i]);
        }
        s9 += " ";
        System.out.println("s9:" + s9);

        JSONObject ret = JSONObject.parseObject(json);
        Iterator iter = ret.entrySet().iterator();
        System.out.println("s:" + s);
//        String ss = s.replaceAll(" +","");
//        System.out.println(ss);
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println(entry.getKey().toString());
//            System.out.println(entry.getValue().toString());
            String st = s9;
            s9 = st.replaceAll(entry.getKey().toString() + " ", entry.getValue().toString());
        }
        System.out.println("s9:" + s9);
        String s1 = s9.replaceAll(" +","");
        System.out.println("s1:" + s1);
    }

}
