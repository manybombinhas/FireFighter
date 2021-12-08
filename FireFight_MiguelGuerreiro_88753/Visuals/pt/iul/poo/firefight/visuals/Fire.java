package pt.iul.poo.firefight.visuals;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.poo.firefight.starterpack.*;


//Esta classe de exemplo esta' definida de forma muito basica, sem relacoes de heranca
//Tem atributos e metodos repetidos em relacao ao que está definido noutras classes 
//Isso sera' de evitar na versao a serio do projeto

public class Fire implements ImageTile {

	public Point2D position;

	public Fire(Point2D position) {
		this.position = position;
	}
	
	public Point2D fire_position() {
		return position;
	}
	
	
	public boolean hasFire(Point2D ff_position, Direction d) { //checks if the direction from position has a fire
		int temp_vect_x = 	ff_position.getX() + d.asVector().getX();
		int temp_vect_y =	ff_position.getY() + d.asVector().getY();
		
//		for (int i = 0; i!=Burnable.Nbr_fogoss-1; i++){
//			int x_f = Burnable.asVector(i).getX();
//			int y_f = Burnable.asVector(i).getY();
//			if (x_f = temp_vect_x && y_f = temp_vect_y){
//				return true;
//			}else{ 
//				return false; 
//			}
//		}
		return true; // TEMPORARIO
	}
	
	@Override
	public String getName() {
		return "fire";
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return 1;
	}
}
