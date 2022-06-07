package ru.serversocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServerApp {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8080);) {
			System.out.println("Multi Thread Server started...");
			while (true)
				try {
					Socket socket = serverSocket.accept();
					new Thread(() -> {
						try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								BufferedWriter writer = new BufferedWriter(
										new OutputStreamWriter(socket.getOutputStream()));) {
							System.out.println("Client connected...");
							String request = reader.readLine();
							String response = String.format("Hi, your request is :%s\n", request);
							writer.write(response);
							System.out.printf("Hi, your request is :%s\n", request);
							writer.newLine();
							writer.flush();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}).start();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
