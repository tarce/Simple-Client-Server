package server;

import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String arv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("FROM CLIENT:" + clientSentence);
			
			
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			capitalizedSentence = inFromUser.readLine() + '\n';
			outToClient.writeBytes(capitalizedSentence);
		}	
	}
}
