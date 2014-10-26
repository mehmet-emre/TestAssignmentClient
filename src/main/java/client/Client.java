package client;

import java.util.List;

import service.WalletService;
import service.WalletServiceEndpointService;

public class Client {

	public static void main(String[] args) {

		WalletServiceEndpointService endpoint = new WalletServiceEndpointService();
		WalletService playerService = endpoint.getWalletServiceEndpointPort();
		
		List<Object> response = playerService.updatePlayerBalance("Emre",1,1 );
		List<Object> response2 = playerService.updatePlayerBalance("PLAYER_A",1,50 );
		List<Object> response3 = playerService.updatePlayerBalance("PLAYER_B",1,-1000 );

		
		System.out.println(""); 


	}

}
