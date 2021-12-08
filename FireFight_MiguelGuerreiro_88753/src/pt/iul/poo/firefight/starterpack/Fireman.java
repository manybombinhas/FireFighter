package pt.iul.poo.firefight.starterpack;

import pt.iul.poo.firefight.visuals.*;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;


public class Fireman implements ImageTile{
	
	static public int turn_counter = 0;
	
	private Point2D position;

	public Fireman(Point2D position) {
		this.position = position;
	}
	
	public void move (Direction d) {
		
		System.out.println(GameEngine.counter);
		
		
		Point2D nextP = getPosition().plus(d.asVector());
		Fire fire = new Fire(nextP);
		
		int x = nextP.getX();
		int y = nextP.getY();
//		System.out.println(GameEngine.counter);
		for(y=0; y!=9; y++) {
			for(x=0; x!=9; x++) {
				
				if(ImageMatrixGUI.getInstance().isWithinBounds(nextP) /*&& if(!fire.hasFire){*/) {
					
					setPosition(nextP);
					ImageMatrixGUI.getInstance().update();
					
//				}else if(fire.hasFire) {
//					Water water = new Water(d,nextP);
//					ImageMatrixGUI.getInstance().update();
				}else {
					return;
				}
			}
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
	@Override
	public String getName() {
		return "fireman";
	}

	@Override
	public Point2D getPosition() {
		return position;
	}
	
	@Override
	public int getLayer() {
		return 3;
	}
}

// Move numa direcao aleatoria 
//public void moveUp() {
//	
//	boolean hasMoved = false;
//	
//	while (hasMoved == false)  {
//	
//		Direction nextDir = Direction.directionFor(KeyEvent.VK_UP);
//		Point2D newPosition = position.plus(nextDir.UP);
//		
//		if (canMoveTo(newPosition) ) {
//			setPosition(newPosition);
//			hasMoved = true;
//		}
//	}
//}

