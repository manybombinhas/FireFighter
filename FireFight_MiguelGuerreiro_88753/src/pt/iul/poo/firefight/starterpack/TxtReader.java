package pt.iul.poo.firefight.starterpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class TxtReader {

	static final int ME = 10; //ME = Map Ends on the Txt
	static String path = new String("/Users/migue/Desktop/ISCTE/21-22/POO_2021-2022/Proj_POO_21-22/FireFight_MiguelGuerreiro_88753/levels/example.txt");
	//falta path para o file 'example.txt', aka o mapa
	
	
	@SuppressWarnings("resource")
	public static char[] Map_line_i(int line_asked) throws FileNotFoundException { 						//Map_Line_i -> String de chars da linha x, começa em 0
	
		File file = new File(path);
		Scanner scan = new Scanner(file);
		
		char[] line_i = new char [ME];
		String[] s = new String[ME];
		
		skipLines(scan,line_asked);
		s[0] = scan.next();
		
		for(int i=0; i!=ME; i++) {
			
			line_i [i] = s[0].charAt(i) ;
		}
		
		return line_i;
	}
	
	
	public static Vector<Integer> FireFighterInicialPosition() throws FileNotFoundException {  	//FireFighterInicialPosition() -> returns ff_coord(x,y)
		
		Vector<Integer> ff_coord = new Vector<Integer>();
		String[] s = new String[2];
		
		File file = new File(path);
		Scanner scan = new Scanner(file);
		skipLines(scan,ME);
		
		scan.next();
		s[0] = scan.next(); 
		s[1] = scan.next();
		
		ff_coord.addElement(Integer.parseInt(s[0])-1);
		ff_coord.addElement(Integer.parseInt(s[1])-1);		 					
		return ff_coord;
	}
	
	public static Vector<Integer> BulldozerInicialPosition() throws FileNotFoundException {	//BulldozerInicialPosition() -> returns bull_coord(x,y)
		
		Vector<Integer> bull_coord = new Vector<Integer>();
		String[] s = new String[2];
	
		File file = new File(path);
		Scanner scan = new Scanner(file);
		skipLines(scan,ME+1);
		
		scan.next();
		s[0] = scan.next(); 
		s[1] = scan.next();
		
		bull_coord.addElement(Integer.parseInt(s[0])-1);
		bull_coord.addElement(Integer.parseInt(s[1])-1);		 					
		return bull_coord;				
		
	}
	
	public static Vector<Integer> FiresInicialPosition(int fire_line) throws FileNotFoundException { // FiresInicialPosition() -> returns vector fire_coord(x,y) for each one
	
		int line_in_txt = (ME+2)+(fire_line-1);
		
		Vector<Integer> n_fire_coord = new Vector<Integer>();
		String[] s = new String[2];
		
		File file = new File(path);
		Scanner scan = new Scanner(file);
		skipLines(scan,line_in_txt);							
		
		scan.next();
		s[0] = scan.next(); 
		s[1] = scan.next();
		
		n_fire_coord.addElement(Integer.parseInt(s[0])-1);
		n_fire_coord.addElement(Integer.parseInt(s[1])-1);	
		
		
		return n_fire_coord;
	}
	
	
	public static int Nbr_inicial_Fires() throws FileNotFoundException {
		
		int nbr_f=0;
		
		File file = new File(path);
		Scanner scan = new Scanner(file);
		skipLines(scan,ME+2);
		
			while(scan.hasNextLine()) {
				nbr_f++;
				scan.nextLine();
			}
		
		return nbr_f;
	}
	
	private static void skipLines(Scanner s,int lineNum){
        for(int i = 0; i < lineNum;i++){
            if(s.hasNextLine()) s.nextLine();
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException {			//Class main
		
		Map_line_i(1);
		
	}
}
