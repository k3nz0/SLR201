
import java.io.PrintStream;
import java.util.Random;

public class Philosopher extends Thread {

	private String state; 
	private int index;
	private Fork leftFork;
	private Fork rightFork;
	private PrintStream out;
	private int nbEating;
	
	/*
		• En train de réfléchir.
		• Affamé.
		• En train de manger.
	*/
	
	
	public Philosopher(int index, Fork leftFork, Fork rightFork) {
		this.state = new String("Reflechir");
		this.index = index;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.out = System.out;
		this.nbEating = 0;
	}
	
	
	public void useLeftFork() {
		this.leftFork.useFork(this);
	}

	public void useRightFork() {
		this.rightFork.useFork(this);
	}
	
	public void releaseLeftFork() {
		this.leftFork.releaseFork(this);
	}
	
	public void releaseRightFork() {
		this.rightFork.releaseFork(this);
	}


	public void think(){
		int timeThinking = new Random().nextInt(1000);
		setState("thinking");
		try {
			Thread.sleep(timeThinking);
			this.out.println("Philosopher : " + this.index + " has finished thinking");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void eat(){
		int timeEating = new Random().nextInt(5000);
		setState("eating");
		try {
			Thread.sleep(timeEating);
			this.out.println("Philosopher : " + this.index + " has finished eating");
			this.releaseLeftFork();
			this.releaseRightFork();
			nbEating++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void starve(){
		setState("starving");
		this.out.println("Philosopher : " + this.index + " has started starving");
		this.useLeftFork();
		this.useRightFork();
	}
	
	
	public void run() {
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis()-startTime<10000L){
			this.think();
			this.starve();
			this.eat();
		}
	}
	
	
	public void setPosition(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setState(String _state) {
		state = _state;
	}
	
	public String getStatePhilo() {
		return state;
	}
	
	public int getNbEating() {
		return nbEating;
	}
}
