package score;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class FileWriter {
    
    private ArrayList<Winner> listOfWinners;
    
    public FileWriter(ArrayList<Winner> listOfWinners) {
        super();
        this.listOfWinners = listOfWinners;
    }

    public void write() {
        try {
            OutputStream file = new FileOutputStream("highscores.txt");

            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput out;
            out = new ObjectOutputStream(buffer);

            out.writeObject(listOfWinners);

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
/*    public static void main(String[] args) {
        ArrayList<Winner> listOfWinners = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfWinners.add(new Winner("", 0));
        }
        FileWriter writer = new FileWriter(listOfWinners);
        writer.write();
    }*/

}
