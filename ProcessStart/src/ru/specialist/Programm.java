package ru.specialist;

import java.io.IOException;

public class Programm {

	public static void main(String[] args) throws IOException {
		System.out.println("Starting external app...");
		Runtime.getRuntime().exec("explorer.exe");

	}

}
