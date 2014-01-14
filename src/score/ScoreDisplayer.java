package score;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreDisplayer {

    private JScrollPane scrollPane;
    private ArrayList<Winner> listOfGameWinners;

    public ScoreDisplayer(ArrayList<Winner> listOfGameWinners) {
        super();
        this.listOfGameWinners = listOfGameWinners;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void toplistafrissites() {

        Vector colnames = new Vector();
        colnames.add("Név");
        colnames.add("Pont");

        DefaultTableModel tablazatmodell = new DefaultTableModel(colnames, 0);
        JTable tablazat = new JTable(tablazatmodell);

        for (Winner i : listOfGameWinners) {
            String[] row = {i.getName(), i.getScoreAsString()};
            tablazatmodell.addRow(row);
        }

        scrollPane = new JScrollPane(tablazat);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}
