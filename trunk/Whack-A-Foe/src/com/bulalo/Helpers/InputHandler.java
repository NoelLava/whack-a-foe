package com.bulalo.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameObjects.Tables1;
import com.bulalo.GameObjects.Tables2;
import com.bulalo.GameWorld.GameWorld;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	private GameWorld myWorld;
	private CustomWorld customize;
	private Tables table;
	private Tables1 table1;
	private Tables2 table2;
	

	public InputHandler(GameWorld myWorld){
		this.myWorld = myWorld;
		myDummy = myWorld.getDummy();
	}

    public InputHandler(CustomWorld customize){
		this.customize = customize;
		table = customize.getTable();
		table1 = customize.getTable1();
		table2 = customize.getTable2();
		
    }
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	//myDummy.isTouchDown(screenX/2,screenY/2);
    	//myDummy.displayResult();
    	table.isTouchDown(screenX/2,screenY/2);
    	table.displayResult();
    	
    	table1.isTouchDown1(screenX/2,screenY/2);
    	table1.displayResult1();
    	
    	table2.isTouchDown2(screenX/2,screenY/2);
    	table2.displayResult2();
    	
    	return true;
    
	}
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //if(myDummy.isTouchUp(screenX/2,screenY/2)){
        //	return true;
       // }
        if(table.isTouchUp(screenX/2, screenY/2)){
        	return true;
        }
        //myDummy.displayResult();
        table.displayResult();
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
	
}
