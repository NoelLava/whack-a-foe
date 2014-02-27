//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	public static final float[] coordinateX = {27f, 63.25f, 99.5f, 22.5f, 63.75f, 102.5f, 18.75f, 63.75f, 107f};
	public static final float[] coordinateY = {65f, 65f, 65f, 120f, 120f, 120f, 175.5f, 175.5f, 175.5f};
	//public static final Vector2[] position = {(31.25f, 67.5f), (67.5f, 67.5f)};
	
	private float x, y;
	
	private boolean[] removed = {false, false, false, false, false, false, false, false, false};
	private int[] respawnCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] removeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int escapeCounter = 0;
	
	private ArrayList<Dummy> dummies;
	
	Random rand = new Random();
	
	public GameWorld(){

		int x = rand.nextInt(8) + 1;
		//int y = rand.nextInt(8) + 1;
		
		dummy = new Dummy(500, x, y, 32.5f, 47.5f);
		dummy.spawn(coordinateX[x], coordinateY[x]);
	}
	
	//adds multiple dummies in the arraylist
	public void inGame(){
		dummies = new ArrayList<Dummy>();
		
		for(int ctr = 0; ctr < 1; ctr++){
			
			dummy = new Dummy(500, x, y, 32.5f, 47.5f);
			dummy.setX(coordinateX[ctr]);
			dummy.setY(coordinateY[ctr]);
			dummies.add(dummy);
		}
	}
	
	public void update(float delta){	
		dummy.update(delta);
	}
	
	//this method checks if a dummy should be removed
	public void checkToRemove(){
		for(int i = 0; i < dummies.size(); i++){
			dummies.get(i);
		}
	}
	
	public Dummy getDummy(){
		return dummy;
	}
	
}
