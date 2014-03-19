//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.HammerPosition;
import com.bulalo.GameObjects.Timer;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class GameWorld {
	private Timer timer, dummyTimer, gameTimer;
	private Dummy dummy;
	private GameRenderer renderer;
	
	// Game Counters ===============================================================
	public static final float[] coordinateX = { 27f, 63.25f, 99f, 21f, 62.75f,
			103.5f, 17.75f, 62.75f, 108f };
	public static final float[] coordinateY = { 65f, 65f, 65f, 120f, 120f,
			120f, 175.5f, 175.5f, 175.5f };
	private boolean[] removed = { false, false, false, false, false, false,
			false, false, false };
	private int[] respawnCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] removeCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int escapeCounter = 0;

	// Dummies and Buttons =========================================================
	private static List<Dummy> dummies;
	private static List<Button> gameButtons;
	Button pauseButton;

	private static List<HammerPosition> hammerPosition;
	HammerPosition hammer;
	
	// Misc Variables ==============================================================
	private float x, y;
	Random rand = new Random();
	float runTime = 0;
	
	private int score;
	private int millis = 0;
	private int seconds = 60;
	private int readyCount = 3;
	
	private GameState currentState;
	public enum GameState {
		READY, RUNNING, GAMEOVER, HIGHSCORE
	}

	public GameWorld() {
		currentState = GameState.READY;
		
		// dummies ==========================================
		dummies = new ArrayList<Dummy>();

		// buttons ==========================================
		gameButtons = new ArrayList<Button>();
		pauseButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.pauseButton, AssetLoader.pausePressed);
		gameButtons.add(pauseButton);

		// holes/hammer regions =============================
		hammerPosition = new ArrayList<HammerPosition>(10);
		for (int ctr = 0; ctr < 10; ctr++) {
			if (ctr == 9) {
				hammer = new HammerPosition(coordinateX[7], 211.5f, 35, 50, ctr);
				hammerPosition.add(hammer);
			} else {
				hammer = new HammerPosition(coordinateX[ctr], coordinateY[ctr],
						35, 50, ctr);
				hammerPosition.add(hammer);
			}
		}		
		timer = new Timer(1/1000);
		timer.start();
		
		dummyTimer = new Timer(1/7);
		dummyTimer.start();
		
		gameTimer = new Timer(3);
		gameTimer.start();
	}
	

	public void update(float delta) {	
		runTime += delta;
	
		switch (currentState) {
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
			updateRunning(delta);
			break;
		default:
			break;
		}

	}

	private void updateRunning(float delta) {
		checkTimer();
		if(seconds > 0){
			inGame();
			updateGame();
			//checkHit();
			respawn();
		} else {
//			for(Dummy dummy : dummies){
//				dummies.remove(dummy);
//			}
			currentState = GameState.GAMEOVER;
			System.out.println("GAMEOVER!");
		}
		
		//System.out.println("array size - " + dummies.size());
	}

	private void updateReady(float delta) {
		if(gameTimer.hasCompleted()){
			startGame();
		}	
	}

	public void startGame() {
        currentState = GameState.RUNNING;
    }

    public void readyGame() {
        currentState = GameState.READY;
    }
    
    public void restart() {
		score = 0;
		seconds = 60;
		//bird.onRestart(midPointY - 5);
		//scroller.onRestart();
		readyGame();
	}
    
    public boolean isReady() {
        return currentState == GameState.READY;
    }

	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}
	
	public boolean isHighScore() {
	    return currentState == GameState.HIGHSCORE;
	}

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }
    
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
    
	
	//GAME METHODS ======================================================================
	// adds multiple dummies in the arraylist
	public void inGame() {
		// dummies = new ArrayList<Dummy>();
		if (dummies.size() != 0) {
			System.out.println("dummies list is full");
		} else {
			System.out.println("dummies list is null");
			for (int ctr = 0; ctr < 1; ctr++) {
				int r = rand.nextInt(9);
				dummy = new Dummy(300, x, y, 35, 50);
				dummy.spawn(coordinateX[r], coordinateY[r]);
				dummies.add(dummy);
			}
		}

	}

	public void updateCheck() {
		if (!dummy.isAlive()) {
			dummies.remove(dummy);
	
			dummy = null;
			int r = rand.nextInt(9);
			dummy = new Dummy(300, x, y, 35, 50);
			dummy.spawn(coordinateX[r], coordinateY[r]);
			dummies.add(dummy);
		}
	}

	public void updateGame() {
		int i = 0;
		while (i < dummies.size()) {
			Dummy dum = dummies.get(i);
			checkToRemove();
			if (dum.isMarked()) {
				System.out.println("mark " + i);
				dum.markToRemove();
				removed[i] = true;
				dum.isNotMarked();
			} else {
				i++;
			}
		}
	}

	// this method checks if a dummy should be removed
	public void checkToRemove() {
		for (int i = 0; i < dummies.size(); i++) {
			Dummy dum = dummies.get(i);
			if (dum.isAlive()) {
				System.out.println("checkToRemove - alive");
			} else {
				System.out.println("should remove " + i);
				dummies.remove(i);
				removed[i] = true;
				// dum.isNotMarked();
				removeCounter[i] = 0;
				escapeCounter += 1;
				for (int x = 0; x < dummies.size(); x++) {
					removeCounter[x] = 0;
				}
			}
		}
	}

	public void checkHit() {
		for (int i = 0; i < dummies.size(); i++) {
			Dummy dum = dummies.get(i);
			if (!dum.isAlive()) {
				for (int x = 0; x < dummies.size(); x++) {
					removeCounter[i] = 0;
					
				}
			}
		}
	}

	public void respawn() {
		for (int i = 0; i < 9; i++) {

			if (removed[i] == true) {
				if (respawnCounter[i] >= 200) {
					System.out.println("respawn method");
					Dummy dum = new Dummy(300, x, y, 35, 50);
					int r = rand.nextInt(9);
					dum.spawn(coordinateX[r], coordinateY[r]);
					dummies.add(dum);

					respawnCounter[i] = 0;
					removed[i] = false;
					for (int y = 0; y < dummies.size(); y++) {
						removeCounter[y] = 0;
					}
				} else {
					respawnCounter[i] += 1;
					System.out.println("respawn counter for " + i + " - "
							+ respawnCounter[i]);
				}
			} else {
				removeCounter[i] += 1;
				System.out.println("remove counter for " + i + " - "
						+ removeCounter[i]);
			}
		}
	}
	
	public void checkTimer(){
		if(timer.hasCompleted()){
			millis++;
			if(millis >= 60){
				seconds--;
				readyCount--;
				millis = 0;
			}
			timer.start();
		}
	}
	
	
	// Getters and Setters ====================================================================================
	public int getScore() {
		return score;
	}
	
	public int getMilis(){
		return millis;
	}
	
	public int getSeconds(){
		return seconds;
	}
	
	public int getReadyCount(){
		return readyCount;
	}

	public void addScore(int increment) {
		score += increment;
	}

	public static List<Dummy> getDummies() {
		return dummies;
	}

	public static List<Button> getGameButtons() {
		return gameButtons;
	}

	public static List<HammerPosition> getHammerAngles() {
		return hammerPosition;
	}
	
}
