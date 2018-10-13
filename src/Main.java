



public class Main {
	
	public static void main(String[] args) {		
		int size = 5;
		Philosopher[] philosopher = new Philosopher[size];
		Fork[] fork = new Fork[size];
		for(int i = 0; i < size; i++) 
			fork[i] = new Fork(i);
		
		for(int i = 0; i < size; i++) {
			philosopher[i] = new Philosopher(i, fork[i], fork[(i + 1) % size]);		
		}

		for(int i = 0; i < size; i++) {
			philosopher[i].start();
		}
		// Puisqu'on peut pas serializer des threads, on passe par objet runnable doit être serializable.
		// On sauvegarde l'état initial (voir runnable)
		// On restaure l'état initial
		// On lance start
		
	}

}
