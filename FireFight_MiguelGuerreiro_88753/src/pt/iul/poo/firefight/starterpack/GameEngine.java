package pt.iul.poo.firefight.starterpack;
// Note que esta classe e' um exemplo - nao pretende ser o inicio do projeto, 
// embora tambem possa ser usada para isso.
//
// No seu projeto e' suposto haver metodos diferentes.
// 
// As coisas que comuns com o projeto, e que se pretendem ilustrar aqui, sao:
// - GameEngine implementa Observer - para  ter o metodo update(...)  
// - Configurar a janela do interface grafico (GUI):
//        + definir as dimensoes
//        + registar o objeto GameEngine ativo como observador da GUI
//        + lancar a GUI
// - O metodo update(...) e' invocado automaticamente sempre que se carrega numa tecla
//
// Tudo o mais podera' ser diferente!
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


public class GameEngine implements Observer {
	
	// Dimensoes da grelha de jogo
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	public static int counter=1;
	public static int turns;
	private ImageMatrixGUI gui;  		// Referencia para ImageMatrixGUI (janela de interface com o utilizador) 
	private List<ImageTile> tileList;	// Lista de imagens
	private Fireman fireman;			// Referencia para o bombeiro
	private Bulldozer bulldozer;
	
	// Neste exemplo o setup inicial da janela que faz a interface com o utilizador e' feito no construtor 
	public GameEngine() {
		 
		gui = ImageMatrixGUI.getInstance();    // 1. obter instancia ativa de ImageMatrixGUI	
		gui.setSize(GRID_HEIGHT, GRID_WIDTH);  // 2. configurar as dimensoes 
		gui.registerObserver(this);            // 3. registar o objeto ativo GameEngine como observador da GUI
		gui.go();                              // 4. lancar a GUI
		
		tileList = new ArrayList<>();   
	}
	
//	 	O metodo update() e' invocado sempre que o utilizador carrega numa tecla
// 		no argumento do metodo e' passada um referencia para o objeto observado (neste caso seria a GUI)
//	@Override
//	public void update(Observed source) {
   
	
	@Override
	public void update(Observed source) {

		int keyPressed = ImageMatrixGUI.getInstance().keyPressed();
		Direction d = Direction.directionFor(keyPressed);
		
			fireman.move(d);
			if (fireman.getPosition() == bulldozer.getPosition()) {
				bulldozer.move(d);
			}
			counter++;
			turns = Turns.Turns_Passed_To_Become_Burnt(counter);
		ImageMatrixGUI.getInstance().update();  // redesenha as imagens na GUI, tendo em conta as novas posicoes
			gui.update();                       
	}
		
	
	// Criacao dos objetos e envio das imagens para GUI
	public void start() throws FileNotFoundException {
		createTerrain();      // criar mapa do terreno
		createFireman();
		createBulldozer();
		createFire();
		sendImagesToGUI();
	}
	// Terrain, reads the txt
	public void createTerrain() throws FileNotFoundException {
				
//		Map.create_Map();
		for (int y=0; y<GRID_HEIGHT; y++) {
			
			char[] map_line = TxtReader.Map_line_i(y);
			
			for (int x=0; x<GRID_HEIGHT; x++) {
				  if(map_line[x] == '_') {
						tileList.add(new Land(new Point2D(x,y)));
				} if(map_line[x] == 'm') {
						tileList.add(new Grass(new Point2D(x,y)));
				} if(map_line[x] == 'e') {
						tileList.add(new Eucaliptus(new Point2D(x,y)));
				} if(map_line[x] == 'p') {
						tileList.add(new Pine(new Point2D(x,y)));
				}
			}
		}		
	}
	
	//Bulldozer
	
	private void createBulldozer() throws FileNotFoundException{
		
		bulldozer = new Bulldozer(new Point2D(TxtReader.BulldozerInicialPosition().get(0),TxtReader.BulldozerInicialPosition().get(1)));
		tileList.add(bulldozer);
	}
	
	// Fireman
	private void createFireman() throws FileNotFoundException {
		
		fireman = new Fireman(new Point2D(TxtReader.FireFighterInicialPosition().get(0),TxtReader.FireFighterInicialPosition().get(1)));
		tileList.add(fireman);
		
	}
		
	// Creates all inicial Fires
	private void createFire() throws FileNotFoundException {
		
		for(int i=1; i!=TxtReader.Nbr_inicial_Fires()+1; i++) {
			tileList.add(new Fire(new Point2D(TxtReader.FiresInicialPosition(i).get(0),TxtReader.FiresInicialPosition(i).get(1))));
		}
	}
	
//	public boolean hasFire() {
//		for (Map m : tileList) {
//			if (m instanceof Fire) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public Fire getFireAt(Point2D point) {
//		for (GameElement e : tileList) {
//			if (e instanceof Fire && e.getPosition().equals(point)) {
//				return (Fire) e;
//			}
//		}
//		return null;
//	}
	
	
	// Envio das mensagens para a GUI - note que isto so' precisa de ser feito no inicio
	// Nao e' suposto re-enviar os objetos se a unica coisa que muda sao as posicoes  
	private void sendImagesToGUI() {
		gui.addImages(tileList);
	}
	
	public static void main(String[] args) throws FileNotFoundException {			//Class main
		
		
		GameEngine game = new GameEngine();
		game.start();
//		Burnable.Nbr_fogos();
		
	}
	
}
