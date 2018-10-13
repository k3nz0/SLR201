import java.io.*;


public class DataSerializer {
	public static void serialize(Philosopher data) {
		try {
			FileOutputStream fout = new FileOutputStream("hellodata.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);

			// Writing the serialized data
			out.writeObject(data) ;
			// Closing the output stream
			out.close();			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
