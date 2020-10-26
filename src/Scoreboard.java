
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;




public class Scoreboard
{
	private int currentScore;
	private final int numberOfScores = 10; // only keeping top 10 scores
	private List<ScoreLine> topScores;

	static String fileSep = System.getProperty("file.separator");
	// FOr now, the file that stores the top scores is stored in the main directory
	private static String filePath = ".." + fileSep + "topScores.txt";


	private class ScoreLine implements Comparable<ScoreLine>
	{
		public long score;
		public String name;
		
		public ScoreLine(int s, String n)
		{	
			score = s;
			name = n;
		}

		@Override
		public  int compareTo(ScoreLine otherItem)
		{
			return (this.score > otherItem.score) ? -1 : (this.score < otherItem.score) ? 1 : 0;
		}
	}

	public static void main(String[] args)
	{
		Scoreboard s = new Scoreboard();
		System.out.println( s.show() );
		s.updateCurrentScore(12345);
		s.save("other");

		Scoreboard k = new Scoreboard();
	}

	/**
	 * The Scoreboard class uses a local file that keeps the top k scores 
	 * for all the players. k = 10 by default. A new session begins with a score of 0.
	 */
	public Scoreboard()
	{
		currentScore = 0;

		int n = 0;
		topScores = new ArrayList<ScoreLine>();
		try
		{
			Scanner readFile = new Scanner(new FileReader(filePath));
			while (readFile.hasNextLine() && n < numberOfScores ) 
			{
				String text = readFile.nextLine();
				String[] tokens = text.split("\\s+");
				if(tokens.length > 0)
				{
					topScores.add( new ScoreLine( Integer.parseInt(tokens[0]), tokens[1]) );
					++n;
				}
			}
			while ( n < numberOfScores ) 
			{
				topScores.add( new ScoreLine(0, "------") );
				++n;
			}
		
			readFile.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

	}

	public void updateCurrentScore(int points)
	{
		currentScore = currentScore + points;
		if (currentScore < 0) currentScore = 0;
	}

	public void save(String name)
	{
		Collections.sort(topScores); // sort the list just in case.
        long lowestScore = topScores.get(topScores.size() - 1).score; 
		if (currentScore > lowestScore)
		{
			// replace last item and sort list
	        topScores.set( topScores.size() - 1, new ScoreLine(currentScore, name) ); 
			Collections.sort(topScores);
		}
		
		try
		{
			//Save the contents of the file to a temp file.
			PrintWriter writeFile = new PrintWriter( filePath );
			for(ScoreLine s : topScores)
			{
				writeFile.print(s.score + "\t" + s.name + "\n");
			}
			writeFile.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}	

	public String show()
	{
		String list = "Scores\n--------\n";
		for(ScoreLine s : topScores)
		{
			list += s.score + "   " + s.name + "\n";
		}
		return list;
	}
}






