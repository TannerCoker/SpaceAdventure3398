//package SpaceAdventure3398;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
/*
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
*/
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.nio.*;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;

public class testScoreboard {

	private Scoreboard scoreboard = new Scoreboard();

	@Test
	@DisplayName("Update Score method")
	public void testUpdateScore()
	{
		scoreboard.updateCurrentScore(5);
		assertEquals( scoreboard.getCurrentScore(), 5);
		scoreboard.updateCurrentScore(105);
		assertEquals( scoreboard.getCurrentScore(), 110);
		scoreboard.updateCurrentScore(-1000);
		assertEquals( scoreboard.getCurrentScore(), 0);
	}

	@Test
	@DisplayName("get Score and Name at pos.")
	public void testScoreAt()
	{
		//assertThrows(IndexOutOfBoundsException.class, ()->{ scoreboard.getScoreAt(10) ; } );
		//assertThrows(IndexOutOfBoundsException.class, ()->{ scoreboard.getScoreAt(-1) ; } );
		assertEquals( scoreboard.getScoreAt(10), -1);
		assertEquals( scoreboard.getScoreAt(-1), -1);
		assertEquals( scoreboard.getNameAt(10), "");
		assertEquals( scoreboard.getNameAt(-1), "");
	}

	/*@Test
	@DisplayName("Save method")
	public void testSaveMethod()
	{
		long lastBestScore = scoreboard.getScoreAt(0);
		scoreboard.updateCurrentScore( lastBestScore + 10 );
		scoreboard.save("TestPlayer");

		assertEquals( scoreboard.getScoreAt(0), lastBestScore + 10 );
		assertEquals( scoreboard.getNameAt(0), "TestPlayer" );
		assertEquals( scoreboard.getScoreAt(1), lastBestScore );
		assertNotEquals( scoreboard.getScoreAt(0), lastBestScore );
		assertNotEquals( scoreboard.getScoreAt(1), "TestPlayer" );

		Scoreboard nextScoreboard = new Scoreboard(testFilePath);
		assertEquals( nextScoreboard.getScoreAt(0), lastBestScore + 10 );
		assertEquals( nextScoreboard.getNameAt(0), "TestPlayer" );
		assertEquals( nextScoreboard.getScoreAt(1), lastBestScore );
		assertNotEquals( nextScoreboard.getScoreAt(0), lastBestScore );
		assertNotEquals( nextScoreboard.getScoreAt(1), "TestPlayer" );
	}*/

}




