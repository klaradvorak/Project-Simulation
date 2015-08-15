package model;
import java.io.*;

public class fileWriting {
	public fileWriting(String Filename, String contentSent){

		try {

			String content = contentSent;

			File file = new File("configFile/animalData/"+Filename+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.close();

		//	System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
