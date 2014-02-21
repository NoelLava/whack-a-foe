//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.Random;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	
	public GameWorld(){
		Random randX = new Random();
		Random randY = new Random();
		int x,y;
		int[] coordinateX = {30,65,100} ;
		int[] coordinateY = {83,128,180};		
		x = randX.nextInt(2) + 1;
		y = randY.nextInt(2) + 1;
		
		dummy = new Dummy(500, x, y, 33, 48);
		dummy.spawn(coordinateX[x], coordinateY[y]);
		
	}
	
	public void update(float delta){	
		dummy.update(delta);
	}
	
	public Dummy getDummy(){
		return dummy;
	}
	
}
