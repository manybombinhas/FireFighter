package pt.iul.poo.firefight.visuals;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;
//import pt.iul.poo.firefight.starterpack.Map;

public class Eucaliptus /*extends Map*/ implements ImageTile{

	

		private Point2D position;

		public Eucaliptus(Point2D position) {
			this.position = position;
//			super(position);
		}
		
		@Override
		public String getName() {
			return "eucaliptus";
		}

		@Override
		public Point2D getPosition() {
			return position;
		}

		@Override
		public int getLayer() {
			return 0;
		}
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	
	
	
}
