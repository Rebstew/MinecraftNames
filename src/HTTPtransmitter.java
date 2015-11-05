import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


public class HTTPtransmitter {
	
	private Client client;
	
	public HTTPtransmitter(){
		this.client = ClientBuilder.newClient();
	}
	
	/**
	 * Requests uuid of given nickname to Mojang API
	 * @param name current name to retrieve uuid
	 * @return the uuid of the player, if it exists
	 */
	public String requestUUID(String name) throws JSONException{
		String uuid = null;
		String url = "https://api.mojang.com/profiles/minecraft";
		Entity payload = Entity.json("[\""+name+"\"]");
		Response response = client.target(url)
				  .request(MediaType.APPLICATION_JSON_TYPE)
				  .post(payload);
		
		System.out.println("payload: "+payload.toString());
		System.out.println("status: " + response.getStatus());
		System.out.println("headers: " + response.getHeaders());
		String body = response.readEntity(String.class);
		System.out.println("body:" + body);
		
		//create JSON object to parse body
		JSONObject jsonObj = new JSONObject(body.substring(1, body.length()-1));
		uuid = jsonObj.getString("id");
		System.out.println("uuid: "+uuid);
		
		return uuid;
		
	}
	
	public String requestNameHistory(String uuid){
		return null;
	}
	
	

}
