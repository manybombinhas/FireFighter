package pt.iul.poo.firefight.starterpack;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.poo.firefight.visuals.Fire;

public class Bulldozer implements ImageTile {
	
	private Fireman ff;
	private Point2D position;
	private Direction direction_of_bull;
	
	public Bulldozer(Point2D position) {
		this.position = position;
	}
	
	public void move (Direction d) {
		
		Point2D nextP = getPosition().plus(d.asVector());
		Fire fire = new Fire(nextP);
		
		int x = nextP.getX();
		int y = nextP.getY();
		for(y=0; y!=9; y++) {
			for(x=0; x!=9; x++) {
				
//				if(fire.hasFire!=true){
					if(ImageMatrixGUI.getInstance().isWithinBounds(nextP)) {
					
						setPosition(nextP);
						ImageMatrixGUI.getInstance().update();
						
						
					}else {	
						return;
					}	
				}
//				else {
//					return;
//				}
//			}
		}
	}
	
	
	
	// Verifica se a posicao p esta' dentro da grelha de jogo
	public boolean canMoveTo(Point2D p) {
		
		if (p.getX() < 0) return false;
		if (p.getY() < 0) return false;
		if (p.getX() >= GameEngine.GRID_WIDTH) return false;
		if (p.getY() >= GameEngine.GRID_HEIGHT) return false;
		return true;
	}
	
	public void setPosition(Point2D position) {
		this.position = position;
	}

	// Metodos de ImageTile
	public String getName() { 
		if (direction_of_bull == Direction.DOWN) {
			return "bulldozer_down";
		}else if (direction_of_bull == Direction.LEFT) {
			return "bulldozer_left";
		}else if (direction_of_bull == Direction.RIGHT) {
			return "bulldozer_right";
		}else if (direction_of_bull == Direction.UP) {
			return "bulldozer_up";
		}else {
			return "bulldozer";
		}
		
	}

	public Point2D getPosition() {
		return position;
	}
	
	
	public int getLayer() {
//		if(ff.getPosition() == this.getPosition()) {
			return 4;
//		}
		
//		else {
//			return 2;
//		}
		
	}
}
