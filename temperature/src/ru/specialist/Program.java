package ru.specialist;

import java.util.Scanner;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException
	{
	
		Scanner sc = new Scanner(System.in);
		System.out.print("tC = ");
		double с = sc.nextDouble();//sc.nextInt();
		//if (sc.hasNextLine()) sc.nextLine();
		
		double f = с * 9 /5 + 32;
		System.out.printf("Температура в фаренгейтах: %.2f\n", f);
		sc.close();
	}
}
