package com.bulalo.ShopScreen;

import com.badlogic.gdx.math.Rectangle;

public class ShopWorld {
	private Rectangle rect = new Rectangle(0, 0, 17, 12);
	
	public void update(float delta) {
		System.out.println("ShopWorld - update");
		rect.x++;
		if (rect.x > 137) {
			rect.x = 0;
		}
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	
	
	
	
	
	/*private UpgradeDummy UpgradeDummy;
	
	public GameUpgradeWorld() {
		UpgradeDummy = new UpgradeDummy();
		
	}
	
	public void update(float delta){
		UpgradeDummy.update(delta);
	}
	
	public UpgradeDummy getDummy(){
		return UpgradeDummy;
	}*/

}
