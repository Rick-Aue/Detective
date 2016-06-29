package rpgDetective;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLoop {
	
	//Creating run flags for while loops
    private boolean runFlag = false;
    private boolean winFlag = false;
    private boolean detectiveNameFlag = true;
	private boolean detectiveGenderFlag = true;
	private boolean gameTurn = true;
		
	//Set amount of turns game has
    private int turns = 25;
    
    //Create amount of questions, this is used to reset one of the game loops
    //Random number generator experimental WIP, for now you got 8 questions.
    //Random rand = new Random();
	//int maxVragen = 8;
	//int vragen = rand.nextInt(1 + maxVragen);
    Question MaxQuestionsAmount = new Question();
    
    //Create input
	Scanner in = new Scanner (System.in);
	Scanner in2 = new Scanner (System.in);
	
	//Setting name, appearance and age for use in GameTurn loop
	Answer suspectName = new Answer();
	Answer suspectAge = new Answer();
	Answer suspectAppearance = new Answer();
       
   	//Setting up switch
    int suspectChoice = 0;
    int roomChoice = 0;
    	
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
    	createRoom();
    	
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

	public void shutdown() {
    	System.out.println("Game stopped!");
    }
    
    public void createDetective() {
    	
    	//Questions are created detective general
    	Question questionG_1 = new Question();
    	questionG_1.setText("Wat is je naam?");
    			
    	Question questionG_2 = new Question();
    	questionG_2.setText("Wat is je Leeftijd?");
    	
    	Question questionG_3 = new Question();
    	questionG_3.setText("Uiterlijk bekijken van verdachte.");
    	
    	//Questions are created detective
    	Question question1_1 = new Question();
    	question1_1.setText("Is dit test 1?");
    			
    	Question question1_2 = new Question();
    	question1_2.setText("Is dit test 2?");
    	
    	Question question1_3 = new Question();
    	question1_3.setText("Notebook bekijken"); //Must be at second last place in array
    	
    	Question question1_4 = new Question();
    	question1_4.setText("Einde beurt"); //Must be at last place in array
    	
    	
    	
    	//ArrayDetectiveQuestions
    	Question[] arrQuestions = new Question[7];
    	arrQuestions[0] = questionG_1;
    	arrQuestions[1] = questionG_2;
    	arrQuestions[2] = questionG_3;
    	arrQuestions[3] = question1_1;
    	arrQuestions[4] = question1_2;
    	arrQuestions[5] = question1_3;
    	arrQuestions[6] = question1_4;
    	
    	
    	//Detective questions are being linked to detective
    	detective.setQuestion(arrQuestions);
    	    	
    	//Detective is being setup
    	while(detectiveNameFlag)
        {        	
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\t Wat is je naam?");
			
			detective.setName(in.nextLine());
			
			if (detective.getName().equals("")){
				detective.setName("Naamloos");
				detectiveNameFlag = false;
			}
			else {
				detectiveNameFlag = false;
			}	    	 				
    		
			clearScreen();
			
			while(detectiveGenderFlag)
            {        
    			System.out.println("\n---------------------------------------------------");
    			System.out.println("\n\t" + detective.getName() + " wat is je geslacht?");
    			System.out.println("\t1. Man");
    			System.out.println("\t2. Vrouw");
    			
    			
    			String input = in.nextLine();
    			if(input.equals("1")){
    				detective.setGender("Man");
    				detectiveGenderFlag = false;
    			}
    			else if(input.equals("2")){
    				detective.setGender("Vrouw");
    				detectiveGenderFlag = false;
    			}
    			else{
    				clearScreen();
    			}
    		}	
    		
			clearScreen();
			
			while (detective.getPoints() > 0)	{
				/*
				 * Power is for searching around in rooms
				 * Intelligence is for getting more different questions
				 * Charisma is for seeing if they are speaking the truth or not
				 */
				
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
    							tryAgain();
    						}
    					}
    				
    					else {
    						clearScreen();
    						tryAgain();
    					}  
    				}
    				catch (InputMismatchException ex) {
    					clearScreen();
						System.out.println("\n---------------------------------------------------");
						System.out.println("\n\tVul een heel nummer in van 1-100.");
						System.out.println("\t" + in2.next() + " was niet een juiste invoer.");
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
            					tryAgain();
        					}
        				}
        				
        				else {
        					clearScreen();
        					tryAgain();
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
            					tryAgain();
        					}
        				}
        				
        				else {
        					clearScreen();
        					tryAgain();
        					
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
    			else{
    				clearScreen();
    			}
    		}
			
			clearScreen();
    		
    		System.out.println("\n********************************************************");
    		System.out.println("\n\tWelkom detective " + detective.getName() + "!");
    		System.out.println("\n********************************************************");
    	}
    }
    
    public void createSuspect() {
    	    	
    	//Suspect answers
    	Answer answers1 = new Answer();
    	answers1.setText("Mijn naam is ");
    			
    	Answer answers2 = new Answer();
    	answers2.setText("Mijn leeftijd is ");
    	
    	Answer answers3 = new Answer();
    	answers3.setText("Dit persoon heeft ");
    	
    	Answer answers4 = new Answer();
    	answers4.setText("test 1");
    	
    	Answer answers5 = new Answer();
    	answers5.setText("test 2");
    				
    	Answer[] arrAnswers1 = new Answer[5];
    	arrAnswers1[0] = answers1;
    	arrAnswers1[1] = answers2;
    	arrAnswers1[2] = answers3;
    	arrAnswers1[3] = answers4;
    	arrAnswers1[4] = answers5;
    				
    	Answer[] arrAnswers2 = new Answer[5];
    	arrAnswers2[0] = answers1;
    	arrAnswers2[1] = answers2;
    	arrAnswers2[2] = answers3;
    	arrAnswers2[3] = answers4;
    	arrAnswers2[4] = answers5;
    				
    			
    	Answer[] arrAnswers3 = new Answer[5];
    	arrAnswers3[0] = answers1;
    	arrAnswers3[1] = answers2;
    	arrAnswers3[2] = answers3;
    	arrAnswers3[3] = answers4;
    	arrAnswers3[4] = answers5;
    				
    	
    	Answer[] arrAnswers4 = new Answer[5];
    	arrAnswers4[0] = answers1;
    	arrAnswers4[1] = answers2;
    	arrAnswers4[2] = answers3;
    	arrAnswers4[3] = answers4;
    	arrAnswers4[4] = answers5;
    				
    	
    	Answer[] arrAnswers5 = new Answer[5];
    	arrAnswers5[0] = answers1;
    	arrAnswers5[1] = answers2;
    	arrAnswers5[2] = answers3;
    	arrAnswers5[3] = answers4;
    	arrAnswers5[4] = answers5;
    				
    	
    	//Suspects are being setup
    	suspect1.setName("Piet");
    	suspect1.setAge("32");
    	suspect1.setAppearance("Blond haar, Bruine ogen, licht getinte huid");
    	suspect1.setSuspectChoice(1);
    	suspect1.setAnswer(arrAnswers1);
    	    	
    	suspect2.setName("Klaas");
    	suspect2.setAge("25");
    	suspect2.setAppearance("Bruin haar, Bruine ogen, licht getinte huid");
    	suspect2.setSuspectChoice(2);
    	suspect2.setAnswer(arrAnswers2);
    				
    	suspect3.setName("Jan");
    	suspect3.setAge("27");
    	suspect3.setAppearance("Zwart haar, Groene ogen, donker getinte huid");
    	suspect3.setSuspectChoice(3);
    	suspect3.setAnswer(arrAnswers3);
    		
    	suspect4.setName("Tara");
    	suspect4.setAge("19");
    	suspect4.setAppearance("Zwart haar, Blauwe ogen, donker getinte huid");
    	suspect4.setSuspectChoice(4);
    	suspect4.setAnswer(arrAnswers4);
    		
    	suspect5.setName("Marie");
    	suspect5.setAge("41");
    	suspect5.setAppearance("Rood haar, Groene ogen, licht getinte huid");
    	suspect5.setSuspectChoice(5);
    	suspect5.setAnswer(arrAnswers5);
    	
    	suspect[0] = suspect1;
    	suspect[1] = suspect2;
    	suspect[2] = suspect3;
    	suspect[3] = suspect4;
    	suspect[4] = suspect5;
    }
    
    public void createRoom() {
    	
    	room1.setName("Huiskamer");
    	room1.setRoomChoice(1);
    	
    	room2.setName("Eetkamer");
    	room2.setRoomChoice(2);
    	
    	room3.setName("Slaapkamer");
    	room3.setRoomChoice(3);
    	
    	room4.setName("Badkamer");
    	room4.setRoomChoice(4);
    	
    	room5.setName("Zolder");
    	room5.setRoomChoice(5);
    	
    	room[0] = room1;
    	room[1] = room2;
    	room[2] = room3;
    	room[3] = room4;
    	room[4] = room5;
    }
    
    public void gameTurn() {	
    
    	//Reset while loop when it loops back through
    	gameTurn = true;
    	
    	//While loop for one game turn on what to do
    	while (gameTurn == true)	{
    		
    		System.out.println("\n---------------------------------------------------");
    		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
    		System.out.println("\n\t" + "Power " + detective.getPower());
    		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
    		System.out.println("\t" + "Charisma " + detective.getCharisma());
    		System.out.println("\n\tBeurten = " + turns);
    		System.out.println("\n\tWat wil je doen?");
    		System.out.println("\t1. Verdachten ondervragen");
    		System.out.println("\t2. Kamers doorzoeken");
    		System.out.println("\t3. Aanwijzingen bekijken");
    		    		
    		String input = in.nextLine();
    		if(input.equals("1")){
    			
    			clearScreen();
    			suspectChoice();
    		}
    		
    		else if(input.equals("2")){
    			
    			clearScreen();
    			roomChoice();
    		}
    		
    		else if(input.equals("3")){
    			
    			clearScreen();
    			clues();
    			gameturn--;
    			turns++;
    		}
    		
    		else {
    			clearScreen();
    			tryAgain();
    			gameTurn();
    		}
    		
    		
    		gameTurn = false;
    	}
    	
    	
    }
    
    public void suspectChoice() {  
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
		System.out.println("\n\t" + "Power " + detective.getPower());
		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
		System.out.println("\t" + "Charisma " + detective.getCharisma());
		System.out.println("\n\tBeurten = " + turns);
		System.out.println("\n\tWie wil je ondervragen? ");
	 	
		//Goes through suspect array and prints
		for (int i = 0; i<suspect.length; i++){
			int x = i + 1;
				    			
			if(suspect[i].getNameKnown() == false ){
				System.out.println("\t" + x + ". " + "onbekend");
			}
			else {
				System.out.println("\t" + x + ". " + suspect[i].getName());
			}
		}
		
		try {
			int input2 = in2.nextInt(); //zorgt voor input
			    			    	    				
				suspectChoice = suspect[input2 - 1].getSuspectChoice();
	    		clearScreen();
	    		questionsAnswers();
				
		}
		catch (ArrayIndexOutOfBoundsException e) {
	       
	        clearScreen();
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\tProbeer opnieuw.");
			//System.out.println("\tArray is out of Bounds "+e);
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n");
			gameTurn();
	     }
		catch (InputMismatchException ex) {
			clearScreen();
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\tProbeer opnieuw.");
			System.out.println("\t" + in2.next() + " was niet een juiste invoer "+ex);
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n");
			gameTurn();
		}
		
	 }

	public void roomChoice() {  
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
		System.out.println("\n\t" + "Power " + detective.getPower());
		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
		System.out.println("\t" + "Charisma " + detective.getCharisma());
		System.out.println("\n\tBeurten = " + turns);
		System.out.println("\n\tWaar wil je zoeken? ");
	 	
		//Goes through suspect array and prints
		for (int i = 0; i<room.length; i++){
			int x = i + 1;
				    			
			System.out.println("\t" + x + ". " + room[i].getName());
		}
		
		try {
			int input2 = in2.nextInt(); //zorgt voor input
			    			    	    				
				roomChoice = room[input2 - 1].getRoomChoice();
	    		clearScreen();
	    		roomSearch();
	    		
				
		}
		catch (ArrayIndexOutOfBoundsException e) {
	       
	        clearScreen();
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\tProbeer opnieuw.");
			//System.out.println("\tArray is out of Bounds "+e);
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n");
			gameTurn();
	     }
		catch (InputMismatchException ex) {
			clearScreen();
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\tProbeer opnieuw.");
			System.out.println("\t" + in2.next() + " was niet een juiste invoer "+ex);
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n");
			gameTurn();
		}
		
	 }

	public void clues() {
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t# NOTEBOOK #\n");
		System.out.println("---------------------------------------------------");
		
		for (int i = 0; i<suspect.length; i++){
			int x = i+1;
			
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\tVerdachte nummer "+ x);
				if(suspect[i].getNameKnown() == true){
					System.out.println("\n\tNaam = " + suspect[i].getName());
		       	}
			   	else{
			   		System.out.println("\n\tNaam = onbekend");
			  	}
				if(suspect[i].getAgeKnown() == true){
					System.out.println("\tLeeftijd = " + suspect[i].getAge());
		    	}
			   	else{
					System.out.println("\tLeeftijd = onbekend");
			   	}
				if(suspect[i].getAppearanceKnown() == true){
					System.out.println("\tUiterlijk = " + suspect[i].getAppearance());
		    	}
			  	else{
					System.out.println("\tUiterlijk = onbekend");
		    	}
		}
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\tDruk op enter om verder te gaan.");
		
		String input = in.nextLine();
		if(input.equals("")){
			clearScreen();
		}
		else{
			clearScreen();
			clues();
		}
	}

	public void questionsAnswers() {
    	
    	MaxQuestionsAmount.setmaxQuestions(8);	// reset questions
	 		 	
	 	//check if attributes of suspect are known
	 	switchSuspectCheck();
	 	
	 	while (MaxQuestionsAmount.getmaxQuestions() > 0)	{
    		
	 		infoInterfaceSuspect();
	 		questionList();
    		AnswerList();
    	}
    	
  	}
      	
    public void roomSearch() {
    	
    	MaxQuestionsAmount.setmaxQuestions(8);	// reset questions
	 		 	
	 	//check if attributes of suspect are known
    	switchSuspectCheck();
	 	
	 	while (MaxQuestionsAmount.getmaxQuestions() > 0)	{
    		
	 		infoInterfaceRoom();
	 		questionList();
    		AnswerList();
    	}
    	
  	}
    
    public void switchSuspectCheck() {
       	
    	//check if choice and name are chosen
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getNameKnown() == true){
				suspectName.setsuspectName(suspect[i].getName());
			}
      		else {
      			suspectName.setsuspectName("onbekend");
       		}
		}
    	//check if choice and age are chosen
    	for (int o = 0; o<suspectChoice; o++){
			if(suspectChoice == 1 + o && suspect[o].getAgeKnown() == true){
				suspectAge.setsuspectAge(suspect[o].getAge());
			}
      		else {
      			suspectAge.setsuspectAge("onbekend");
       		}
		}
    	//check if choice and appearance are chosen
    	for (int j = 0; j<suspectChoice; j++){
			if(suspectChoice == 1 + j && suspect[j].getAppearanceKnown() == true){
				suspectAppearance.setsuspectAppearance(suspect[j].getAppearance());
			}
      		else {
      			suspectAppearance.setsuspectAppearance("onbekend");
       		}
		}
    }
    
    public void switchName() {
    	
    	//Switches name to known
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getNameKnown() == false){
				suspectName.setsuspectName(suspect[i].getName());
	    		suspect[i].setNameKnown(true);
	    		MaxQuestionsAmount.setmaxQuestions(MaxQuestionsAmount.getmaxQuestions() - 1); 
			}
      		else {
       			
       		}
		}
    }
    
    public void switchAge() {
    	
    	//Switches age to known
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getAgeKnown() == false){
				suspectAge.setsuspectAge(suspect[i].getAge());
	    		suspect[i].setAgeKnown(true);
	    		MaxQuestionsAmount.setmaxQuestions(MaxQuestionsAmount.getmaxQuestions() - 1); 
			}
      		else {
       			
       		}
		}
    }
    
    public void switchAppearance() {
    	
    	//Switches age to known
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getAppearanceKnown() == false){
				suspectAppearance.setsuspectAppearance(suspect[i].getAppearance());
	    		suspect[i].setAppearanceKnown(true); 
			}
      		else {
       			
       		}
		}
    }
  
    public void questionList() {
	
    	for (int i = 0; i<detective.getQuestion().length; i++){
			int x = i + 1;
				    			
			Question detectiveQuestion = detective.getQuestion(i);
			System.out.println("\t" + x + ". " + detectiveQuestion.getText());
		}
    }
			
	public void AnswerList() {
		
		switchSuspectCheck();
		
			try {
        		int input2 = in2.nextInt(); //zorgt voor input
        		    			    	    				
        		for (int i = 0; i<suspectChoice; i++){
        			
        			if (suspectChoice == 1 + i && input2 == 1) {
        		    	switchName();
        		    	Answer detectiveQuestion = suspect[i].getAnswer(input2 - 1);
        				clearScreen();
        				System.out.println("\n---------------------------------------------------");
        		    	System.out.println("\n\t " + detectiveQuestion.getText() + suspectName.getsuspectName());
        		    	System.out.println("\n---------------------------------------------------");
        		    	
                   	}
        			else if (suspectChoice == 1 + i && input2 == 2) {
        		    	switchAge();
        		    	Answer detectiveQuestion = suspect[i].getAnswer(input2 - 1);
        				clearScreen();
        				System.out.println("\n---------------------------------------------------");
        		    	System.out.println("\n\t " + detectiveQuestion.getText() + suspectAge.getsuspectAge());
        		    	System.out.println("\n---------------------------------------------------");
        		    	
                   	}
        			else if (suspectChoice == 1 + i && input2 == 3) {
        		    	switchAppearance();	
        		    	Answer detectiveQuestion = suspect[i].getAnswer(input2 - 1);
        				clearScreen();
        				System.out.println("\n---------------------------------------------------");
        		    	System.out.println("\n\t " + detectiveQuestion.getText() + suspectAppearance.getsuspectAppearance());
        		    	System.out.println("\n---------------------------------------------------");
        		    	
                   	}
        			else if(input2 == detective.getQuestion().length - 1){
            			
            			clearScreen();
            			clues();
            		}
            		
            		else if(input2 == detective.getQuestion().length){
            			
            			clearScreen();
            			MaxQuestionsAmount.setmaxQuestions(0);
            		}
            		else if(suspectChoice == 1 + i){
        				
        				Answer suspectAnswer = suspect[i].getAnswer(input2 - 1);
        				clearScreen();
        				System.out.println("\n---------------------------------------------------");
        		    	System.out.println("\n\t " + suspectAnswer.getText());
        		    	System.out.println("\n---------------------------------------------------");
        		    	MaxQuestionsAmount.setmaxQuestions(MaxQuestionsAmount.getmaxQuestions() - 1);
        		    }
              		else {
               			
               		}
        		}
        	}
        	
        	catch (ArrayIndexOutOfBoundsException e) {
               
                clearScreen();
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\tProbeer opnieuw.");
				//System.out.println("\tArray is out of Bounds "+e); //for debugger
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n");
				gameTurn();
             }
			catch (InputMismatchException ex) {
				clearScreen();
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\tProbeer opnieuw.");
				System.out.println("\t" + in2.next() + " was niet een juiste invoer "+ex);
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n");
				gameTurn();
			}
	}
	
	public void infoInterfaceSuspect() {  
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t# " + suspectName.getsuspectName() + " is aanwezig #\n");
		System.out.println("---------------------------------------------------");
		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
		System.out.println("\t" + suspectName.getsuspectName() + " wil nog " + MaxQuestionsAmount.getmaxQuestions() + " vragen beantwoorden.");
		System.out.println("\n\tLeeftijd = " + suspectAge.getsuspectAge());
		System.out.println("\tUiterlijk = " + suspectAppearance.getsuspectAppearance());
		System.out.println("\tBeurten = " + turns);
		System.out.println("\n\tWat wil je vragen of doen?");
       }  
	
	public void infoInterfaceRoom() {  
		
		for (int i = 0; i<roomChoice; i++){
			if(roomChoice == 1 + i){
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\t# Je bent in de " + room[i].getName() + " #\n");
				System.out.println("---------------------------------------------------");
				System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
				System.out.println("\tJe kan nog " + MaxQuestionsAmount.getmaxQuestions() + " keer zoeken.");
				System.out.println("\n\tKamer naam = " + room[i].getName());
				System.out.println("\tBeurten = " + turns);
				System.out.println("\n\tWat wil je doen?");
			}
       }  
	}
    
	public static void tryAgain() {  
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\tProbeer opnieuw");
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n");
       }  
	
	public static void clearScreen() {  
    	for (int i = 0; i < 50; ++i) System.out.println(); //Temporary// console clear
       }  
    
	}   	
	
