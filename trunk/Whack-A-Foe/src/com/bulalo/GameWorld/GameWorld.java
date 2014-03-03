//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	public static final float[] coordinateX = {27f, 63.25f, 99f, 21f, 62.75f, 103.5f, 17.75f, 62.75f, 108f};
	public static final float[] coordinateY = {65f, 65f, 65f, 120f, 120f, 120f, 175.5f, 175.5f, 175.5f};
	//public static final Vector2[] position = {(31.25f, 67.5f), (67.5f, 67.5f)};
	
	private float x, y;
	
	private boolean[] removed = {false, false, false, false, false, false, false, false, false};
	private int[] respawnCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] removeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int escapeCounter = 0;
	
	private int usedTime;
	
	private ArrayList<Dummy> dummies;
	
	Random rand = new Random();
	
	public GameWorld(){

		int x = rand.nextInt(9);
		//int y = rand.nextInt(8) + 1;
		
		dummy = new Dummy(500, x, y, 35, 50);
		dummy.spawn(coordinateX[x], coordinateY[x]);
	}
	
	//adds multiple dummies in the arraylist
	public void inGame(){
		dummies = new ArrayList<Dummy>();
		
		for(int ctr = 0; ctr < 1; ctr++){
			dummy = new Dummy(500, x, y, 35, 50);
			dummy.setX(coordinateX[ctr]);
			dummy.setY(coordinateY[ctr]);
			dummies.add(dummy);
		}
	}
	
	public void update(float delta){	
		dummy.update(delta);
		
//		int i = 0;
//		while(i < dummies.size()){
//			Dummy dum = dummies.get(i);
//			checkToRemove();
//			if(dum.isMarked()){
//				dum.remove();
//				removed[i] = true;
//				dum.isNotMarked();
//			}else{
//				i++;
//			}
//		}
		
	}
	
	//this method checks if a dummy should be removed
	public void checkToRemove(){
		for(int i = 0; i < dummies.size(); i++){
			Dummy dum = dummies.get(i);
			if(removeCounter[i] >= 200){
				dummies.remove(i);
				removed[i] = true;
				dum.isNotMarked();
				removeCounter[i] = 0;
				escapeCounter += 1;
				for(int x = 0; x < dummies.size(); x++){
					removeCounter[x] = 0;
				}
			}
		}
	}
	
	public void checkHit(){
		for(int i = 0; i < dummies.size(); i++){
			Dummy dum = dummies.get(i);
			if(dum.isAlive()){
				for(int x = 0; x < dummies.size(); x++){
					removeCounter[x] = 0;
				}
			}
		}
	}
	
	public void game(){
		usedTime = 1000;
		inGame();
		
		while(escapeCounter < 50){
			long startTime = System.currentTimeMillis();
			//update(float delta);
		}
		
	}
	
	public void respawn(){
		for(int i = 0; i < 9; i++){
			if(removed[i] == true){
				if(respawnCounter[i] >= 200){
					Dummy dum = new Dummy(500, x, y, 35, 50);
					respawnCounter[i] = 0;
					removed[i] = false;
					int x = rand.nextInt(9);
					dum.spawn(coordinateX[x], coordinateY[x]);
					
					for(int y = 0; y < dummies.size(); y++){
						removeCounter[y] = 0;
					}
				}else{
					respawnCounter[i] += 1;
				}
			}else{
				removeCounter[i] += 1;
			}
		}
	}
	
	public Dummy getDummy(){
		return dummy;
	}
	
}
