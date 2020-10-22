

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;




public class Scoreboard
{
	private int currentScore;
	private final int numberOfScores = 10; // only keeping top 10 scores
	//private final String topScoresFile;    // find separators using system calls
	private List<ScoreItem> topScores;

	private class ScoreItem implements Comparable<ScoreItem>
	{
		public int score;
		public String name;
		
		public ScoreItem(int s, String n)
		{	
			score = s;
			name = n;
		}

		@Override
		public  int compareTo(ScoreItem otherItem)
		{
			return (this.score < otherItem.score) ? -1 : (this.score > otherItem.score) ? 1 : 0;
		}
	}

	/**
	 * The Scoreboard class uses a local file
	 * that keeps the top 10 scores for all the
	 * players. A new session begins with a score
	 * of 0.
	 */
	public Scoreboard()
	{
		currentScore = 0;
		// open file
		topScores = new ArrayList<ScoreItem>();
		// add(): load from file into data structure
				
		//close file
	}

	public void updateCurrentScore(int points)
	{
		currentScore = currentScore + points;
		if (currentScore < 0) currentScore = 0;
	}

	public void save(String name)
	{
		Collections.sort(topScores); // sort the list just in case.
        int lowestScore = topScores.get(topScores.size() - 1).score; 
		if (currentScore > lowestScore)
		{
	        topScores.set( topScores.size() - 1, new ScoreItem(currentScore, name) ); 
			Collections.sort(topScores);
		}

		// open/save the file
		// clsoefile
	}
	

}




