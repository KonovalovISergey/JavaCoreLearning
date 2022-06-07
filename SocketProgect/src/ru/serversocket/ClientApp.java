package ru.serversocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientApp {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 8080);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
			
			//Thread.sleep(20000);
			writer.write("Hello! I'am client");
			writer.newLine();
			writer.flush();
			
			String response = reader.readLine();
			
			System.out.println(response);
			
		} catch (IOException e) {
			e.printStackTrace();
		} //catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

}
