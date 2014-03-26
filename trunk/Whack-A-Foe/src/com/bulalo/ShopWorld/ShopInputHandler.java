package com.bulalo.ShopWorld;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Upgrades;
import com.bulalo.UI.Button;

public class ShopInputHandler implements InputProcessor {
	private ShopWorld shopWorld;
	
	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;
	
	private static boolean hammerTrue;
	private static boolean hammer1True;
	private static boolean hammer2True;
	
	private static List<Button> shopButtons;

	float scaleFactorX;
	float scaleFactorY;
	
	public ShopInputHandler(ShopWorld shopWorld, float scaleFactorX,
		float scaleFactorY) {
		this.shopWorld = shopWorld;
		
		shopButtons = ShopWorld.getShopButtons();
		
		hammer = shopWorld.getHammer();
		hammer1 = shopWorld.getHammer1();
		hammer2 = shopWorld.getHammer2();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	}
	
	public ShopInputHandler(){
		System.out.println("initialized");
	
	}
	
	public boolean checkHammer(){
		return hammerTrue;
	
	}
	
	public boolean checkHammer1(){
		return hammer1True;
		
	}
	
	public boolean checkHammer2(){
		return hammer2True;
		
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		if(hammer.isTouchDown(screenX, screenY)){
			hammerTrue = true;
			System.out.println("hammer touched");

		}else if(hammer1.isTouchDown(screenX, screenY)){
			hammer1True = true;
			System.out.println("hammer1 touched");
		
		}else if(hammer2.isTouchDown(screenX, screenY)){
			hammer2True = true;
			System.out.println("hammer2 touched");
		}
		
		for (Button thisButton : shopButtons) {
			thisButton.isTouchDown(screenX, screenY);
		}
			
    	return false;
    	
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
        screenY = scaleY(screenY);
    	
        if(hammer.isTouchUp(screenX, screenY)){
        	return true;
        }
        
        if(hammer1.isTouchUp(screenX, screenY)){
        	return true;
        	
        }
        
        if(hammer2.isTouchUp(screenX, screenY)){
        	return true;
        }
        
        
        for(Button thisButton : shopButtons){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
        
    	return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}
	
	private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }
    
    public boolean falseCheck(){
    	return hammerTrue = false;
    
    }
    
    public boolean falseCheck1(){
    	return hammer1True = false;
    
    }
    
    public boolean falseCheck2(){
    	return hammer2True = false;
    
    }


}
