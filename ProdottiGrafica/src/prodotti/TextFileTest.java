package prodotti;

import java.io.IOException;

public class TextFileTest {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		TextFile out = new TextFile("file.txt", 'W');
		try {
			out.toFile("Riga 1");
			out.toFile("Riga 2");
			out.toFile("Riga 3");
		} catch(FileException exception) {
			System.out.println(exception.getMatter());
		}
		out.closeFile();
		
		TextFile in = new TextFile("file.txt", 'R');
		String line;
		try {
			while(true) {
				line = in.fromFile();
				System.out.println(line);
			}
		} catch(FileException exception) {
			System.out.println(exception.getMatter());
		}
		in.closeFile();
		
	}

}
