package com.sl.global.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/************************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2013-3-7
 * Create Author: goldensoft
 * File Name:  后缀表达式计算工具类
 * Last version:  1.0
 * Last Update Date:
 * Change Log:
**************************************************/	
 
public class MyCalculateUtil {
    private static Pattern pattern;
    private static Matcher matcher;

    /**
     * 测试用例:1-3*(4-(2+5*3)+5)-6/(1+2)=23
     * 测试用例:11.2+3.1*(423-(2+5.7*3.4)+5.6)-6.4/(15.5+24)=1273.4199746835445
     * @param str_input
     * @return double
     */
    public static double calculate(String str_input) {
    	double result = 0D;
        try {
            // 以下对输入字符串做规则处理
            str_input = checkExpression(str_input);
            // 以下对输入字符串做表达式转换
            Vector<String> computeVector = getExpression(str_input);
            // for (int i=0;i<v_compute.size();i++ ) 
			    //{ System.out.print("  "+v_compute.get(i)); }
            // 以下进行后缀表达式转换
            Vector<String> suffixVector = transformToSuffix(computeVector);
            // for (int i=0;i<v_tmp_prefix.size();i++ ) 
			   // { System.out.print(v_tmp_prefix.get(i)); }
            // 以下进行后缀表达式运算
            result = evaluateSuffix(suffixVector);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() == null ? "表达式出错" : e.getMessage());
        }
        return result;
    }

    /** 表达式正确性规则处理与校验 */
    public static String checkExpression(String str) {
    	Stack<Character> checkBrackets = new Stack<Character>();
        Stack<Character> tmpStack = new Stack<Character>();
        String result = "";

        // 匹配合法的运算字符"数字,.,+,-,*,/,(,),"
        String calculateStr = "^[\\.\\d\\+\\-\\*/\\(\\)]+$";
        pattern = Pattern.compile(calculateStr);
        matcher = pattern.matcher(str);
        boolean isFindErrStr = matcher.matches();
        if (!isFindErrStr) {
            throw new RuntimeException("出现非运算字符");
        }

        // 匹配非法的浮点数.
        String errFloatStr = ".*(\\.\\d*){2,}.*";
        pattern = Pattern.compile(errFloatStr);
        matcher = pattern.matcher(str);
        boolean isErrFloat = matcher.matches();
        if (isErrFloat) {
            throw new RuntimeException("非法的浮点数");
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (checkFig(ch)) { // 数字
                if (!tmpStack.isEmpty() && tmpStack.peek() == ')') {
                    throw new RuntimeException("以')'开头的表达式");
                }
                tmpStack.push(ch);
                result = result + ch;
            } else { // 符号
                switch (ch) {
                case '(':
                    if (!tmpStack.isEmpty() && (tmpStack.peek() == '.')) {
                        throw new RuntimeException("'('前不能使'.'");
                    }
                    checkBrackets.push(ch);
                    if (tmpStack.isEmpty()
                            || (!checkFig(tmpStack.peek()) && tmpStack.peek() != ')')) {
                        result = result + ch;
                    } else {
                        result = result + "*" + ch;
                    }
                    tmpStack.push(ch);
                    break;
                case ')':
                    if (!checkBrackets.isEmpty()) {
                        char chx = checkBrackets.pop();
                        if (chx != '(') {
                            throw new RuntimeException("括号出现不配对");
                        }
                    } else {
                        throw new RuntimeException("括号出现不配对");
                    }
                    if (tmpStack.peek() == '.'
                            || (!checkFig(tmpStack.peek()) && tmpStack.peek() != ')')) {
                        throw new RuntimeException("')'出现位置错误");
                    }
                    tmpStack.push(ch);
                    result = result + ch;
                    break;
                case '+':
                case '-':
                    if (!tmpStack.isEmpty()
                            && (tmpStack.peek() == '+' || tmpStack.peek() == '-'
                                    || tmpStack.peek() == '*' || tmpStack.peek() == '/' 
									|| tmpStack.peek() == '.')) {
                        throw new RuntimeException("连续出现运算字符");
                    }
                    if (tmpStack.isEmpty() || tmpStack.peek() == '(') {
                        result = result + "0" + ch;
                    } else {
                        result = result + ch;
                    }
                    tmpStack.push(ch);
                    break;
                case '*':
                case '/':
                    if (tmpStack.isEmpty()) {
                        throw new RuntimeException("以乘号除号开头");
                    }
                    if ((!checkFig(tmpStack.peek()) && tmpStack.peek() != ')')) {
                        throw new RuntimeException("连续出现运算字符");
                    }
                    tmpStack.push(ch);
                    result = result + ch;
                    break;
                case '.':
                    if (tmpStack.isEmpty() || !checkFig(tmpStack.peek())) {
                        result = result + "0" + ch;
                    } else {
                        result = result + ch;
                    }
                    tmpStack.push(ch);
                    break;

                default:
                    break;
                }
            }
        }
        if (!checkBrackets.isEmpty()) {
            throw new RuntimeException("括号出现不配对");
        }

        return result;
    }

    /** 输入字符串转换.把从控制台读入的字符串转成表达式存在一个队列中.
    例:123+321 存为"123""+""321" */
    public static Vector<String> getExpression(String str) {
        Vector<String> tmpVctr = new Vector<String>();
        char[] temp = new char[str.length()];
        str.getChars(0, str.length(), temp, 0);
        String fi = "";
        int i = 0;
        // 匹配数字和小数点
        String regex_fig = "[\\.\\d]";
        // 匹配运算符(+,-,*,/)和括号("(",")")
        String regex_operator = "[\\+\\-\\*/\\(\\)]";
        Pattern numPtn = Pattern.compile(regex_fig);
        Pattern operatorPtn = Pattern.compile(regex_operator);
        Matcher m = null;
        boolean b;
        while (i < str.length()) {
            Character c = new Character(temp[i]);
            String s = c.toString();
            m = operatorPtn.matcher(s);
            b = m.matches();

            if (b) {
                tmpVctr.add(fi);
                fi = "";
                tmpVctr.add(s);
            }
            m = numPtn.matcher(s);
            b = m.matches();
            if (b) {
                fi = fi + s;
            }
            i++;
        }
        tmpVctr.add(fi);

        return tmpVctr;
    }

    /** 转换中序表示式为后缀表示式 */
    public static Vector<String> transformToSuffix(Vector<String> expressionVctr) {
        Vector<String> suffixVctr = new Vector<String>();
        Stack<String> tmpStack = new Stack<String>();
     // 匹配正浮点数
        String regexFloat = "\\d+(\\.\\d+)?";
        pattern = Pattern.compile(regexFloat);
        boolean b;
        String str = "";

        for (int i = 0; i < expressionVctr.size(); i++) {
            str = expressionVctr.get(i).toString();
            matcher = pattern.matcher(str);
            b = matcher.matches();

            if (b) {
                suffixVctr.add(str);
            } else {
                if (str.equals("+") || str.equals("-")) {
                    if (tmpStack.isEmpty()) {
                        tmpStack.push(str);
                    } else {
                        while (!tmpStack.isEmpty()) {
                            String tmpStr = tmpStack.peek();

                            if (tmpStr.equals("(")) {
                                break;
                            } else {
                                suffixVctr.add(tmpStack.pop());
                            }
                        }
                        tmpStack.push(str);
                    }
                }

                if (str.equals("*") || str.equals("/")) {
                    if (tmpStack.isEmpty()) {
                        tmpStack.push(str);
                    } else {
                        while (!tmpStack.isEmpty()) {
                            String tmpStr = tmpStack.peek();

                            if (tmpStr.equals("(") || tmpStr.equals("+") 
                                || tmpStr.equals("-")) {
                                break;
                            } else {
                                suffixVctr.add(tmpStack.pop());
                            }
                        }
                        tmpStack.push(str);
                    }
                }

                if (str.equals("(")) {
                    tmpStack.push(str);
                }

                if (str.equals(")")) {
                    while (!tmpStack.isEmpty()) {
                        String tmpStr = tmpStack.peek();
                        if (tmpStr.equals("(")) {
                            tmpStack.pop();
                            break;
                        } else {
                            suffixVctr.add(tmpStack.pop());
                        }
                    }
                }
            }
        }
        while (!tmpStack.isEmpty()) {
            suffixVctr.add(tmpStack.pop());
        }
        return suffixVctr;
    }

    /** 后缀表示式求值 */
    public static strictfp double evaluateSuffix(Vector<String> suffixVctr) {
        String tmpStr = "";
        double num1, num2, interAns = 0;
        Stack<Double> computeStack = new Stack<Double>();

        int i = 0;
        while (i < suffixVctr.size()) {
            tmpStr = suffixVctr.get(i).toString();
            if (!tmpStr.equals("+") && !tmpStr.equals("-") && !tmpStr.equals("*")
                    && !tmpStr.equals("/")) {
                interAns = computeStack.push(Double.parseDouble(tmpStr));
            } else {
                num2 = (Double) (computeStack.pop());
                num1 = (Double) (computeStack.pop());

                if (tmpStr.equals("+")) {
                    interAns = num1 + num2;
                }
                if (tmpStr.equals("-")) {
                    interAns = num1 - num2;
                }
                if (tmpStr.equals("*")) {
                    interAns = num1 * num2;
                }
                if (tmpStr.equals("/")) {
                    interAns = num1 / num2;
                }
                computeStack.push(interAns);
            }
            i++;
        }
        return interAns;
    }

    /** 括号匹配检测 */
    public static boolean checkBracket(String str) {
        Stack<Character> s_check = new Stack<Character>();
        boolean b_flag = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
            case '(':
                s_check.push(ch);
                break;
            case ')':
                if (!s_check.isEmpty()) {
                    char chx = s_check.pop();
                    if (ch == ')' && chx != '(') {
                        b_flag = false;
                    }
                } else {
                    b_flag = false;
                }
                break;
            default:
                break;
            }
        }
        if (!s_check.isEmpty()) {
            b_flag = false;
        }
        return b_flag;
    }

    /** 是否是一位数字 */
    private static boolean checkFig(Object ch) {
        String s = ch.toString();
        // 匹配数字
        String regexNum = "\\d";
        pattern = Pattern.compile(regexNum);
        matcher = pattern.matcher(s);
        boolean b_fig = matcher.matches();
        return b_fig;
    }

    /**
     *静态方法,用来从控制台读入表达式
     */
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
