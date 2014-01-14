package score;
import java.io.Serializable;

public class Winner implements Serializable, Comparable<Winner> {

	private static final long serialVersionUID = 1L;
	private String name;
	private int score;

	public Winner(String nev, int pont) {
		this.score = pont;
		this.name = nev;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public String getScoreAsString() {
		return Integer.toString(score);
	}

    @Override
    public int compareTo(Winner specifiedWinner) {
        int specifiedWinnersScore = specifiedWinner.getScore();
        
        if (specifiedWinnersScore < score) {
            return -1;
        } else if (specifiedWinnersScore > score) {
            return +1;
        } else {
            return 0;
        }
    }
}