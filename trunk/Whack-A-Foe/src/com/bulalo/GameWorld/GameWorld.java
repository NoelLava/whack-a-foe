package com.bulalo.GameWorld;

import com.bulalo.GameObjects.Dummy;

public class GameWorld {
	private Dummy dummy;
	
	public GameWorld(){
		dummy = new Dummy(100, 115, 285, 60, 85);
	}

	public void update(float delta){
		dummy.update(delta);
	}
	
	public Dummy getDummy(){
		return dummy;		
	}
}
