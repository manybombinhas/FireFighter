package pt.iul.poo.firefight.visuals;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Water implements ImageTile {

	private Point2D position;
	private Direction direction_of_jet;
	
	public Water(Direction d, Point2D position) {
		this.position = position;
		this.direction_of_jet = d;
	}
	
	
	@Override
	public String getName() { 
		if (direction_of_jet == Direction.DOWN) {
			return "water_down";
		}else if (direction_of_jet == Direction.LEFT) {
			return "water_left";
		}else if (direction_of_jet == Direction.RIGHT) {
			return "water_right";
		}else if (direction_of_jet == Direction.UP) {
			return "water_up";
		}else {
			return "water";
		}
		
	}

	@Override
	public Point2D getPosition() {
		return position;
	}
	
	public Direction getDirection() {
		return direction_of_jet;
	}

	@Override
	public int getLayer() {
		return 1;
	}
	
}
