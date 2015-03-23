package my.game.applet;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsageTesting {
	
	@Test
	public void DefaultConstructor() {
		GameOfLife test = new GameOfLife();
		Integer x = 600;
		Integer y = test.getWidth();
		assertEquals("Expected 600", x , y);
	}
	@Test
	public void DefaultConstructor_array_size(){
		GameOfLife test1 = new GameOfLife();
		Integer x = 360000;
		Integer y =  test1.getArraySize();
		assertEquals("Expected 360000", x , y);
	
	}
	@Test
	public void CreateSingle_block(){
		GameOfLife test2 = new  GameOfLife();
		Boolean if_exist = false;
		test2.CreateSingleLife_block(333, 333);
		if_exist = test2.search_for_life();
		assertEquals("Expected Life to exist", true, if_exist);
		
	}
	@Test
	public void CreateSingle_block_at_xy(){
		GameOfLife test3 = new  GameOfLife();
		Boolean if_exist = false;
		test3.CreateSingleLife_block(300, 300);
			if (test3.getArray()[300][300]) if_exist = true;
			else if_exist = false;
			if (test3.getArray()[300][301]) if_exist = true;
			else if_exist = false;
			if (test3.getArray()[301][300]) if_exist = true;
			else if_exist = false;
			if (test3.getArray()[301][301]) if_exist = true;
			else if_exist = false;
			
		assertEquals("Expected 300-301 xy filled", true, if_exist);
		
	}
	@Test
	public void CreateSingleLife(){
		GameOfLife test4 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_exist;
		test4.CreateSingleLife(400, 400);
		if (test4.getArray()[x][y]) if_exist = true;
		else if_exist = false;
		assertEquals("Expected 400-400 xy filled", true, if_exist);
	}
	@Test
	public void Single_without_Friends_WillNotSurvive(){
		GameOfLife test5 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_Die;
		test5.CreateSingleLife(400, 400);
		Integer counter = test5.countNeighbours(x, y);
		if_Die = test5.Alive_WillTrueDie_or_WillFalseNotDie(counter);
		assertEquals("Should Die",true, if_Die);
	}
	@Test
	public void Single_with_Friend_WillNotSurvive(){
		GameOfLife test5 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_Die;
		test5.CreateSingleLife(400, 400);
		test5.CreateSingleLife(400, 401);
		Integer counter = test5.countNeighbours(x, y);
		if_Die = test5.Alive_WillTrueDie_or_WillFalseNotDie(counter);
		assertEquals("Should Die",true, if_Die);
	}
	@Test
	public void TwoWillSurvive(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_Die;
		test6.CreateSingleLife(400, 400);
		test6.CreateSingleLife(401, 400);
		test6.CreateSingleLife(401, 401);
		Integer counter = test6.countNeighbours(x, y);
		if_Die = test6.Alive_WillTrueDie_or_WillFalseNotDie(counter);
		assertEquals("Should Die",false, if_Die);
	}
	@Test
	public void ThreeWillSurvive(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_Die;
		test6.CreateSingleLife(400, 400);
		test6.CreateSingleLife(401, 400);
		test6.CreateSingleLife(401, 401);
		test6.CreateSingleLife(400, 401);
		Integer counter = test6.countNeighbours(x, y);
		if_Die = test6.Alive_WillTrueDie_or_WillFalseNotDie(counter);
		assertEquals("Should Die",false, if_Die);
	}
	@Test
	public void MoreThanThreeWillDie(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		Boolean if_Die;
		test6.CreateSingleLife(400, 400);
		test6.CreateSingleLife(401, 400);
		test6.CreateSingleLife(401, 401);
		test6.CreateSingleLife(399, 401);
		test6.CreateSingleLife(399, 400);
		Integer counter = test6.countNeighbours(x, y);
		if_Die = test6.Alive_WillTrueDie_or_WillFalseNotDie(counter);
		assertEquals("Should Die",true, if_Die);
	}
	@Test
	public void Single_dead_will_alive(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		test6.CreateSingleLife(400, 401);
		test6.CreateSingleLife(401, 400);
		test6.CreateSingleLife(401, 401);
		Integer counter = test6.countNeighbours(x, y);
		assertEquals("Should ressurect", true, test6.ifDead_Will_comeAlive(counter));
	}
	@Test
	public void countingNeighbours(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		test6.CreateSingleLife(400, 401);
		test6.CreateSingleLife(400, 399);
		
		test6.CreateSingleLife(401, 399);
		test6.CreateSingleLife(401, 400);
		test6.CreateSingleLife(401, 401);
		
		test6.CreateSingleLife(399, 401);
		test6.CreateSingleLife(399, 400);
		test6.CreateSingleLife(399, 399);
		Integer test = 8;
		Integer counter = test6.countNeighbours(x, y);
		assertEquals(test,counter);
		
	}
	@Test
	public void countingNeighbours_when_theres_no(){
		GameOfLife test6 = new  GameOfLife();
		int x,y;
		x=y=400;
		Integer test = 0;
		Integer counter = test6.countNeighbours(x, y);
		assertEquals(test,counter);
	}
	
}

