//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	
	public GameWorld(){
		dummy = new Dummy(500, 65, 110, 33, 48);
		
	}
	
	public void update(float delta){	
		dummy.update(delta);
	}
	
	public Dummy getDummy(){
		return dummy;
	}
	
}
