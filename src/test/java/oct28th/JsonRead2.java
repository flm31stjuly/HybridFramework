package oct28th;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonRead2 {

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		
		JsonParser jsonParser=new JsonParser();
		
		Object obj=jsonParser.parse(new FileReader("src\\test\\resources\\testdata\\jsons\\Regression.json"));
		
		JsonArray jsonArray= (JsonArray) obj;
		
		System.out.println(jsonArray.size());
		
		Iterator<JsonElement> it=jsonArray.iterator();
		
		JsonElement element=null;
		
		while(it.hasNext())
		{
			
			element=it.next();
			
			JsonObject ob=(JsonObject) element;
			
			System.out.println(ob.get("name"));
			System.out.println(ob.get("rollNo"));
			System.out.println(ob.get("isTester"));
			System.out.println(ob.get("hobbies"));
					
		}
	

	}

}
