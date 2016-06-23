package rpgDetective;

import org.apache.log4j.Logger;


public class main {
	
	final static Logger logger = Logger.getLogger(main.class);
	
	public static void main(String[] args) {
		
		if(logger.isDebugEnabled()){
			logger.debug("Debug Message!");
		}
		if(logger.isInfoEnabled()){
			logger.info("Info Message!");
		}
		logger.warn("Warn Message!");
		logger.error("Error Message!");
		logger.fatal("Fatal Message!");
	      
		System.out.println("Main function!");
		
		GameLoop gameLoop = new GameLoop(); 
		gameLoop.run();
		
		
	}
}