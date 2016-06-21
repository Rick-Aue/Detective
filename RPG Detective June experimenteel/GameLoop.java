package rpgDetective;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLoop {
	
	//Creating run flags for while loops
    private boolean runFlag = false;
    private boolean winFlag = false;
    private boolean CharacterNameFlag = true;
	private boolean CharacterGenderFlag = true;
	private boolean GameTurn = true;
	
	//Set amount of turns game has
    private int turns = 25;
    
    //Set amount of questions, this number is also reset in the game loop
    //Random number generator experimental WIP, for now you got 8 questions.
    //Random rand = new Random();
	//int maxVragen = 8;
	//int vragen = rand.nextInt(1 + maxVragen);
    int MaxQuestions = 8;
    
    //Create input
	Scanner in = new Scanner (System.in);
	Scanner in2 = new Scanner (System.in);
	
	//Setting name, appearance and age for use in GameTurn loop
    String personName = "onbekend";
    String appearance = "onbekend";
    int age = 0;
	
	//Setting up switch
    int suspectChoice = 0;
    	
	//Create new detective
	Detective detective = new Detective();
	
	//Create new suspects
	Suspect[] suspect = new Suspect[5];
	
	Suspect suspect1 = new Suspect();
	Suspect suspect2 = new Suspect();
	Suspect suspect3 = new Suspect();
	Suspect suspect4 = new Suspect();
	Suspect suspect5 = new Suspect();
	
	//Create new rooms
	Room[] room = new Room[5];
	
	Room room1 = new Room();
	Room room2 = new Room();
	Room room3 = new Room();
	Room room4 = new Room();
	Room room5 = new Room();
	
	//Create new Answers	
	QuestionAnswer[] arrAnswersG = new QuestionAnswer[2];
	QuestionAnswer[] arrAnswers1 = new QuestionAnswer[2];
	QuestionAnswer[] arrAnswers2 = new QuestionAnswer[2];
	QuestionAnswer[] arrAnswers3 = new QuestionAnswer[2];
	
	//Create new Questions	
	QuestionAnswer[] arrQuestionG = new QuestionAnswer[2];
	QuestionAnswer[] arrQuestion1 = new QuestionAnswer[2];
	QuestionAnswer[] arrQuestion2 = new QuestionAnswer[2];
	
	//for testing gameturns
	int gameturn = 0;
	
	public void run()
    {
        runFlag = true;
         
        startup();
        while(runFlag)
        {   
        	
        	System.out.println("Inside main game loop gameturn = " + gameturn);
        	gameturn++;
        	       	        	
        	update();
        }
    }
 
    public void stop()
    {
        runFlag = false;
    }
    
    public void startup() {
    	System.out.println("Initialize game!");
    	createDetective();
    	createSuspect();
    	createQuestionAnswer();
    	createRoom();
    	
	}
    
    public void shutdown() {
    	System.out.println("Game stopped!");
    }
    
    public void createDetective() {
    	
    	//Detective is being setup
    	while(CharacterNameFlag)
        {        	
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\t Wat is je naam?");
			
			detective.setName(in.nextLine());
			
			if (detective.getName().equals("")){
				detective.setName("Naamloos");
				CharacterNameFlag = false;
			}
			else {
				CharacterNameFlag = false;
			}	    	 				
    		
			clearScreen();
			
			while(CharacterGenderFlag)
            {        
    			System.out.println("\n---------------------------------------------------");
    			System.out.println("\n\t" + detective.getName() + " wat is je geslacht?");
    			System.out.println("\t1. Man");
    			System.out.println("\t2. Vrouw");
    			
    			
    			String input = in.nextLine();
    			if(input.equals("1")){
    				detective.setGender("Man");
    				CharacterGenderFlag = false;
    			}
    			else if(input.equals("2")){
    				detective.setGender("Vrouw");
    				CharacterGenderFlag = false;
    			}
    			else {
    				
    			}
    		}	
    		
			clearScreen();
			
			//still have to put in exeption handler for int input2 = in2.nextInt(); when it is not an int
			while (detective.getPoints() > 0)	{
				
    			System.out.println("\n---------------------------------------------------");
    			System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
    			System.out.println("\tJe hebt nog " + detective.getPoints() + " punten over");
    			System.out.println("\tPower " + detective.getPower());
    			System.out.println("\tIntelligence " + detective.getIntelligence());
    			System.out.println("\tCharisma " + detective.getCharisma());
    			System.out.println("\n\tWaar wil je je punten verdelen?");
    			System.out.println("\t1. Power");
    			System.out.println("\t2. Intelligence");
    			System.out.println("\t3. Charisma");
    			System.out.println("\t4. Reset punten");
    			
    			String input = in.nextLine(); //zorgt voor input
    			
    			
    			if(input.equals("1")){
    				
    				try {
    					clearScreen();
            			System.out.println("\n---------------------------------------------------");
        				System.out.println("\n\tHoeveel punten in power?");
        				System.out.println("\n---------------------------------------------------");
        				System.out.println("\n");
        				int input2 = in2.nextInt(); //zorgt voor input
    					
    					if(input2 <= 100 && input2 >= 0 && detective.getPoints() >= 1){
    						detective.setPoints(detective.getPoints() - input2); 
    						detective.setPower(detective.getPower() + input2);
    					
    						if(detective.getPoints() < 0 || detective.getPower() < 0){
    							clearScreen();
    							detective.setPoints(detective.getPoints() + input2);
    							detective.setPower(detective.getPower() - input2);
    							System.out.println("\n---------------------------------------------------");
    							System.out.println("\n\tProbeer opnieuw");
    							System.out.println("\n---------------------------------------------------");
    							System.out.println("\n");
    						}
    					}
    				
    					else {
    						clearScreen();
    						System.out.println("\n---------------------------------------------------");
    						System.out.println("\n\tProbeer opnieuw");
    						System.out.println("\n---------------------------------------------------");
    						System.out.println("\n");
    					}  
    				}
    				catch (InputMismatchException ex) {
    					clearScreen();
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n\tVul een nummer in van 1-100.");
						System.out.println("\t" + in2.next() + " was niet een juiste invoer");
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n");
    				}
    			}
    			
    			else if(input.equals("2")){
    				
    				try {
    					clearScreen();
        				System.out.println("\n---------------------------------------------------");
        				System.out.println("\n\tHoeveel punten in intelligentie?");
        				System.out.println("\n---------------------------------------------------");
        				System.out.println("\n");
        				int input2 = in2.nextInt(); //zorgt voor input
    					
    					if(input2 <= 100 && input2 >= 0 && detective.getPoints() >= 1){
        					detective.setPoints(detective.getPoints() - input2);
        					detective.setIntelligence(detective.getIntelligence() + input2);
        					
        					if(detective.getPoints() < 0 || detective.getIntelligence() < 0){
        						clearScreen();
            					detective.setPoints(detective.getPoints() + input2);
            					detective.setIntelligence(detective.getIntelligence() - input2);
            					System.out.println("\n---------------------------------------------------");
            					System.out.println("\n\tProbeer opnieuw");
                				System.out.println("\n---------------------------------------------------");
                				System.out.println("\n");
        					}
        				}
        				
        				else {
        					clearScreen();
        					System.out.println("\n---------------------------------------------------");
        					System.out.println("\n\tProbeer opnieuw");
            				System.out.println("\n---------------------------------------------------");
            				System.out.println("\n");
            			}
    				}
    				catch (InputMismatchException ex) {
    					clearScreen();
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n\tVul een nummer in van 1-100.");
						System.out.println("\t" + in2.next() + " was niet een juiste invoer");
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n");
    				}
    			}
    			
    			else if(input.equals("3")){
    				
    				try {
    					clearScreen();
    					System.out.println("\n---------------------------------------------------");
        				System.out.println("\n\tHoeveel punten in Charisma?");
        				System.out.println("\n---------------------------------------------------");
        				System.out.println("\n");
        				int input2 = in2.nextInt(); //zorgt voor input
    					
        				if(input2 <= 100 && input2 >= 0 && detective.getPoints() >= 1){
        					clearScreen();
        					detective.setPoints(detective.getPoints() - input2);
        					detective.setCharisma(detective.getCharisma() + input2);
        					
        					if(detective.getPoints() < 0 || detective.getCharisma() < 0){
        						clearScreen();
            					detective.setPoints(detective.getPoints() + input2);
            					detective.setCharisma(detective.getCharisma() - input2);
            					System.out.println("\n---------------------------------------------------");
            					System.out.println("\n\tProbeer opnieuw");
                				System.out.println("\n---------------------------------------------------");
                				System.out.println("\n");
        					}
        				}
        				
        				else {
        					clearScreen();
        					System.out.println("\n---------------------------------------------------");
        					System.out.println("Probeer opnieuw");
            				System.out.println("\n---------------------------------------------------");
            				System.out.println("\n");
        					
            			}
    				}
    				catch (InputMismatchException ex) {
    					clearScreen();
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n\tVul een nummer in van 1-100.");
						System.out.println("\t" + in2.next() + " was niet een juiste invoer");
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n");
    				}
    			}
    			
    			else if(input.equals("4")){
    				
    				clearScreen();
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\tPunten zijn geherinitialiseerd!");
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n");
    				
    				detective.setPoints(100);
    				detective.setPower(0);
    				detective.setIntelligence(0);
					detective.setCharisma(0);
    			}
    			
    			else {
    				
    			}
    		}
			
			clearScreen();
    		
    		System.out.println("\n********************************************************");
    		System.out.println("\n\tWelkom detective " + detective.getName() + "!");
    		System.out.println("\n********************************************************");
    	}
    }
    
    public void createQuestionAnswer() {
    	
    	//Questions are created detective general
    	QuestionAnswer questionG_1 = new QuestionAnswer();
    	questionG_1.setText("Wat is je naam?");
    			
    	QuestionAnswer questionG_2 = new QuestionAnswer();
    	questionG_2.setText("Wat is je Leeftijd?");
    	
    	//Questions are created detective person 1
    	QuestionAnswer question1_1 = new QuestionAnswer();
    	question1_1.setText("Wie heb je gezien?");
    			
    	QuestionAnswer question1_2 = new QuestionAnswer();
    	question1_2.setText("Hoe zag hij eruit?");
    	
    	//Answers are created suspect general
    	QuestionAnswer answerG_1 = new QuestionAnswer();
    	answerG_1.setText("Ja");
    			
    	QuestionAnswer answerG_2 = new QuestionAnswer();
    	answerG_2.setText("Nee");
    	
    	//Answers are created suspect person 1
    	QuestionAnswer answer1_1 = new QuestionAnswer();
    	answer1_1.setText("Hij heeft een hoed");
    			
    	QuestionAnswer answer1_2 = new QuestionAnswer();
    	answer1_2.setText("Hij heeft een baard");
    	
    	//Answers are created suspect person 2
    	QuestionAnswer answer2_1 = new QuestionAnswer();
    	answer2_1.setText("Hij heeft een Snor");
    			
    	QuestionAnswer answer2_2 = new QuestionAnswer();
    	answer2_2.setText("Hij heeft kort haar");
    	
    	//Answers are created suspect person 3
    	QuestionAnswer answer3_1 = new QuestionAnswer();
    	answer2_1.setText("Hij heeft een Hanenkam");
    			
    	QuestionAnswer answer3_2 = new QuestionAnswer();
    	answer2_2.setText("Hij heeft lang haar");
    				
    	arrAnswersG[0] = answerG_1;
    	arrAnswersG[1] = answerG_2;
    	
    	arrAnswers1[0] = answer1_1;
    	arrAnswers1[1] = answer1_2;
    				
    	arrAnswers2[0] = answer2_1;
    	arrAnswers2[1] = answer2_2;
    			
    	arrAnswers3[0] = answer3_1;
    	arrAnswers3[1] = answer3_2;
   }
    
public void createRoom() {
    	
    	//Rooms are being setup
    	room1.setName("Huiskamer");
    	    				
    	room2.setName("Eetkamer");
    	   				
    	room3.setName("Slaapkamer");
    	   		
    	room4.setName("Badkamer");
    	
    	room5.setName("Zolder");
    	
    	room[0] = room1;
    	room[1] = room2;
    	room[2] = room3;
    	room[3] = room4;
    	room[4] = room5;
    }
    
    public void createSuspect() {
    	
    	//Suspects are being setup
    	suspect1.setName("Piet");
    	suspect1.setAge(32);
    	suspect1.setAppearance("Blond haar, Bruine ogen, licht getinte huid");
    	suspect1.setQuestionAnswer(arrAnswers1);
    	suspect1.setSuspectChoice(1);
    				
    	suspect2.setName("Klaas");
    	suspect2.setAge(25);
    	suspect2.setAppearance("Bruin haar, Bruine ogen, licht getinte huid");
    	suspect2.setQuestionAnswer(arrAnswers2);
    	suspect2.setSuspectChoice(2);
    				
    	suspect3.setName("Jan");
    	suspect3.setAge(27);
    	suspect3.setAppearance("Zwart haar, Groene ogen, donker getinte huid");
    	suspect3.setQuestionAnswer(arrAnswers3);
    	suspect3.setSuspectChoice(3);
    		
    	suspect4.setName("Tara");
    	suspect4.setAge(19);
    	suspect4.setAppearance("Zwart haar, Blauwe ogen, donker getinte huid");
    	suspect4.setQuestionAnswer(arrAnswers3);
    	suspect4.setSuspectChoice(4);
    		
    	suspect5.setName("Marie");
    	suspect5.setAge(41);
    	suspect5.setAppearance("Rood haar, Groene ogen, licht getinte huid");
    	suspect5.setQuestionAnswer(arrAnswers3);
    	suspect5.setSuspectChoice(5);
    	
    	suspect[0] = suspect1;
    	suspect[1] = suspect2;
    	suspect[2] = suspect3;
    	suspect[3] = suspect4;
    	suspect[4] = suspect5;
    }
    
    public void update() {
    	
    	System.out.println("Update the game state!");
    	gameTurn();
    	if(winFlag){
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\t> Je hebt gewonnen");
			System.out.println("\n---------------------------------------------------");
			stop();
		}
		else if(turns <= 0 && winFlag == false){
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\t> Game over!");
			System.out.println("\n---------------------------------------------------");
			stop();
			
		}
    	turns -= 1;
    }
    
   
    
    public void gameTurn() {	
    
    	//Reset while loop when it loops back through
    	GameTurn = true;
    	
    	//While loop for one game turn on what to do
    	while (GameTurn == true)	{
    		System.out.println("\n---------------------------------------------------");
    		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
    		System.out.println("\n\t" + "Power " + detective.getPower());
    		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
    		System.out.println("\t" + "Charisma " + detective.getCharisma());
    		System.out.println("\n---------------------------------------------------");
    	    System.out.println("\n\tBeurten = " + turns);
    		System.out.println("\n\tWat wil je doen?");
    		System.out.println("\t1. Verdachten ondervragen");
    		System.out.println("\t2. Kamers zoeken");
    		System.out.println("\t3. Aanwijzingen bekijken");
    		System.out.println("\t4. Verder gaan");
    		//Debug// System.out.println("\t voor for loop " + suspect[0].getNameKnown());
    		
    		String input = in.nextLine();
    		if(input.equals("1")){
    		
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
        		System.out.println("\n\t" + "Power " + detective.getPower());
        		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
        		System.out.println("\t" + "Charisma " + detective.getCharisma());
        		System.out.println("\n---------------------------------------------------");
        	    System.out.println("\n\tBeurten = " + turns);
        		System.out.println("\n\tWie wil je ondervragen?");
    		 	
        		//Goes through suspect array and prints
	        	for (int i = 0; i<suspect.length; i++){
	    			int x = i + 1;
	    			//Debug// System.out.println("\t tijdens for loop " + suspect[i].getNameKnown());
	    			
	    			if(suspect[i].getNameKnown() == false ){
	        			System.out.println("\t" + x + ". " + "onbekend");
	        		}
	        		else {
	        			System.out.println("\t" + x + ". " + suspect[i].getName());
	        		}
	    		}
	    		
	    					
	    		String input1 = in.nextLine();
	    		if(input1.equals("1")){
	    			suspectChoice = suspect[0].getSuspectChoice();
	    			
	    			questions();
	    			
	    			//Debug// System.out.println("\t Na input " + suspect[0].getNameKnown());	
	    		}
	    		else if(input1.equals("2")){
	    			suspectChoice = suspect[1].getSuspectChoice();
	    			
	    			questions();
	    			
	    			//Debug// System.out.println("\t Na input " + suspect[1].getNameKnown());	
	    		}
	    		else if(input1.equals("3")){
	    			suspectChoice = suspect[2].getSuspectChoice();
	    			
	    			questions();
	    			
	    			//Debug// System.out.println("\t Na input " + suspect[2].getNameKnown());
	    		}
	    		else if(input1.equals("4")){
	    			suspectChoice = suspect[3].getSuspectChoice();
	    			
	    			questions();
	    			
	    			//Debug// System.out.println("\t Na input " + suspect[3].getNameKnown());
	    		}
	    		else if(input1.equals("5")){
	    			suspectChoice = suspect[4].getSuspectChoice();
	    			
	    			questions();
	    			
	    			//Debug// System.out.println("\t Na input " + suspect[4].getNameKnown());
	    		}
	    		else {
	    				
	    		}	
    		}
    		
    		else if(input.equals("2")){
    			
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
        		System.out.println("\n\t" + "Power " + detective.getPower());
        		System.out.println("\n\t" + "Intelligence " + detective.getIntelligence());
        		System.out.println("\n\t" + "Charisma " + detective.getCharisma());
        		System.out.println("\n---------------------------------------------------");
        	    System.out.println("\n\tBeurten = " + turns);
        		System.out.println("\n\tIn welke kamer wil je zoeken?");
    			
    			//Goes through room array and prints
    			for (int i = 0; i<room.length; i++){
	    			int x = i + 1;
	    			//Debug// System.out.println("\t tijdens for loop " + suspect[i].getNameKnown());
	    				    			
	        		System.out.println("\t" + x + ". " + room[i].getName());
	        		
	    		}
    			
    			String input1 = in.nextLine();
	    		if(input1.equals("1")){
	    			
	    			room();
	    			
	    			
	    		}
	    		else if(input1.equals("2")){
	    			
	    			room();
	    			
	    				
	    		}
	    		else if(input1.equals("3")){
	    			
	    			room();
	    			
	    			
	    		}
	    		else if(input1.equals("4")){
	    			
	    			room();
	    			
	    			
	    		}
	    		else if(input1.equals("5")){
	    			
	    			room();
	    			
	    			
	    		}
	    		else {
	    				
	    		}	
    			
    		}
    		
    		else if(input.equals("3")){
    			clues();
    		}
    		
    		else if(input.equals("4")){
    			GameTurn = false;
    		}
    		
    		else {
				
    		}	
    		
    		GameTurn = false;
    	}
    	
    	
    }
    
    public void questions() {
    	
	 	MaxQuestions = 8; // reset questions
	 	
	 	//check if attributes of suspect are known
	 	switchCheck();
	 	
	 	while (MaxQuestions > 0)	{
    		
    		System.out.println("\n---------------------------------------------------");
    		System.out.println("\n\t# " + personName + " is aanwezig #\n");
    		System.out.println("---------------------------------------------------");
    		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
    		System.out.println("\t" + personName + " wil nog " + MaxQuestions + " vragen beantwoorden.");
    		System.out.println("\n\tLeeftijd = " + age );
    		System.out.println("\tUiterlijk = " + appearance);
    		System.out.println("\n\taanwijzingen gevonden = " + Clue.aanwijzingen);
    		System.out.println("\tBeurten = " + turns);
    		System.out.println("\n\tWat wil je vragen of doen?");
    		System.out.println("\t1. Wat is je Naam?" );
    		System.out.println("\t2. Wat is je Leeftijd");
    		System.out.println("\t3. Uiterlijk bekijken");
    		System.out.println("\t4. aanwijzingen bekijken");
    		System.out.println("\t5. Verder gaan");
    			
    		String input = in.nextLine();
    		
    		if(input.equals("1")){
    			switchName();
    			//TEST// QuestionAnswer Suspect1Answer = suspect1.getQuestionAnswer(1);
    			//TEST// System.out.println("Test " + Suspect1Answer.getText() + " Test");
    			
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t Mijn naam is " + personName);
        		System.out.println("\n---------------------------------------------------");
        		MaxQuestions -= 1;
    		}
    		
    		else if(input.equals("2")){
    			switchAge();
    			
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t Mijn leeftijd is " + age);
        		System.out.println("\n---------------------------------------------------");
    			MaxQuestions -= 1;
    		}
    		
    		else if(input.equals("3")){
    			switchAppearance();
    			
    			System.out.println("\n---------------------------------------------------");
    			System.out.println("\n\tDit persoon heeft " + appearance);
        		System.out.println("\n---------------------------------------------------");
    			
    		}
    		
    		else if(input.equals("4")){
    			clues();
    		}
    		
    		else if(input.equals("5")){
    			MaxQuestions = 0;
    		}
    		
    		else {
    						
    		}
    	}
  	}
    		/*
    		else if(input.equals("2")){
    			if(detective.getPower() > 30){
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Ik heb iets gevonden!");
    				Clue.aanwijzingen += 2;
    			}
    			else if(detective.getPower() > 10){
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Ik heb iets gevonden!");
    				Clue.aanwijzingen += 1;
    			}
    			else {
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Niets interessant.");
    			}
    		}
    		else if(input.equals("3")){
    			if(detective.getIntelligence() > 30 && Clue.aanwijzingen > 20){
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Ik ben 100% zeker dat dat persoon het heeft gedaan. ");
    				//GameLoop.winFlag = true;
    				vragen = 0;
    				turns = 0;
    			}
    			else if(detective.getIntelligence() > 20 && Clue.aanwijzingen > 40){
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Ik denk dat dat persoon het gedaan heeft. ");
    				//GameLoop.winFlag = true;
    				vragen = 0;
    				turns = 0;
    			}
    			else {
    				System.out.println("\n---------------------------------------------------");
    				System.out.println("\n\t> Ik ben onzeker wie het gedaan heeft.");
    				}
    			}
    			else if(input.equals("4")){
    				vragen = 0;
    				
    			}
    			else {
    				
    			}*/
    							
    public void room() {
    	
    }
    
    public void clues() {
    	
    }
    
    public void switchCheck() {
    	
    	//check if choice and name are chosen
    	if(suspectChoice == 1 && suspect[0].getNameKnown() == true){
	 		
    		personName = suspect[0].getName();
    	}
	 
    	else if(suspectChoice == 2 && suspect[1].getNameKnown() == true){
			
    		personName = suspect[1].getName();
    	}
	 
    	else if(suspectChoice == 3 && suspect[2].getNameKnown() == true){
			
    		personName = suspect[2].getName();
    	}
	 
    	else if(suspectChoice == 4 && suspect[3].getNameKnown() == true){
    		
    		personName = suspect[3].getName();
    	}
	 
    	else if(suspectChoice == 5 && suspect[4].getNameKnown() == true){
			
    		personName = suspect[4].getName();
    	}
    	else{
    		 personName = "onbekend";
    	     
    	}
	 
    	//check if choice and age are chosen
    	if(suspectChoice == 1 && suspect[0].getAgeKnown() == true){
 		
    		age = suspect[0].getAge();
 	 	
    	}
    	else if(suspectChoice == 2 && suspect[1].getAgeKnown() == true){
 	
    		age = suspect[1].getAge();
 	 	
    	}
    	else if(suspectChoice == 3 && suspect[2].getAgeKnown() == true){
     	
    		age = suspect[2].getAge();
          	
    	}
    	else if(suspectChoice == 4 && suspect[3].getAgeKnown() == true){
     	
    		age = suspect[3].getAge();
          
    	}
    	else if(suspectChoice == 5 && suspect[4].getAgeKnown() == true){
     	
    		age = suspect[4].getAge();
          
    	}
    	else{
    		age = 0;
    	}
    	
    	//check if choice and appearance are chosen
    	if(suspectChoice == 1 && suspect[0].getAppearanceKnown() == true){
    		
    		appearance = suspect[0].getAppearance();
    		
    	
    	}
    	else if(suspectChoice == 2 && suspect[1].getAppearanceKnown() == true){
    	
    		appearance = suspect[1].getAppearance();
    		
    	
    	}
    	else if(suspectChoice == 3 && suspect[2].getAppearanceKnown() == true){
        	
    		appearance = suspect[2].getAppearance();
    		 
        	
        }
    	else if(suspectChoice == 4 && suspect[3].getAppearanceKnown() == true){
        	
    		appearance = suspect[3].getAppearance();
    		
        
        }
    	else if(suspectChoice == 5 && suspect[4].getAppearanceKnown() == true){
        	
    		appearance = suspect[4].getAppearance();
    	       
        }
    	else{
    		appearance = "onbekend";
    	}
    	
    }
    
    public void switchName() {
    	
    	if(suspectChoice == 1){
		
    		personName = suspect[0].getName();
    		suspect[0].setNameKnown(true);
    	
    	}
    	else if(suspectChoice == 2){
    	
    		personName = suspect[1].getName();
    		suspect[1].setNameKnown(true);
    	
    	}
    	else if(suspectChoice == 3){
        	
        	personName = suspect[2].getName();
        	suspect[2].setNameKnown(true);
        	
        }
    	else if(suspectChoice == 4){
        	
        	personName = suspect[3].getName();
        	suspect[3].setNameKnown(true);
        
        }
    	else if(suspectChoice == 5){
        	
        	personName = suspect[4].getName();
        	suspect[4].setNameKnown(true);
        
        }
    	
    }
    
    public void switchAge() {
    	
    	if(suspectChoice == 1){
    		
    		age = suspect[0].getAge();
    		suspect[0].setAgeKnown(true);
    	
    	}
    	else if(suspectChoice == 2){
    	
    		age = suspect[1].getAge();
    		suspect[1].setAgeKnown(true);
    	
    	}
    	else if(suspectChoice == 3){
        	
        	age = suspect[2].getAge();
        	suspect[2].setAgeKnown(true);
        	
        }
    	else if(suspectChoice == 4){
        	
        	age = suspect[3].getAge();
        	suspect[3].setAgeKnown(true);
        
        }
    	else if(suspectChoice == 5){
        	
        	age = suspect[4].getAge();
        	suspect[4].setAgeKnown(true);
        
        }
    }
    
    public void switchAppearance() {
    	
    	if(suspectChoice == 1){
    		
    		appearance = suspect[0].getAppearance();
    		suspect[0].setAppearanceKnown(true); 
    	
    	}
    	else if(suspectChoice == 2){
    	
    		appearance = suspect[1].getAppearance();
    		suspect[1].setAppearanceKnown(true); 
    	
    	}
    	else if(suspectChoice == 3){
        	
    		appearance = suspect[2].getAppearance();
    		suspect[2].setAppearanceKnown(true); 
        	
        }
    	else if(suspectChoice == 4){
        	
    		appearance = suspect[3].getAppearance();
    		suspect[3].setAppearanceKnown(true); 
        
        }
    	else if(suspectChoice == 5){
        	
    		appearance = suspect[4].getAppearance();
    		suspect[4].setAppearanceKnown(true); 
        
        }
    	
    }
    
    public static void clearScreen() {  
    	for (int i = 0; i < 50; ++i) System.out.println(); //Temporary// console clear
       }  
    
}   	

