package my.game.applet;

import java.util.Random;


public class GameOfLife {
	private Integer x_width;
	private Integer y_height;
	private Boolean [][] array;
	private Boolean [][] BufferArray;
	public GameOfLife(){
		this.x_width = 600;
		this.y_height = 600;
		this.array = createEmptyArray(x_width,y_height);
	}	
	
	public Integer getWidth(){
		return x_width;
	}
	
	public Integer getHeight(){
		return y_height;
	}
	
	public Integer getArraySize(){
		int counter = 0;
		for (int i = 0 ; i < x_width ; i++){
			for (int j = 0 ; j < y_height ; j++){
				counter++;
			}
		}
	return counter;
	}
	
	public Boolean [][] getArray(){
		return array;
	}
	
	public Boolean search_for_life(){
		for (int i = 0 ; i < 600 ; i++){
			for (int j = 0 ; j < 600 ; j++){
				if (array[i][j] == Boolean.TRUE) return true;
			}
		}
	return false;
	}
	
	public void CreateSingleLife_block(int width, int height){
		//Integer [] block_array = new Integer [] {0,0,0,1,1,0,1,1};
		for (int i = width ; i < width+2 ; i++){
			for (int j = height ; j < height+2 ; j++){
				array[i][j] = true;
			}
		}
	}
	public void CreateBigBlock(int width, int height){
		//Integer [] block_array = new Integer [] {0,0,0,1,1,0,1,1};
		for (int i = width ; i < width+100 ; i++){
			for (int j = height ; j < height+100 ; j++){
				array[i][j] = true;
			}
		}
	}
	public void CreateRandomAt(int width, int height){
	Random generator = new Random();	
		for (int i = width ; i<width+100 ; i++){
			for (int j = height; j < height+100; j++){
				array[i][j] = generator.nextBoolean();
			}
		}
	}
	
	public void CreateSingleLife(int width, int height){
		array[width][height] = true;
	}
	
	public void CreateGun(int width, int height){
		//width lewy gorny rog klocka
		CreateSingleLife(width, height);
		CreateSingleLife(width+1,height+1);
		CreateSingleLife(width+1,height);
		CreateSingleLife(width,height+1);
		
		CreateSingleLife(width,height+10);
		CreateSingleLife(width+1,height+10);
		CreateSingleLife(width+2,height+10);
		CreateSingleLife(width-1,height+11);
		CreateSingleLife(width+3,height+11);
		
		CreateSingleLife(width-2,height+12);
		CreateSingleLife(width-2,height+13);
		CreateSingleLife(width+4,height+12);
		CreateSingleLife(width+4,height+13);
		//srodeczek
		CreateSingleLife(width+1,height+14);
		CreateSingleLife(width-1,height+15);
		CreateSingleLife(width+3, height+15);
		
		CreateSingleLife(width,height+16);
		CreateSingleLife(width+1,height+16);
		CreateSingleLife(width+1,height+17);
		CreateSingleLife(width+2,height+16);
		
		CreateSingleLife(width,height+20);
		CreateSingleLife(width-1,height+20);
		CreateSingleLife(width-2,height+20);
		CreateSingleLife(width,height+21);
		CreateSingleLife(width-1, height+21);
		CreateSingleLife(width-2, height+21);
		
		CreateSingleLife(width+1,height+22);
		CreateSingleLife(width-3,height+22);
		CreateSingleLife(width+1,height+24);
		CreateSingleLife(width+2,height+24);
		CreateSingleLife(width-3,height+24);
		CreateSingleLife(width-4,height+24);
		
		CreateSingleLife(width-1,height+34);
		CreateSingleLife(width-1,height+35);
		CreateSingleLife(width-2,height+34);
		CreateSingleLife(width-2,height+35);
		
	}
	public void CreateDieHard(int width, int height){
		CreateSingleLife(width, height);
		CreateSingleLife(width, height+1);
		CreateSingleLife(width+1, height+1);
		CreateSingleLife(width+6, height-1);
		CreateSingleLife(width+5, height+1);
		CreateSingleLife(width+6, height+1);
		CreateSingleLife(width+7, height+1);
	}
	public Integer countNeighbours(int x, int y){
		Integer counter = 0 ;
		for (int i = x-1 ; i<x+2 ;i++ ){
			for (int j = y-1 ; j<y+2; j++){
				if (i==-1 || j==-1 || i==getHeight() || j==getWidth() ) continue;
				if (i==x && j==y) continue;
				else if (array[i][j] == Boolean.TRUE) counter++;
			}
		}
		return counter;
	}
	
	public Boolean Alive_WillTrueDie_or_WillFalseNotDie(int counter){
		if (counter==2 || counter==3) return Boolean.FALSE;
		else return Boolean.TRUE;
	}
	
	public Boolean ifDead_Will_comeAlive(int counter){
		if (counter==3) return Boolean.TRUE;
		else return Boolean.FALSE;
	}
	public void CreateFullSquare(){
		for (int i = 0; i < getWidth()-2; i++){
			for (int j = 0; j < getHeight()-2; j++){
				array[i][j] = true;
			}
		}
	}
	public void RandomMap(){
		Random generator = new Random();
		for (int i = 0; i < getWidth(); i++){
			for (int j = 0; j < getHeight(); j++){
				array[i][j] = generator.nextBoolean();
			}
		}
	}

 
	private static Boolean[][] createEmptyArray(int width, int height){
		Boolean[][] someArray = new Boolean [width][height];
		for(int x = 0;x<width; ++x){
			for(int y=0;y<height;++y){
					someArray[x][y] = Boolean.FALSE;
			}
		}
		return someArray;
	}
	
	private static Boolean[][] copyOfArray(Boolean[][] original, int width, int height){
		Boolean[][] copy = new Boolean[width][height];
		for(int x=0;x<width;++x){
			for(int y=0;y<height;++y){
				copy[x][y]=original[x][y];
			}
		}
		return copy;
	}

	private void MapTick(){
		array = BufferArray;
	}

	public void GameStart(){
		Integer counter = 0;
		/*array[400][400] = false;
		System.out.println(array[400][400]);
		*/
		BufferArray = copyOfArray(getArray(), getWidth(),getHeight());
		for (int i = 0 ; i < getWidth(); i++){
			for (int j = 0 ; j < getHeight();j++){
					counter = countNeighbours(i, j);
					if (getArray()[i][j] == Boolean.TRUE){
						if (Alive_WillTrueDie_or_WillFalseNotDie(counter)==Boolean.TRUE)
							BufferArray[i][j] = Boolean.FALSE;
						}
					else {
						if (ifDead_Will_comeAlive(counter)==Boolean.TRUE)
							BufferArray[i][j] = Boolean.TRUE;
						}
				}
		}
	MapTick();
	}

	public void DedicatedMap(){
		CreateSingleLife_block(200, 200);
		
		CreateSingleLife(203,203);
		
		CreateSingleLife(300, 300);
		CreateSingleLife(299, 299);
		CreateSingleLife(298, 299);
		CreateSingleLife(298, 300);
		CreateSingleLife(298, 301);
		CreateSingleLife(300, 300);
		CreateSingleLife(400, 400);
		
		CreateDieHard(100, 100);
		CreateDieHard(550, 550);
		CreateDieHard(450, 450);
		CreateDieHard(320,320);
		CreateDieHard(150, 150);
		CreateDieHard(1, 1);
		CreateDieHard(50, 50);
		
		CreateGun(130, 100); CreateBigBlock(400, 250);
		CreateGun(130, 150); CreateBigBlock(0,300); 
		CreateGun(130, 200);
		CreateGun(130, 250);
		
		CreateRandomAt(100,450);
		CreateRandomAt(500, 100);
		
	}
	public void DedicatedMap2(){
		CreateFullSquare();
	}
}
