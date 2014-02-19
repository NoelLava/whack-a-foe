package com.bulalo.GameWorld;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	private Rectangle rect = new Rectangle(37, 96, 17, 25);

	public void update(float delta){
		System.out.println("GameWorld - update");
		rect.y-=5;
		if(rect.y == 71){
			rect.y = 96;
		}
	}
	
	public Rectangle getRect(){
		return rect;
	}
}
