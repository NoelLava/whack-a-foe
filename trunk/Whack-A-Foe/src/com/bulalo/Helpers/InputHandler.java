package com.bulalo.Helpers;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.ShopScreen.ShopWorld;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	private static List<Dummy> dummies;
	private GameWorld myWorld;
	private CustomWorld customize;
	private Tables table;
	private Tables table1;
	private Tables table2;
	private ShopWorld shopWorld;
	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;
	
	float scaleFactorX;
	float scaleFactorY;
	

	public InputHandler(GameWorld myWorld, float scaleFactorX, float scaleFactorY){
		this.myWorld = myWorld;
		dummies = myWorld.getDummies();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	}

    public InputHandler(CustomWorld customize, float scaleFactorX, float scaleFactorY){
		this.customize = customize;
		table = customize.getTable();
		table1 = customize.getTable();
		table2 = customize.getTable();
		
    }
    
    public InputHandler(ShopWorld shopWorld, float scaleFactorX, float scaleFactorY){
    	this.shopWorld = shopWorld;
    	hammer = shopWorld.getHammer();
    	hammer1 = shopWorld.getHammer1();
    	hammer2 = shopWorld.getHammer2();
    	
    }
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
    	for(Dummy dummy:dummies){
    		dummy.isTouchDown(screenX, screenY);
    		dummy.displayResult();
    	}
//    	table.isTouchDown(screenX/2,screenY/2);
//    	table.displayResult();
//    	
//    	table1.isTouchDown1(screenX/2,screenY/2);
//    	table1.displayResult1();
//    	
//    	table2.isTouchDown2(screenX/2,screenY/2);
//    	table2.displayResult2();
    	
    	return true;
	}
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	screenX = scaleX(screenX);
		screenY = scaleY(screenY);
    	
        for(Dummy dummy:dummies){
        	if(dummy.isTouchUp(screenX, screenY)){
        	return true;
	        }
//	        if(table.isTouchUp(screenX/2, screenY/2)){
//	        	return true;
//	        }
	        dummy.displayResult();
	        //table.displayResult();
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
    
	public static List<Dummy> getDummies(){
		return dummies;
	}
	
}
