//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy, dummy2;
	public static final float[] coordinateX = {27f, 63.25f, 99f, 21f, 62.75f, 103.5f, 17.75f, 62.75f, 108f};
	public static final float[] coordinateY = {65f, 65f, 65f, 120f, 120f, 120f, 175.5f, 175.5f, 175.5f};
	//public static final Vector2[] position = {(31.25f, 67.5f), (67.5f, 67.5f)};
	
	private float x, y;
	
	private boolean[] removed = {false, false, false, false, false, false, false, false, false};
	private int[] respawnCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] removeCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int escapeCounter = 0;
	
	private long usedTime;
	
	private ArrayList<Dummy> dummies;
	
	Random rand = new Random();
	
	public GameWorld(){
		//dummies = new ArrayList<Dummy>();

		int r = rand.nextInt(9);
	
		dummy = new Dummy(500, x, y, 35, 50);
		dummy.spawn(coordinateX[r], coordinateY[r]);
		//dummies.add(dummy);
		
	}
	
	public void update(float delta){	
		dummy.update(delta);
		//updateRunning();
		inGame();
		updateGame();
		checkHit();
		respawn();
		//checkToRemove();
		System.out.println("array size - " + dummies.size());
				
	}	
	
	//adds multiple dummies in the arraylist
	public void inGame(){
		dummies = new ArrayList<Dummy>();
		if(dummies.size() != 0){
			System.out.println("add a dummy");
			for(int ctr = 0; ctr < 1; ctr++){
				int r = rand.nextInt(9);
				dummy = new Dummy(500, x, y, 35, 50);
				dummy.setX(coordinateX[r]);
				dummy.setY(coordinateY[r]);
				dummies.add(dummy);
			}
		}else{
			System.out.println("array is full");
		}
		
	}
	
	public void updateRunning(){
		if(!dummy.isAlive()){
			dummies.remove(dummy);
			
			dummy = null;
			int r = rand.nextInt(9);		
			dummy = new Dummy(500, x, y, 35, 50);
			dummy.spawn(coordinateX[r], coordinateY[r]);
			dummies.add(dummy);
		}		
	}
	
	public void updateGame(){
		int i = 0;
		while(i < dummies.size()){
			Dummy dum = dummies.get(i);
			checkToRemove();
			if(dum.isMarked()){
				dum.remove();
				removed[i] = true;
				dum.isNotMarked();
			}else{
				i++;
			}
		}	
	}
	
	//this method checks if a dummy should be removed
	public void checkToRemove(){
		for(int i = 0; i < dummies.size(); i++){
			Dummy dum = dummies.get(i);
			if(dum.isAlive()/*removeCounter[i] >= 200*/){
				System.out.println("dummy " + i + " is still alive");
			}else{
				System.out.println("should remove" + i);
				dummies.remove(dum);
				removed[i] = true;
				dum.isNotMarked();
				removeCounter[i] = 0;
				escapeCounter += 1;
				for(int x = 0; x < dummies.size() - 1; x++){
					removeCounter[x] = 0;
				}
			}
		}
	}
	
	public void checkHit(){
		for(int i = 0; i < dummies.size(); i++){
			System.out.println("check hit - " + i);
			Dummy dum = dummies.get(i);
			if(dum.isAlive() == false){
				System.out.println("dummy dies");
				for(int x = 0; x < dummies.size(); x++){
					removeCounter[i] = 0;
				}
			}else{
				
			}
		}
	}
	
	public void game(){
		usedTime = 1000;
		inGame();
		
		while(escapeCounter < 50){
			//long startTime = System.currentTimeMillis();
			updateGame();
			checkHit();
			respawn();
			//usedTime = System.currentTimeMillis() - startTime;
		}	
	}
	
	public void respawn(){
		for(int i = 0; i < 9; i++){
			if(removed[i] == true){
				if(respawnCounter[i] >= 200){
					System.out.println("respawn method");
					Dummy dum = new Dummy(500, x, y, 35, 50);
					respawnCounter[i] = 0;
					removed[i] = false;
					int r = rand.nextInt(9);
					dum.spawn(coordinateX[r], coordinateY[r]);
					
					for(int y = 0; y < dummies.size(); y++){
						removeCounter[y] = 0;
					}
				}else{
					respawnCounter[i] += 1;
				}
			}else{
				removeCounter[i] += 1;
				System.out.println("remove counter for " + i + " - "+ removeCounter[i]);
			}
		}
	}
	
	public Dummy getDummy(){
		return dummy;
	}
	
}
