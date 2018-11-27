package com.jd.helper;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

	public static int inputIn(){
		int temp = 1;
		Scanner in = new Scanner(System.in);
		try{
			
			temp = in.nextInt();
		}catch(InputMismatchException e){
			System.out.println("***这里只能输入数字,输入有误默认为1***");
//			e.printStackTrace();
		}
		return temp;
	}
	
	
	public static String inputString(){
		String temp = null;
		Scanner in = new Scanner(System.in);
		try{
			temp = in.next();
		}catch(NumberFormatException e){
			
//			e.printStackTrace();
		}
		return temp;
	}
	
	public static String inputStringLine(){
		String temp = null;
		Scanner in = new Scanner(System.in);
		try{
			temp = in.nextLine();
		}catch(NumberFormatException e){
			
//			e.printStackTrace();
		}
		return temp;
	}
	
	public static double inputDouble(){
		double temp = 0;
		Scanner in = new Scanner(System.in);
		try{
			boolean f = in.hasNextDouble();
			if( f == true ){
				temp = in.nextDouble();
			}else{
				System.out.println("***输入有误,默认为0.0***");
			}
		}catch(NumberFormatException e){
			
//			e.printStackTrace();
		}
		return temp;
	}
	
}
