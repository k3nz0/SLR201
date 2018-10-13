

import java.io.*;

public class DataUnserializer {
	public static Philosopher unserialize() {
		Philosopher data = null;
		try {
			FileInputStream fin = new FileInputStream("hellodata.ser");
			ObjectInputStream in = new ObjectInputStream(fin);

			// Writing the serialized data
			data = (Philosopher) in.readObject() ;
			// Closing the output stream
			in.close();
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return data;
	}
}
