package com.staticvillage.ice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionManager {
	public static final int REQUEST_PORT = 8765;
	
	public static String showPresence(String userAddress, String address, int port, long uid){
		//TODO - generate access token
		String accessToken = "";
		PresenceToken token = new PresenceToken(accessToken, userAddress);
		return sendToken(address, port, token);
	}
	
	public static String requestContextAccess(String address, int port, long uid, String[] namespaces){
		RequestToken token = new RequestToken(uid, namespaces);
		return sendToken(address, port, token);
	}
	
	public static String sendToken(String address, int port, Token token){
		String response = null;
		try {
			Socket clientSocket = new Socket(address, port);
			DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			os.writeChars(token.getJsonString());
			response = is.readLine();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
}
