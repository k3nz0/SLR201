
public class Fork {
//	private boolean[] usedFork;
	private boolean usedFork;
	private Philosopher currentUser;
	private int index;
	
	public Fork(int index) {
		usedFork = false;
		currentUser = null;
		this.index = index;
	}
	
	public synchronized boolean useFork(Philosopher p) {
		try {
			while(true) {
				if(usedFork == true) {
					System.out.println("[WAITING] " + p.getIndex() + " is trying to use fork " + index +
							" but Philosopher " + currentUser.getIndex() + " is using it !");
					wait();
				}
					
				else {
					usedFork = true;
					this.currentUser = p;
					System.out.println("Philosopher " + currentUser.getIndex() + " starts using fork " + index);
					notifyAll();
					return true;
				}
			}
		}
		catch(Exception e) { e.printStackTrace(); }
		return false;
	}
	
	
	// do we need to synchronize this ? 
	public synchronized void releaseFork(Philosopher p) {
		if(usedFork == true) {
			this.currentUser = null;
			usedFork = false;
			notifyAll();
		}
	}
	
	public Philosopher getCurrentUser() {
		return currentUser;
	}
	
	
	public int getIndex() {
		return index;
	}
	

}
