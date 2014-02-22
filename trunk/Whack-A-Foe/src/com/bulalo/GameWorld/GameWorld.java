//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	public static final float[] coordinateX = {35, 67, 102, 27, 65, 105, 20, 62, 107};
	public static final float[] coordinateY = {167, 167, 167, 215, 215, 215, 265, 265, 265};
	
	private float x, y;
	
	private boolean[] removed = {false, false, false, false, false, false, false, false, false};
	private int[] respawnCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] removeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int escapeCounter = 0;
	
	private ArrayList<Dummy> dummies;
	
	public GameWorld(){
		Random randX = new Random();
		Random randY = new Random();
		int x,y;	
		x = randX.nextInt(8) + 1;
		y = randY.nextInt(8) + 1;
		
		dummy = new Dummy(500, x, y, 33, 48);
		dummy.spawn(coordinateX[x], coordinateY[y]);
	}
	
	//adds multiple dummies in the arraylist
	public void inGame(){
		dummies = new ArrayList<Dummy>();
		
		for(int counter = 0; counter < 1; counter++){
			dummy = new Dummy(500, x, y, 55, 85);
			dummy.setX(coordinateX[counter]);
			dummy.setY(coordinateY[counter]);
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
