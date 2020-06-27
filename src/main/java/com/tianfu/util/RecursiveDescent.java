package com.tianfu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecursiveDescent {
	private static String Str = null; // 输入的表达式
	private static String lookahead = null;// 当前记号
	private static String Sub = null;// 剩余的子串
	//private static boolean flag = false;
 
	public static void match(String s) {
		if (lookahead.equals(s)) {
			
			lookahead = nextToken();
			System.out.println("匹配" + s);
			 System.out.println(s); 
		} else {
			error();
		}
 
	}
 
	public static void error() {
		System.out.println("匹配失败");
 
	}
 
	public static String nextToken() {
		if (Sub.length() >= 2) {
			if (Sub.substring(0, 2).equals("i")) {
				Sub = Sub.substring(2, Sub.length());
				lookahead = "i";
			} else {
				lookahead = Sub.substring(0, 1);
				Sub = Sub.substring(1, Sub.length());
			}
		} else if (Sub.length() == 1) {
			lookahead = Sub.substring(0, 1);
		}
		return lookahead;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一个表达式：");
		Str = in.nextLine();
		Sub = Str;
		lookahead = nextToken();
		in.close();
		E();
	}
 
	public static void E() {
		if (lookahead.equals("(") || lookahead.equals("i"))// First(T)={(,id};
		{
			System.out.println("E -> TE'");
			T();
			E1();
		} else if (lookahead.equals(")") || lookahead.equals("#"))// Follow(E')加入到E的同步记号集合中
		{
			error();
			// 出错，但不作任何处理
		} else {
			lookahead = nextToken();
			error();
			E();
		}
	}
 
	public static void E1() {
		if (lookahead.equals("+")) {
			System.out.println("E1 -> TE'");
			match("+");
			T();
			E1();
		} else if (lookahead.equals(")") || lookahead.equals("#"))
		// Follow(E') = { ) , # };
		{
			System.out.println("E' -> ^");
			if (lookahead.equals("#"))
				{match("#");System.exit(0);}
 
		} else// 出错，当前记号不在E'的同步记号集合中，跳过当前符号
		{
			error();
			lookahead = nextToken();
			E1();
		}
	}
 
	public static void T() {
		if (lookahead.equals("(") || lookahead.equals("i"))// First(F)={ ( , id };
		{
			System.out.println("T -> FT'");
			F();
			T1();
		} else if (lookahead.equals("+") || lookahead.equals(")") || lookahead.equals("#"))
		// Follow(T)加入到T的同步记号集合中
		{
			error();
			if (lookahead.equals("#")) {
				match("#");
				System.exit(0);
			}
			// 出错，但无需跳过任何记号，跳过T即可，即不做任何处理
		} else {
			// 出错，当前记号不在T的同步记号集合中，跳过当前记号
			error();
			lookahead = nextToken();
			T();
		}
	}
 
	public static void T1() {
 
		if (lookahead.equals("*")) {
			System.out.println("T' -> *FT'");
			match("*");
			F();
			T1();
		} else if (lookahead.equals("+") || lookahead.equals(")") || lookahead.equals("#")) {
			System.out.println("T' -> ^");
			if (lookahead.equals("#")) {
				match("#");
				System.exit(0);
			}
		} else// 出错，当前记号不在T1的同步记号集合中，跳过当前记号
		{
			error();
			lookahead = nextToken();
			T1();
		}
	}
 
	public static void F() {
 
		if (lookahead.equals("(")) {
			match("(");
			E();
			match(")");
			System.out.println("F -> (E)");
		} else if (lookahead.equals("i")) {
			System.out.println("F -> i");
			match("i");
		} else if (lookahead.equals("+") || lookahead.equals("*") || lookahead.equals(")") || lookahead.equals("#"))
		// Follow(F)集合加入到F的同步记号集合中
		{
			error();
			// 出错，但无须跳过任何记号，跳过 F 即可，即不作任何处理
		} else// 出错，当前记号不在F的同步记号集合中，跳过当前符号
		{
			error();
			lookahead = nextToken();
			F();
		}
	}


}
