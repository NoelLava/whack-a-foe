//This Class is the one responsible for updating the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.HammerPosition;
import com.bulalo.GameObjects.Timer;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Helpers.InputHandler;
import com.bulalo.UI.Button;

public class GameWorld {
	private Timer timer, dummyTimer, gameTimer;
	private Dummy dummy;

	// Game Counters
	// ===============================================================
	public static final float[] coordinateX = { 28f, 64.25f, 100f, 22.5f,
			64.25f, 105f, 19f, 64f, 109.25f };
	public static final float[] coordinateY = { 65f, 65f, 65f, 120f, 120f,
			120f, 175.5f, 175.5f, 175.5f };
	private boolean[] removed = { false, false, false, false, false, false,
			false, false, false };
	private int[] respawnCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] removeCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	// Dummies and Buttons
	// =========================================================
	private static List<Dummy> dummies;
	private static List<Button> gameButtons;
	Button pauseButton;

	private static List<Button> gameOverButtons;
	Button restartButton;
	Button mainMenuButton;

	private static List<Button> gamePausedButtons;
	Button resumeButton;
	Button pauseRestartButton;
	Button pauseMainButton;

	private static List<HammerPosition> hammerPosition;
	HammerPosition hammer;

	// Misc Variables
	// ==============================================================
	private float x, y;
	Random rand = new Random();
	float runTime = 0;

	private int score;
	private int millis = 60;
	public static int seconds = 60;
	private int readyCount = 3;
	private int ticketValue;
	private int timerCounter;

	private boolean buzzerPlayed;
	private boolean clearPlayed;
	public boolean gameStartPlayed;
	
	public boolean backToMain;
	public boolean ticketAdded;

	private GameState currentState;

	public enum GameState {
		READY, RUNNING, PAUSE, GAMEOVER
	}

	public GameWorld() {
		currentState = GameState.READY;

		// dummies
		// ===========================================================================================================================
		dummies = new ArrayList<Dummy>();

		// buttons
		// ===========================================================================================================================
		gameButtons = new ArrayList<Button>();
		pauseButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.pauseButton, AssetLoader.pausePressed);
		gameButtons.add(pauseButton);

		gameOverButtons = new ArrayList<Button>();
		restartButton = new Button(21.5f, 209.5f, 53.5f, 21,
				AssetLoader.restartUp, AssetLoader.restartDown);
		mainMenuButton = new Button(85, 209.5f, 53.5f, 21,
				AssetLoader.mainButtonUp, AssetLoader.mainButtonDown);
		gameOverButtons.add(restartButton);
		gameOverButtons.add(mainMenuButton);

		gamePausedButtons = new ArrayList<Button>();
		resumeButton = new Button(53, 99, 53.5f, 21, AssetLoader.resumeUp,
				AssetLoader.resumeDown);
		pauseRestartButton = new Button(53, 122, 53.5f, 21,
				AssetLoader.restartUp, AssetLoader.restartDown);
		pauseMainButton = new Button(53, 145, 53.5f, 21,
				AssetLoader.mainButtonUp, AssetLoader.mainButtonDown);
		gamePausedButtons.add(resumeButton);
		gamePausedButtons.add(pauseRestartButton);
		gamePausedButtons.add(pauseMainButton);

		// holes/hammer regions
		// ==============================================================================================================
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
		
		// timers
		timer = new Timer(1 / 1000);
		timer.start();

		dummyTimer = new Timer(1 / 7);
		dummyTimer.start();
	}

	public void update(float delta) {
		runTime += delta;
		checkTimer();

		switch (currentState) {
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
			updateRunning(delta);
			break;
		case PAUSE:
			updatePause(delta);
			break;
		case GAMEOVER:
			updateGameOver(delta);
			break;
		default:
			break;
		}
	}

	private void updateReady(float delta) {
		gameStartPlayed = false;
		buzzerPlayed = false;
		clearPlayed = false;

		if (readyCount <= 0) {
			startGame();
		}
	}

	private void updateRunning(float delta) {
		if (!AssetLoader.gameMusic2.isPlaying()) {
			AssetLoader.gameMusic2.play();
		}
		if (!AssetLoader.gameStart.isPlaying()) {
			if (gameStartPlayed) {
				AssetLoader.gameStart.stop();
			} else {
				AssetLoader.gameStart.play();
				gameStartPlayed = true;
			}
		}
		
		timerCounter = 1;
		
		if (seconds > 0) {
			inGame();
			updateGame();
			// checkHit();
			respawn();
			if (pauseButton.isJustPressed()) {
				currentState = GameState.PAUSE;
				pauseButton.setJustPressed(false);
			}
		} else {
			AssetLoader.gameMusic2.stop();
			for (Dummy dummy : dummies) {
				dummy.setLife(0);
			}
			currentState = GameState.GAMEOVER;
		}
	}

	private void updatePause(float delta) {
		AssetLoader.gameMusic2.pause();
		timerCounter = 0;
		
		if (pauseRestartButton.isJustPressed()) {
			restart();
			//currentState = GameState.GAMEOVER;
			pauseRestartButton.setJustPressed(false);
		} else if (resumeButton.isJustPressed()) {
			startGame();
			resumeButton.setJustPressed(false);
		} else if (pauseMainButton.isJustPressed()) {
			InputHandler.dummyPoints = 1;
			backToMain = true;
			seconds = 60;
		}
	}

	public void updateGameOver(float delta) {
		computeTickets();
		if (score > AssetLoader.getHighScore()) {
			AssetLoader.setHighScore(score);
		}
		
		if (!AssetLoader.buzzer.isPlaying()) {
			if (buzzerPlayed) {
				AssetLoader.buzzer.stop();
			} else {
				AssetLoader.buzzer.play();
				buzzerPlayed = true;
			}
		}
		if (!AssetLoader.gameOver.isPlaying()) {
			if (clearPlayed) {
				AssetLoader.gameOver.stop();
			} else {
				AssetLoader.gameOver.play();
				clearPlayed = true;
			}
		}

		if (restartButton.isJustPressed()) {
			restart();
			restartButton.setJustPressed(false);
		} else if (mainMenuButton.isJustPressed()) {
			InputHandler.dummyPoints = 1;
			backToMain = true;
			seconds = 60;
		}
	}

	public void startGame() {
		this.currentState = GameState.RUNNING;
	}

	public void readyGame() {
		this.currentState = GameState.READY;
	}

	public void restart() {
		InputHandler.dummyPoints = 1;
		AssetLoader.beep.play();
		score = 0;
		readyCount = 3;
		seconds = 60;

		readyGame();
	}

	public boolean isReady() {
		return currentState == GameState.READY;
	}

	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}

	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}

	public boolean isPaused() {
		return currentState == GameState.PAUSE;
	}

	public void computeTickets() {
		ticketValue = (int) (score / 4);
		int ticketVal = AssetLoader.getTicket() + ticketValue;

		if(!ticketAdded){
			AssetLoader.setTicket(ticketVal);
			ticketAdded = true;
		}			
	}

	// GAME METHODS
	// ======================================================================
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
				if (respawnCounter[i] >= 100) {
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

	public void checkTimer() {
		if (timer.hasCompleted()) {
			millis--;
			if (millis <= 0) {
				readyCount--;
				millis = 60;
				if (readyCount <= 0) {
					readyCount = 0;
					seconds -= timerCounter;

					if (seconds <= 0) {
						seconds = 0;
						millis = 0;
					}
					if (seconds <= 10 && seconds > 0) {
						AssetLoader.beep.play();
					}
				} else {
					AssetLoader.beep.play();
				}
			}
			timer.start();
		}
	}

	// Getters and Setters
	// ====================================================================================
	public int getScore() {
		return score;
	}

	public int getMilis() {
		return millis;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getReadyCount() {
		return readyCount;
	}

	public void addScore(int increment) {
		score += increment;
	}

	public void subtractScore(int decrement) {
		score -= decrement;
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

	public static List<Button> getGameOverButtons() {
		return gameOverButtons;
	}

	public static List<Button> getGamePausedButtons() {
		return gamePausedButtons;
	}

	public static void setSeconds(int seconds) {
		GameWorld.seconds = seconds;
	}

	public int getTicketValue() {
		return ticketValue;
	}

	public void setTicketValue(int ticketValue) {
		this.ticketValue = ticketValue;
	}

}
