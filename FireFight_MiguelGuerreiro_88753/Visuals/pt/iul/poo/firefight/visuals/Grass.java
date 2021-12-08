package pt.iul.poo.firefight.visuals;


import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.poo.firefight.starterpack.GameEngine;
//import pt.iul.poo.firefight.starterpack.Map;

public class Grass /*extends Map*/ implements ImageTile {

	int burnt = 3;
	
	private Point2D position;

	public Grass(Point2D position) {
//		super(position);
		this.position = position;
	}
	
	public void Turns_Burnt(int i) {
//		if
	}
	
	@Override
	public String getName() {
		return "grass";
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return 0;
	}
	
}
