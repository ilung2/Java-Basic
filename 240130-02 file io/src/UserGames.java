import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Games {
	@SerializedName("game1")
	@Expose
	public List<Integer> game1;
	@SerializedName("game2")
	@Expose
	public List<Integer> game2;
}

public class UserGames {
	@SerializedName("games")
	@Expose
	public Games games;
	
	public static void main(String[] args) {
		Games games = new Games();
		games.game1 = Arrays.asList(11, 22, 33, 34, 44, 45);
		games.game2 = Arrays.asList(4, 5, 6, 10, 11, 12);
		
		UserGames userGames = new UserGames();
		userGames.games = games;
		
		Gson gson = new Gson();
		String text = gson.toJson(userGames);
		
		System.out.println(text);
		
		UserGames copy = gson.fromJson(text, UserGames.class);
		System.out.println(copy.games.game1);
		System.out.println(copy.games.game2);
	}
	
}