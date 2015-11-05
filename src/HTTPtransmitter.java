import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
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
	 * @return the uuid of the player, null if error or account does not exist
	 */
	public String requestUUID(String name) throws JSONException{
		System.out.println("requestUUID("+name+")");
		
		String uuid = null;
		String url = "https://api.mojang.com/profiles/minecraft";
		Entity<String> payload = Entity.json("[\""+name+"\"]");
		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(payload);

		int status = response.getStatus();
		
		//server answered
		if(status == 200){
		String body = response.readEntity(String.class);

		//create JSON object to parse body
		JSONArray jsonArray = new JSONArray(body);
		if(jsonArray.length() > 0){
			uuid = ((JSONObject)jsonArray.get(0)).getString("id");
		}
		System.out.println("uuid: "+uuid);
		} else {
			System.err.println("Request returned "+status);
		}

		return uuid;

	}

	/**
	 * Retrieves name history of given account
	 * @param uuid identifier of the account
	 * @return list of Name objects corresponding to the previous names of this account
	 */
	public List<Name> requestNameHistory(String uuid){
		System.out.println("requestNameHistory("+uuid+")");
		ArrayList<Name> result = new ArrayList<Name>();

		//sends HTTP GET request
		String url = "https://api.mojang.com/user/profiles/"+uuid+"/names";
		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get();

		int status = response.getStatus();
		if(status == 200){
			String body = response.readEntity(String.class);

			JSONArray jsonArray = new JSONArray(body);
			//System.out.println("Array : "+jsonArray);

			//
			String name = null;
			Date date = null;

			//System.out.println("\n\njsonArray content");

			//fills name list with arraycontent
			for(int i=0; i<jsonArray.length()-1; i++){
				JSONObject currentObject = (JSONObject) jsonArray.get(i);
				name = currentObject.getString("name");
				if(i!=0)date = new Date(currentObject.getLong("changedToAt"));
				result.add(new Name(name, date));

				name = null;
				date = null;

			}

			System.out.println("Result : "+result);
		} else {
			System.err.println("Request returned "+status);
		}
		return result;
	}
	
	public void requestSkin(String uuid){
		System.out.println("requestSkin("+uuid+")");
		//sends HTTP GET request
				String url = "https://sessionserver.mojang.com/session/minecraft/profile/"+uuid;
				Response response = client.target(url)
						.request(MediaType.APPLICATION_JSON_TYPE)
						.get();
				int status = response.getStatus();
				System.out.println("Status : "+status);
				String body = response.readEntity(String.class);
				System.out.println(body);
				
				JSONObject object = JSONObject(body);
				
				//BufferedImage image = ImageIO.read(input);
	}



}
