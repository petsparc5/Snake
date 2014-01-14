package listerner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ScoreUpdateListener implements ActionListener {

    private ArrayList<String> holder;
    private JTextField newWinner;
    private JFrame frame;

    public ScoreUpdateListener(JTextField newWinner, JFrame frame) {
        super();
        this.newWinner = newWinner;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (holder) {
            holder.add(newWinner.getText());
            holder.notify();
        }
        frame.dispose();
    }

    public ArrayList<String> getHolder() {
        return holder;
    }

    public void setHolder(ArrayList<String> holder) {
        this.holder = holder;
    }

}
