package com.jspiders.calculator;

import java.util.Scanner;

public class CalculatorApp {
public static void main(String[] args) {
	
	boolean exit = true;
	while (exit) {
		long result;
		Scanner operation = new Scanner(System.in); 
		System.out.println("Pls Enter First Value");
		long firstValue = operation.nextLong();
		System.out.println("Pls Enter Second Value");
		long secondValue = operation.nextLong();
		System.out.println("\n Operations \n1 : Addition \n2 : Substraction \n3 : Multification \n4 : Division \n5 : Modulas Of Division \n6 : Exit");
		System.out.println("Pls Choose the Operation to Perfom Calculation");
		int choose = operation.nextInt();
		switch (choose) {
		case 1:{
		System.out.print("Addition of "+ firstValue+" and "+secondValue+" is :");	
		System.out.println(result=firstValue + secondValue);
		System.out.println("You can also perform other calculations if equired.... ");
		System.out.println("");
		}
			break;
		case 2:{
			System.out.print("Substraction of "+ firstValue+" and "+secondValue+" is :");	
			System.out.println(result=firstValue - secondValue);
			System.out.println("You can also perform other calculations if equired.... ");
			System.out.println("");
			}
		break;
		case 3:{
			System.out.print("Multiflication of "+ firstValue+" and "+secondValue+" is :");	
			System.out.println(result=firstValue * secondValue);
			System.out.println("You can also perform other calculations if equired.... ");
			System.out.println("");	
		}
		break;
		case 4:{
			System.out.print("Division of "+ firstValue+" by "+secondValue+" is :");	
			System.out.println(result=firstValue / secondValue);
			System.out.println("You can also perform other calculations if equired.... ");
			System.out.println("");	
		}
		break;
		case 5:{
			System.out.print("remaider of "+ firstValue+" by "+secondValue+" is :");	
			System.out.println(result=firstValue % secondValue);
			System.out.println("You can also perform other calculations if equired.... ");
			System.out.println("");	
		}
		break;
		case 6:{
			System.out.println("******** Thank You For Using This App ********");
			exit=false;
			}
		break;
		default:{
			System.out.println("Pls Choose The Correct Operator & try Aagin.....");
			System.out.println("Developed by Prashant Gaikwad");
			System.ot.println("");
		}
        operation.close();
        }	
	}
}
}
