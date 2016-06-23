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
	private boolean ExtraQuestions = true;
	
	//Set amount of turns game has
    private int turns = 25;
    
    //Create amount of questions, this is used to reset one of the game loops
    //Random number generator experimental WIP, for now you got 8 questions.
    //Random rand = new Random();
	//int maxVragen = 8;
	//int vragen = rand.nextInt(1 + maxVragen);
    Suspect MaxQuestionsAmount = new Suspect();
    
    //Create input
	Scanner in = new Scanner (System.in);
	Scanner in2 = new Scanner (System.in);
	
	//Setting name, appearance and age for use in GameTurn loop
	Suspect personName = new Suspect();
	Suspect personAge = new Suspect();
	Suspect personAppearance = new Suspect();
       
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
	
	//Create new Answers ArraySuspectAnswers		
	Suspect[] arrAnswerGeneral = new Suspect[2];
	Suspect[] arrAnswerSpecific = new Suspect[6];
	
	
	//Create new Questions ArrayDetectiveQuestions	
	Detective[] arrQuestionGeneral = new Detective[3];
	Detective[] arrQuestionSpecific = new Detective[5];
	
	
	//Setting string up for extra questions and answers
    String arrQuestion1 = "";
    String arrAnswer1 = "";
    String arrQuestion2 = "";
    String arrAnswer2 = "";
	
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
    
    public void createQuestionAnswer() {
    	
    	//Questions are created detective general
    	Detective questionG_1 = new Detective();
    	questionG_1.setText("Wat is je naam?");
    			
    	Detective questionG_2 = new Detective();
    	questionG_2.setText("Wat is je Leeftijd?");
    	
    	Detective questionG_3 = new Detective();
    	questionG_3.setText("Uiterlijk bekijken van verdachte.");
    	
    	//Questions are created detective
    	Detective question1_1 = new Detective();
    	question1_1.setText("Was je aanwezig in kamer 1 rond de tijd van de moord?");
    			
    	Detective question1_2 = new Detective();
    	question1_2.setText("Was je aanwezig in kamer 2 rond de tijd van de moord?");
    	
    	Detective question1_3 = new Detective();
    	question1_3.setText("Was je aanwezig in kamer 3 rond de tijd van de moord?");
    	
    	Detective question1_4 = new Detective();
    	question1_4.setText("Was je aanwezig in kamer 4 rond de tijd van de moord?");
    	
    	Detective question1_5 = new Detective();
    	question1_5.setText("Was je aanwezig in kamer 5 rond de tijd van de moord?");
    	
    	//Answers are created suspect general
    	Suspect answerG_1 = new Suspect();
    	answerG_1.setText("Ja");
    			
    	Suspect answerG_2 = new Suspect();
    	answerG_2.setText("Nee");
    	
    	//Answers are created for suspects
    	Suspect answer1_1 = new Suspect();
    	answer1_1.setText("Ik heb niets gezien.");
    			
    	Suspect answer1_2 = new Suspect();
    	answer1_2.setText("Ik zag dat diegene een baard had.");
    	
    	Suspect answer1_3 = new Suspect();
    	answer1_3.setText("Ik dacht een zij.");
    			
    	Suspect answer1_4 = new Suspect();
    	answer1_4.setText("Met Piet in de eetzaal.");
    	
    	Suspect answer1_5 = new Suspect();
    	answer1_5.setText("Ja, ok hoorde een raar geluid rond middernacht.");
    			
    	Suspect answer1_6 = new Suspect();
    	answer1_6.setText("Hij heeft lang haar");
    	
    	//ArraySuspectAnswers
    	arrAnswerGeneral[0] = answerG_1;
    	arrAnswerGeneral[1] = answerG_2;
    	
    	arrAnswerSpecific[0] = answer1_1;
    	arrAnswerSpecific[1] = answer1_2;
    	arrAnswerSpecific[2] = answer1_3;
    	arrAnswerSpecific[3] = answer1_4;
    	arrAnswerSpecific[4] = answer1_5;
    	arrAnswerSpecific[5] = answer1_6;
    	
    	//ArrayDetectiveQuestions
    	arrQuestionGeneral[0] = questionG_1;
    	arrQuestionGeneral[1] = questionG_2;
    	arrQuestionGeneral[2] = questionG_3;
    	
    	arrQuestionSpecific[0] = question1_1;
    	arrQuestionSpecific[1] = question1_2;
    	arrQuestionSpecific[2] = question1_3;
    	arrQuestionSpecific[3] = question1_4;
    	arrQuestionSpecific[4] = question1_5;
    }
    
    public void createSuspect() {
    	
    	//Suspects are being setup
    	suspect1.setName("Piet");
    	suspect1.setAge("32");
    	suspect1.setAppearance("Blond haar, Bruine ogen, licht getinte huid");
    	suspect1.setSuspectChoice(1);
    				
    	suspect2.setName("Klaas");
    	suspect2.setAge("25");
    	suspect2.setAppearance("Bruin haar, Bruine ogen, licht getinte huid");
    	suspect2.setSuspectChoice(2);
    				
    	suspect3.setName("Jan");
    	suspect3.setAge("27");
    	suspect3.setAppearance("Zwart haar, Groene ogen, donker getinte huid");
    	suspect3.setSuspectChoice(3);
    		
    	suspect4.setName("Tara");
    	suspect4.setAge("19");
    	suspect4.setAppearance("Zwart haar, Blauwe ogen, donker getinte huid");
    	suspect4.setSuspectChoice(4);
    		
    	suspect5.setName("Marie");
    	suspect5.setAge("41");
    	suspect5.setAppearance("Rood haar, Groene ogen, licht getinte huid");
    	suspect5.setSuspectChoice(5);
    	
    	suspect[0] = suspect1;
    	suspect[1] = suspect2;
    	suspect[2] = suspect3;
    	suspect[3] = suspect4;
    	suspect[4] = suspect5;
    }
    
    public void gameTurn() {	
    
    	//Reset while loop when it loops back through
    	GameTurn = true;
    	
    	//While loop for one game turn on what to do
    	while (GameTurn == true)	{
    		
    		mainChoice();
    		
    		GameTurn = false;
    	}
    	
    	
    }
    
    public void questions() {
    	
    	MaxQuestionsAmount.setmaxQuestions(8);	// reset questions
	 		 	
	 	//check if attributes of suspect are known
	 	switchCheck();
	 	
	 	while (MaxQuestionsAmount.getmaxQuestions() > 0)	{
    		
	 		infoInterface();
    		System.out.println("\t1. " + arrQuestionGeneral[0].getText());
    		System.out.println("\t2. " + arrQuestionGeneral[1].getText());
    		System.out.println("\t3. " + arrQuestionGeneral[2].getText());
    		switchQuestionAnswer4_1();
    		System.out.println("\ta. Notebook & aanwijzingen");
    		System.out.println("\tx. Verder gaan");
    			
    		String input = in.nextLine();
    		
    		if(input.equals("1")){
    			switchName();
    			//TEST// QuestionAnswer Suspect1Answer = suspect1.getQuestionAnswer(1);
    			//TEST// System.out.println("Test " + Suspect1Answer.getText() + " Test");
    			clearScreen();
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t Mijn naam is " + personName.getpersonName());
        		System.out.println("\n---------------------------------------------------");
        		
    		}
    		
    		else if(input.equals("2")){
    			switchAge();
    			
    			clearScreen();
    			System.out.println("\n---------------------------------------------------");
        		System.out.println("\n\t Mijn leeftijd is " + personAge.getpersonAge());
        		System.out.println("\n---------------------------------------------------");
        	}
    		
    		else if(input.equals("3")){
    			switchAppearance();
    			
    			clearScreen();
    			System.out.println("\n---------------------------------------------------");
    			System.out.println("\n\tDit persoon heeft " + personAppearance.getpersonAppearance());
        		System.out.println("\n---------------------------------------------------");
    			
    		}
    		
    		else if(input.equals("4")){
    			
    			clearScreen();
    			switchQuestionAnswer4_2();
        		switchQuestionAnswer4_3();
        		MaxQuestionsAmount.setmaxQuestions(MaxQuestionsAmount.getmaxQuestions() - 1); 
    		}
    		else if(input.equals("a")){
    			
    			clearScreen();
    			clues();
    		}
    		
    		else if(input.equals("x")){
    			
    			clearScreen();
    			MaxQuestionsAmount.setmaxQuestions(0);
    		}
    		
    		else {
    			clearScreen();		
    			tryAgain();
    		}
    	}
  	}
      							
    public void clues() {
    	System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t# NOTEBOOK #\n");
		System.out.println("---------------------------------------------------");
		
		for (int i = 0; i<suspect.length; i++){
			int x = i+1;
			
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
    
    public void switchCheck() {
       	
    	//check if choice and name are chosen
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getNameKnown() == true){
				personName.setpersonName(suspect[i].getName());
			}
      		else {
       			personName.setpersonName("onbekend");
       		}
		}
    	//check if choice and age are chosen
    	for (int o = 0; o<suspectChoice; o++){
			if(suspectChoice == 1 + o && suspect[o].getAgeKnown() == true){
				personAge.setpersonAge(suspect[o].getAge());
			}
      		else {
      			personAge.setpersonAge("onbekend");
       		}
		}
    	//check if choice and appearance are chosen
    	for (int j = 0; j<suspectChoice; j++){
			if(suspectChoice == 1 + j && suspect[j].getAppearanceKnown() == true){
				personAppearance.setpersonAppearance(suspect[j].getAppearance());
			}
      		else {
      			personAppearance.setpersonAppearance("onbekend");
       		}
		}
    }
    
    public void switchName() {
    	
    	//Switches name to known
    	for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i && suspect[i].getNameKnown() == false){
				personName.setpersonName(suspect[i].getName());
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
				personAge.setpersonAge(suspect[i].getAge());
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
				personAppearance.setpersonAppearance(suspect[i].getAppearance());
	    		suspect[i].setAppearanceKnown(true); 
			}
      		else {
       			
       		}
		}
    }
  
    public void switchQuestionAnswer4_1() {
	
		for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i){
				System.out.println("\t4. " + arrQuestionSpecific[i].getText());
			}
    		else {
    	
    		}
    	}
	}
			
	public void switchQuestionAnswer4_2() {
		
		for (int i = 0; i<suspectChoice; i++){
			if(suspectChoice == 1 + i){
				System.out.println("\n---------------------------------------------------");
		    	System.out.println("\n\t " + arrAnswerSpecific[i].getText());
		    	System.out.println("\n---------------------------------------------------");
			}
    		else {
    	
    		}
    	}
	}

	public void switchQuestionAnswer4_3() {
	
		ExtraQuestions = true; //reset
		
		while (ExtraQuestions == true)	{
		
			if(suspectChoice == 1){
				ExtraQuestions = false;
				
			}
			
			else if(suspectChoice == 2){
				ExtraQuestions = false;
			
			}
			
			else if(suspectChoice == 3){
				ExtraQuestions = false;
			
			}
			
			else if(suspectChoice == 4  && suspect[0].getNameKnown() == false){
	    	
				infoInterface();
	    		System.out.println("\t1. Wie is " + suspect[0].getName() + "?");
				
				
				String input = in.nextLine();		
				if(input.equals("1")){
					clearScreen();
					System.out.println("\n---------------------------------------------------");
					System.out.println("\n\t Dat is " + suspect[0].getName() + " (" + personName.getpersonName() + " wijst " + suspect[0].getName() + " aan)."); //moet nog get set aanmaken voor suspect (suspect[3].getName())
					System.out.println("\n---------------------------------------------------");
				
					suspect[0].setDiningRoomKnown(true);
					suspect[0].setNameKnown(true);
					ExtraQuestions = false;
				}
			}
			
			else if(suspectChoice == 5){
				ExtraQuestions = false;
			
			}
			else{
				ExtraQuestions = false;
			}
		}
	
	}

	public void switchExtraQuestionAnswer1_1() {
		
		if(suspectChoice == 1 && suspect[0].getDiningRoomKnown() == true){
			
			System.out.println("\t9. Was je in de eetzaal rond de tijd van de moord?"); //Still have to add to array
			
		}
		else if(suspectChoice == 2){
			
		
		}
		else if(suspectChoice == 3){
			
		
		}
		else if(suspectChoice == 4 ){
	   	
					
		}
		else if(suspectChoice == 5){
			
		
		}
		else{
		
		}
	}

	
	
	public void switchExtraQuestionAnswer1_2() {
		
		if(suspectChoice == 1 && suspect[0].getDiningRoomKnown() == true){
			clearScreen();
			System.out.println("\n---------------------------------------------------");
			System.out.println("\n\t" + arrAnswerGeneral[0].getText() + " met "+ suspect[3].getName() + " (wijst naar " + suspect[3].getName() + ")." );
			System.out.println("\n---------------------------------------------------");
			suspect[3].setNameKnown(true);
			MaxQuestionsAmount.setmaxQuestions(MaxQuestionsAmount.getmaxQuestions() - 1); 
	
			if(detective.getCharisma() > 40){
				System.out.println("\n\t #CHARISMA# Je ziet dat hij de waarheid spreekt."  );
			}
			else{
				
			}
			
		}
		else if(suspectChoice == 2){
			
		
		}
		else if(suspectChoice == 3){
			
		
		}
		else if(suspectChoice == 4){
	    
		}
		else if(suspectChoice == 5){
			
		
		}
		else{
		
		}
	}

	public void infoInterface() {  
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t# " + personName.getpersonName() + " is aanwezig #\n");
		System.out.println("---------------------------------------------------");
		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
		System.out.println("\t" + personName.getpersonName() + " wil nog " + MaxQuestionsAmount.getmaxQuestions() + " vragen beantwoorden.");
		System.out.println("\n\tLeeftijd = " + personAge.getpersonAge());
		System.out.println("\tUiterlijk = " + personAppearance.getpersonAppearance());
		System.out.println("\tBeurten = " + turns);
		System.out.println("\n\tWat wil je vragen of doen?");
       }  
    
	public static void tryAgain() {  
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\tProbeer opnieuw");
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n");
       }  
	
	public void mainChoice() {  
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\t" + detective.getName() + " ( " + detective.getGender() + " )");
		System.out.println("\n\t" + "Power " + detective.getPower());
		System.out.println("\t" + "Intelligence " + detective.getIntelligence());
		System.out.println("\t" + "Charisma " + detective.getCharisma());
		System.out.println("\n\tBeurten = " + turns);
		System.out.println("\n\tWat wil je doen?");
		System.out.println("\t1. Verdachten ondervragen");
		System.out.println("\t2. Aanwijzingen bekijken");
		    		
		String input = in.nextLine();
		if(input.equals("1")){
			
			clearScreen();
			
			suspectList();
			
    		
        	try {
        		int input2 = in2.nextInt(); //zorgt voor input
        		    			    	    				
	    			suspectChoice = suspect[input2 - 1].getSuspectChoice();
		    		clearScreen();
		    		questions();
	    			
        	}
        	catch (ArrayIndexOutOfBoundsException e) {
               
                clearScreen();
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\tProbeer opnieuw.");
				System.out.println("\tArray is out of Bounds "+e);
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n");
				mainChoice();
             }
			catch (InputMismatchException ex) {
				clearScreen();
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n\tProbeer opnieuw.");
				System.out.println("\t" + in2.next() + " was niet een juiste invoer "+ex);
				System.out.println("\n---------------------------------------------------");
				System.out.println("\n");
				mainChoice();
			}
		}
		
		else if(input.equals("2")){
			
			clearScreen();
			clues();
			gameturn--;
			turns++;
		}
		
		else {
			clearScreen();
			tryAgain();
			mainChoice();
		}
		
	}
	
	public void suspectList() {  
		
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
     }  
	
	public static void clearScreen() {  
    	for (int i = 0; i < 50; ++i) System.out.println(); //Temporary// console clear
       }  
    
	}   	
	
