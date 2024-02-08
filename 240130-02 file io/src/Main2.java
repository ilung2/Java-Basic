import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Main2 {
	public static void main(String[] args) {
		JsonObject obj = new JsonObject();
		obj.addProperty("bonusNum", 7);
		
		JsonArray arr = new JsonArray();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		
		obj.add("winningNum", arr);
		
		System.out.println(obj.toString());
	}
}
