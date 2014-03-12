package com.bulalo.Helpers;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameWorld.GameWorld;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	private static List<Dummy> dummies;
	private GameWorld myWorld;
	private CustomWorld customize;
	private Tables table;
	private Tables table1;
	private Tables table2;
	

	public InputHandler(GameWorld myWorld){
		this.myWorld = myWorld;
		dummies = myWorld.getDummies();
	}

    public InputHandler(CustomWorld customize){
		this.customize = customize;
		table = customize.getTable();
		table1 = customize.getTable();
		table2 = customize.getTable();
		
    }
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	for(Dummy dummy:dummies){
    		dummy.isTouchDown(screenX/2,screenY/2);
    		dummy.displayResult();
<<<<<<< HEAD
    	}*/
    	table.isTouchDown(screenX/2,screenY/2);
    	table.displayResult();
    	
    	table1.isTouchDown(screenX/2,screenY/2);
    	table1.displayResult();
    	
    	table2.isTouchDown(screenX/2,screenY/2);
    	table2.displayResult();
=======
    	}
//    	table.isTouchDown(screenX/2,screenY/2);
//    	table.displayResult();
//    	
//    	table1.isTouchDown1(screenX/2,screenY/2);
//    	table1.displayResult1();
//    	
//    	table2.isTouchDown2(screenX/2,screenY/2);
//    	table2.displayResult2();
>>>>>>> bac9c1b009c398e52d6057a9d9496b71e26aade3
    	
    	return true;
	}
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for(Dummy dummy:dummies){
        	if(dummy.isTouchUp(screenX/2,screenY/2)){
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
    
	public static List<Dummy> getDummies(){
		return dummies;
	}
	
}
