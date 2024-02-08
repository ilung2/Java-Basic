import java.util.Arrays;

import com.google.gson.Gson;

/*
	{
		"winningNum" : [ 1, 2, 3, 4, 5, 6 ],
		"bonusNum" : 7
	}
	---------------------------
	{
		"games" : {
			"game1" : [ 11, 22, 33, 34, 44, 45 ]
			"game2" : [ 4, 5, 6, 10, 11, 12 ]
		}
	}
	-------------------------
	{
		"practice" : [ 4, 5, 6 ]
	}
*/
class Game {
	private int[] game1;
	private int[] game2;

	public Game(int[] game1, int[] game2) {
		super();
		this.game1 = game1;
		this.game2 = game2;
	}

	@Override
	public String toString() {
		return "Game [game1=" + Arrays.toString(game1) + ", game2=" + Arrays.toString(game2) + "]";
	}

	public int countMatchingNumbers(int[] winningNum) {
		int count = 0;
		for (int num : winningNum) {
			if (Arrays.binarySearch(game1, num) >= 0 || Arrays.binarySearch(game2, num) >= 0) {
				count++;
			}
		}
		return count;
	}
}

class MyClass {
	private int[] practice;
	private int[] winningNum;
	private int bonusNum;

	public MyClass(int[] winningNum, int bonusNum) {
		super();
//		this.practice = practice;
		this.winningNum = winningNum;
		this.bonusNum = bonusNum;
	}

	@Override
	public String toString() {
		return "[winningNum = " + Arrays.toString(winningNum) + ", bonusNum = " + bonusNum + "]";
	}

	public int countMatchingNumbers(Game g) {
		return g.countMatchingNumbers(winningNum);
	}
}

public class Main {
	public static void main(String[] args) {
		Gson gson = new Gson();

		String text = "{\"winningNum\": [1, 2, 3, 4, 5, 6], \"bonusNum\": 7}";
		String game = "{\"game1\": [ 11, 22, 33, 34, 44, 45 ], \"game2\" : [ 4, 5, 6, 10, 11, 12 ]}";

		MyClass m = gson.fromJson(text, MyClass.class);
		Game g = gson.fromJson(game, Game.class);

		System.out.println("lottery number :" + m);
		System.out.println(g);
		
		int matchingNumbers = m.countMatchingNumbers(g);
		System.out.println("Matching Numbers: " + matchingNumbers);
	}
}
