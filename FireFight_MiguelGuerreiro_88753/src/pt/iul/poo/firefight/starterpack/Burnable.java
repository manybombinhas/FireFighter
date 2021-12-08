package pt.iul.poo.firefight.starterpack;

import java.util.Vector;
import pt.iul.poo.firefight.visuals.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.observer.Observed;
import pt.iul.ista.poo.observer.Observer;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.poo.firefight.visuals.Grass;


public class Burnable {
	
	private static List<ImageTile> tileList;
	
	
	
	public static int [][] Where_is_Fire () { //guarda as coord de todos os fogos
		
		int i = 0;
		int max_num_fire = 100;
		
		int [][] s = new int [max_num_fire][3];
		
		for (int map_y=0; map_y!=GameEngine.GRID_HEIGHT-1; map_y++) {
			for (int map_x=0; map_y!=GameEngine.GRID_WIDTH-1; map_x++) {		
				if (tileList.contains("fire")){  //erro porque não vê na layer dos Fogos
		
					s[i][0] = 1;
					s[i][1] = map_x;
					s[i][2] = map_y;
					i++;
					
				}else {
					s[i][0] = 0;
				}
				
			}
		}
		return s;
	}

	
	public static int Nbr_fogos() {	

		int [][] auxil = Where_is_Fire();
		int counter=0;
		
		for (int i=0; i!=99; i++) {
			if(auxil[i][0] == 0) {
				break;
			}else {
				counter++;
			}
		}
		return counter;
	}
	
	public static void /*boolean*/ isBurnable(Point2D coord_testar){
		coord_testar.getNeighbourhoodPoints();
		
		
	}
	
	public static void /*int*/ TurnsPlay_perFire(){ //vai para cada planta
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
