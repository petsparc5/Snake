package score;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class FileReader {
    private ArrayList<Winner> listOFWinners = new ArrayList<>();
    
    public FileReader() {
        super();
        this.readSerialisedList();
    }
    
    private void readSerialisedList() {
        try {
            InputStream file = new FileInputStream("highscores.txt");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput in;
            in = new ObjectInputStream(buffer);

            listOFWinners = (ArrayList<Winner>) in.readObject();

            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Winner> getListOfWinners() {
        return listOFWinners;
    }
}