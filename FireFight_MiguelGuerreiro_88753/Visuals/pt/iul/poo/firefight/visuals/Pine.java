package pt.iul.poo.firefight.visuals;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;
//import pt.iul.poo.firefight.starterpack.Map;

//Esta classe de exemplo esta' definida de forma muito basica, sem relacoes de heranca
//Tem atributos e metodos repetidos em relacao ao que está definido noutras classes 
//Isso sera' de evitar na versao a serio do projeto

public class Pine /*extends Map*/ implements ImageTile {

	private Point2D position;

	public Pine(Point2D position) {
//		super(position);
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "pine";
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
