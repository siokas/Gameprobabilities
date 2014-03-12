package com.gameprobabilities.siokas;

import java.util.Collections;
import java.util.ArrayList;

public class Generate {

	public String pick_num(int x, int y) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < x; i++) {
			numbers.add(i + 1);
		}
		
		String s = "";
		Collections.shuffle(numbers);
		for (int j=0; j<y; j++)
		{
			 s = s + (numbers.get(j).toString() + " ");
		}
		return s;
	}
	
	public String pick_numRoulette(int x, int y) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= x; i++) {
			numbers.add(i);
		}
		
		String s = "";
		Collections.shuffle(numbers);
		for (int j=0; j<y; j++)
		{
			 s = s + (numbers.get(j).toString() + " ");
		}
		return s;
	}
}