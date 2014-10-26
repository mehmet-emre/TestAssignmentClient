package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import service.WalletService;
import service.WalletServiceEndpointService;

public class Client {

	public static String SERVICE_WSDL;
	public static String ACCESS_KEY;
	
	public static void main(String[] args) {
		try {
			loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WalletServiceEndpointService endpoint = new WalletServiceEndpointService();
		WalletService playerService = endpoint.getWalletServiceEndpointPort();
		
		/*
		 * random balance updates
		 */
		List<Object> response = playerService.updatePlayerBalance("Emre",1,1 );
		System.out.println(response.get(1).toString());
		response = playerService.updatePlayerBalance("PLAYER_A",1, 50 );
		System.out.println(response.get(1).toString());
		response = playerService.updatePlayerBalance("PLAYER_B",2,-1000 );
		System.out.println(response.get(1).toString());
		response = playerService.updatePlayerBalance("PLAYER_C",3,-100 );
		System.out.println(response.get(1).toString());
		
		
	}
	
	public static void loadProperties() throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream("config.properties");
			prop.load(input);
	 
			SERVICE_WSDL = prop.getProperty("SERVICE_WSDL");
			ACCESS_KEY = prop.getProperty("ACCESS_KEY");

		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}