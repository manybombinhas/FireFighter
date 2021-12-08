package pt.iul.poo.firefight.starterpack;

import java.awt.geom.Point2D;

public class Turns {
	
	
	public static int turns_passed;
	
	public static int Turns_Passed_To_Become_Burnt(int counter) {
		
		int when_became_burnt=counter;
		int final_turns_passed_grass = counter+3;
//		int final_turns_passed_pine = counter+10;
//		int final_turns_passed_eucaliptus = counter+5;
		
		int i = turns_passed + when_became_burnt;
		
//		if(s.equals("grass")) {
			if (i == final_turns_passed_grass+1) {
				return 0;
			
			}else {
				turns_passed = i+turns_passed;
				return turns_passed;
			
			}
//		}else if(s.equals("eucaliptus")) {
//			
//			}
		}
	
	
	public static void main(String[] args) {
		

	}

}
