package pt.iul.poo.firefight.visuals;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;
//import pt.iul.poo.firefight.starterpack.Map;


public class Land /*extends Map*/ implements ImageTile {

	private Point2D position;

	public Land(Point2D position) {
//		super(position);
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "land";
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