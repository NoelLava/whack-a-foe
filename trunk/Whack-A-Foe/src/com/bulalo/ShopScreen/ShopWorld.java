package com.bulalo.ShopScreen;

import com.badlogic.gdx.math.Rectangle;
import com.bulalo.GameObjects.Hammers;

public class ShopWorld {
	
	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;
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
	
	public Hammers getHammer(){
		return hammer;
	}
	
	public Hammers getHammer1(){
		return hammer1;
	}
	
	public Hammers getHammer2(){
		return hammer2;
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
