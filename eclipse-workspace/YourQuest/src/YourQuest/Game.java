package YourQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, descriptionPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, descriptionLabel, backgroundLabel, hungerLabel, hungerLabelNumber, hpLabel, hpLabelNumber, itemLabel, itemLabelName;
	Font titleFont = new Font("Times New Roman", Font.ITALIC, 100);
	Font descriptionFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
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
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(700, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("YourQuest");
		titleNameLabel.setForeground(Color.cyan);
		titleNameLabel.setFont(titleFont);
		
		titleNamePanel.add(titleNameLabel);
		
		descriptionPanel = new JPanel();
		descriptionPanel.setBounds(500, 300, 1050, 100);
		descriptionPanel.setBackground(Color.black);
		descriptionLabel = new JLabel("An adventure where your choices decides your fate");
		descriptionLabel.setForeground(Color.cyan);
		descriptionLabel.setFont(descriptionFont);
		
		descriptionPanel.add(descriptionLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(800, 500, 400, 300);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.yellow);
		startButton.setFont(buttonFont);
		startButton.addActionListener(title);
		
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(descriptionPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		descriptionPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(400, 100, 1600, 400);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(400, 100, 1600, 400);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(800, 700, 400, 200);
		choiceButtonPanel.setBackground(Color.blue);
		choiceButtonPanel.setLayout(new GridLayout(4,2));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(400, 100, 600, 200);
		playerPanel.setBackground(Color.blue);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerHunger = 15;
		playerHP = 25;
		item = "";
		itemLabelName.setText(item);
		hpLabelNumber.setText("" + playerHP);
		hungerLabelNumber.setText("" + playerHunger);
		
		forest();
	}
	
	public void forest() {
		position = "forest";
		mainTextArea.setText("You wake up in the middle of the forest and look around.\n"
				+ "You see your plane, a river, and a path. You get up, what do you do?");
		choice1.setText("Search the plane");
		choice2.setText("Go towards the river");
		choice3.setText("Follow the path");
		choice4.setText("");
	}
	
	public void plane() {
		position = "plane";
		mainTextArea.setText("You search your plane to see what you can salvage. You find some medical supplies, some food and water, ");
	}
	
	public void river() {
		position = "river";
	}
	
	public void path() {
		position = "path";
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
			}
		}
		
	}
}