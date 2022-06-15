package YourQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, descriptionPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, descriptionLabel, backgroundLabel, hpLabel, hpLabelNumber, itemLabel, itemLabelName, label;
	Font titleFont = new Font("Times New Roman", Font.ITALIC, 100);
	Font descriptionFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.BOLD, 30);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	Boolean tookMed, tookFood;
	String position, item;
	int playerHunger, playerHP;
	
	TitleScreenHandler title = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		if (args.length == 0) {
			// default genre (
			new Game();
		} else {
			new Game(args[0]);
		}
	}
	
	public Game(String genre) {
		switch(genre) {
			case "horror":
				new GameHorror();
				break;
			case "scifi":
				new GameSciFi();
				break;
			case "fantasy":
				new GameFantasy();
				break;
			default:
				System.err.println("Invalid Genre");
		}
	}

	// default genre = explorer (Like lara croft)
	public Game() {
		window = new JFrame("YourQuest");
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		// window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(700, 100, 600, 150);
		//titleNamePanel.setBackground(Color.black);
		titleNamePanel.setOpaque(false);
		titleNameLabel = new JLabel("YourQuest");
		titleNameLabel.setForeground(Color.cyan);
		titleNameLabel.setFont(titleFont);
		
		titleNamePanel.add(titleNameLabel);
		
		descriptionPanel = new JPanel();
		descriptionPanel.setBounds(500, 300, 1050, 100);
		//descriptionPanel.setBackground(Color.black);
		descriptionPanel.setOpaque(false);
		descriptionLabel = new JLabel("An adventure where your choices decides your fate");
		descriptionLabel.setForeground(Color.cyan);
		descriptionLabel.setFont(descriptionFont);
		
		descriptionPanel.add(descriptionLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(800, 500, 400, 300);
		//startButtonPanel.setBackground(Color.black);
		startButtonPanel.setOpaque(false);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setOpaque(false);
		startButton.setForeground(Color.yellow);
		startButton.setFocusPainted(false);
		startButton.setFont(buttonFont);
		startButton.addActionListener(title);
		
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(descriptionPanel);
		
		label = new JLabel();
		label.setIcon(new ImageIcon("background.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
		
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		descriptionPanel.setVisible(false);
		label.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(650, 200, 800, 300);
		//mainTextPanel.setBackground(Color.black);
		mainTextPanel.setOpaque(false);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(650, 200, 800, 300);
		//mainTextArea.setBackground(Color.black);
		mainTextArea.setOpaque(false);
		mainTextArea.setVisible(true);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(650, 700, 700, 200);
		//choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setOpaque(false);
		choiceButtonPanel.setLayout(new GridLayout(4,2));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setOpaque(false);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setOpaque(false);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setOpaque(false);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setOpaque(false);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(10, 10, 500, 100);
		//playerPanel.setBackground(Color.black);
		playerPanel.setOpaque(false);
		playerPanel.setLayout(new GridLayout(2,1));
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		itemLabel = new JLabel("Item:");
		itemLabel.setFont(normalFont);
		itemLabel.setForeground(Color.white);
		playerPanel.add(itemLabel);
		
		itemLabelName = new JLabel();
		itemLabelName.setFont(normalFont);
		itemLabelName.setForeground(Color.white);
		playerPanel.add(itemLabelName);
		
		label = new JLabel();
		label.setIcon(new ImageIcon("background.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 25;
		item = "";
		itemLabelName.setText(item);
		hpLabelNumber.setText("" + playerHP);
		
		forest();
	}
	
	public void forest() {
		label.setVisible(false);
		position = "forest";
		mainTextArea.setText("You wake up in the middle of the forest and look around. Your phone is dead and you have nothing else with you except for the clothes on your back. You see your plane, a river, and a path.\n"
				+ "You get up, what do you do?");
		choice1.setText("Search the plane");
		choice2.setText("Go towards the river");
		choice3.setText("Follow the path");
		choice4.setText("");
		
		label = new JLabel();
		label.setIcon(new ImageIcon("forest.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void plane() {
		label.setVisible(false);
		position = "plane";
		mainTextArea.setText("You search your plane to see what you can salvage. You find some medical supplies and some food and water.\n"
				+ "You can only carry one, which do you take?");
		choice1.setText("Medical supplies & river");
		choice2.setText("Medical supplies & path");
		choice3.setText("Food and water & river");
		choice4.setText("Food and water & path");
		
		label = new JLabel();
		label.setIcon(new ImageIcon("crashedplane.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void river() {
		label.setVisible(false);
		position = "river";
		itemLabelName.setText(item);
		if (item == "") {
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You go towards the river but while walking you get bit by rattlesnake. Without any items with you, you cannot treat the bite and are unable to go any furhter.\n"
					+ "GAME OVER\n"
					+ "Try again?");
			endGame();
		} else if (item == "medical supplies") {
			mainTextArea.setText("You go towards the river, which is full of contaminants making it unsafe for drinking. Fortunately, there is a small pile of wood that you can use to create a raft or a small fire.\n"
					+ "What do you decide to do?");
			choice1.setText("Create a raft");
			choice2.setText("Create a fire");
			choice3.setText("");
			choice4.setText("");
		} else if (item == "food and water") {
			mainTextArea.setText("You go towards the river, which is full of contaminants making it unsafe for drinking. Fortunately, there is a small pile of wood that you can use to create a raft or a small fire.\n"
					+ "What do you decide to do?");
			choice1.setText("Create a raft");
			choice2.setText("Create a fire");
			choice3.setText("");
			choice4.setText("");
		}
		
		label = new JLabel();
		label.setIcon(new ImageIcon("river.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void raft() {
		label.setVisible(false);
		if (item == "medical supplies") {
			position = "raft";
			playerHP += 15;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You were able to create a small raft but in the process you manage to cut yourself multiple times but beacuse you had medical supplies that was the least of your problems. You were able to ride the river down and end up in a small village. There you were able to get food and water and radio for help.\n"
					+ "YOU SURVIVED!\n\n"
					+ "Try again?");
			endGame();
		} else if (item == "food and water") {
			position = "raft";
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You were able to create a small raft but in the process you manage to cut yourself multiple times. Since you do not have any medical supplies you caught an infection and were not able to make it.\n"
					+ "GAME OVER\n\n"
					+ "Try again?");
			endGame();
		}
		
		label = new JLabel();
		label.setIcon(new ImageIcon("raft.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void fire() {
		label.setVisible(false);
		if (item == "medical supplies") {
			position = "fire";
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You create a small fire, but without a weapon to hunt and no other source for food and water, the fire was only able to keep you warm and alive for a few days.\n"
					+ "GAME OVER\n\n"
					+ "Try again?");
			endGame();
		} else if (item == "food and water") {
			position = "fire";
			playerHP += 20;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You create a small fire and with your supply of food and water you were able to keep yourself alive until a group of hikers find you and lead you back to civilization.\n"
					+ "YOU SURVIVED!\n\n"
					+ "Try again?");
			endGame();
		}
		
		label = new JLabel();
		label.setIcon(new ImageIcon("fire.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void path() {
		label.setVisible(false);
		position = "path";
		itemLabelName.setText(item);
		if (item == "") {
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You follow the path as it seems to lead to a village. After following it for hours you were attacked by a bear. You manage to escape but with no medical supplies you are unable to make it.\n"
					+ "GAME OVER\n\n"
					+ "Try again?");
			endGame();
		} else if (item == "medical supplies") {
			mainTextArea.setText("You follow the path as it seems to lead to a village. After following it for hours you encounter a bear. You remember you have medical supplies so you have a chance to fight.\n"
					+ "What do you decide to do?");
			choice1.setText("Try to Escape");
			choice2.setText("Fight the bear");
			choice3.setText("");
			choice4.setText("");
		} else if (item == "food and water") {
			mainTextArea.setText("You follow the path as it seems to lead to a village. After following it for hours you encounter a bear. You remember you have some food that may come in handy.\n"
					+ "What do you decide to do?");
			choice1.setText("Throw food and distract bear");
			choice2.setText("Try to Escape");
			choice3.setText("");
			choice4.setText("");
		}
		
		label = new JLabel();
		label.setIcon(new ImageIcon("path.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void fight() {
		label.setVisible(false);
		position = "fight";
		playerHP = 0;
		hpLabelNumber.setText("" + playerHP);
		mainTextArea.setText("You decide to try and fight the bear. The bear stands on its hind legs and manged to overthrow you. You did not make it.\n"
				+ "GAME OVER\n\n"
				+ "Try again?");
		endGame();
		
		label = new JLabel();
		label.setIcon(new ImageIcon("bearfight.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void throwFood() {
		label.setVisible(false);
		position = "throw";
		mainTextArea.setText("You decide to throw the food that you have away from you to distract the bear. It worked and you were able to slip past and high tail it to the closest village where they helped you radio for help.\n"
				+ "YOU SURVIVED!\n\n"
				+ "Try again?");
		endGame();
		
		label = new JLabel();
		label.setIcon(new ImageIcon("bearfood.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void escape() {
		label.setVisible(false);
		if (item == "medical supplies") {
			position = "escape";
			playerHP -= 10;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You were able to escape the bear with only a few scratches. The medical supplies you grabbed helped out significantly.\n"
					+ "YOU SURVIVED!\n\n"
					+ "Try again?");
			endGame();
		} else if (item == "food and water") {
			position = "escape";
			playerHP -= 10;
			hpLabelNumber.setText("" + playerHP);
			mainTextArea.setText("You attempt to escape but the bear could smell the food that you grabbed and escape was not possible. You did not make it.\n"
					+ "GAME OVER\n\n"
					+ "Try again?");
			endGame();
		}
		
		label = new JLabel();
		label.setIcon(new ImageIcon("escape.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(0, 0, size.width, size.height);
		con.add(label);
	}
	
	public void endGame() {
		position = "end";
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String choice = e.getActionCommand();
			
			switch (position) {
			case "forest":
				switch (choice) {
				case "c1":
					plane();
					break;
				case "c2":
					river();
					break;
				case "c3":
					path();
					break;
				}
				break;
			case "plane":
				switch (choice) {
				case "c1":
					item = "medical supplies";
					river();
					break;
				case "c2":
					item = "medical supplies";
					path();
					break;
				case "c3":
					item = "food and water";
					river();
					break;
				case "c4":
					item = "food and water";
					path();
					break;
				}
				break;
			case "river":
				if (item == "medical supplies") {
					switch (choice) {
					case "c1":
						raft();
						break;
					case "c2":
						fire();
						break;
					}
				} else if (item == "food and water") {
					switch (choice) {
					case "c1":
						raft();
						break;
					case "c2":
						fire();
						break;
					}
				}
				break;
			case "path":
				if (item == "medical supplies") {
					switch (choice) {
					case "c1":
						escape();
						break;
					case "c2":
						fight();
						break;
					}
				} else if (item == "food and water") {
					switch (choice) {
					case "c1":
						throwFood();
						break;
					case "c2":
						escape();
						break;
					}
				}
				break;
			case "end":
				switch (choice) {
				case "c1":
					new Game();
					break;
				case "c2":
					System.exit(0);
					break;
				}
			}
		}
		
	}
}