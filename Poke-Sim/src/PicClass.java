import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class PicClass extends JFrame
	{
	
	static Pokemon FCus = new Blaziken();
	static Pokemon FCusLeg = new Moltres();
	static Pokemon GCus = new Torterra();
	static Pokemon GCusLeg = new Virizion();
	static Pokemon WCus = new Blastoise();
	static Pokemon WCusLeg = new Kyogre();
	static int cheat = 0;
	static boolean legendary = false;

	public static void jOutput()
		{
		final JFrame frame = new JFrame("Pokemon Selector 1");
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
		
		String[] preMadeArray = new String[BattleRunner.pokedex.size()];
		for(int g  = 0; g<BattleRunner.pokedex.size(); g++)
			{
			preMadeArray[g] = BattleRunner.pokedex.get(g).getName(); 
			}
		
		
		JButton button = new JButton("Choose");
		final JComboBox<String> dropdown = new JComboBox<String>(preMadeArray);
		final JLabel words = new JLabel("Choose your pokemon.");
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		frame.add(panel);
		panel.add(words);
		panel.add(dropdown);
		panel.add(button);
		button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
					
				BattleRunner.contestants[0]=BattleRunner.pokedex.get(dropdown.getSelectedIndex());
				frame.dispose();
				jOutput2();
				
				}
			});
		
		frame.setVisible(true);
		}
	public static void jOutput2()
		{
		final JFrame frame = new JFrame("Pokemon Selector 2");
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
		
		String[] preMadeArray = new String[BattleRunner.pokedex.size()];
		for(int g  = 0; g<BattleRunner.pokedex.size(); g++)
			{
			preMadeArray[g] = BattleRunner.pokedex.get(g).getName(); 
			}
		
		
		JButton button = new JButton("Choose");
		final JComboBox<String> dropdown = new JComboBox<String>(preMadeArray);
		final JLabel words = new JLabel("Choose your opponent's pokemon.");
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		panel.add(words);
		panel.add(dropdown);
		panel.add(button);
		button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
					
				BattleRunner.contestants[1]=BattleRunner.pokedex.get(dropdown.getSelectedIndex());
				frame.dispose();
				jResults();
				
				}
			});
		
		frame.setVisible(true);
		}
	
	public static void jGetCodes()
	{
	final JFrame frame = new JFrame("Cheat Code");
	frame.setSize(250, 100);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
	
	
	
	final JLabel words = new JLabel("Would you like to enter cheat codes?");
	JButton button1 = new JButton("Yes");
	JButton button2 = new JButton("No");
	
	final JPanel panel = new JPanel();
	panel.setBackground(Color.white);
	frame.add(panel);
	panel.add(words);
	panel.add(button1);
	panel.add(button2);
	button1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) 
			{
			jTypeCodes();	
			frame.dispose();
			
			}
		});
	
	button2.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent arg0) 
		{
			
		frame.dispose();
		jOutput();
		
		}
	});
	
	frame.setVisible(true);
	}
	
	public static void jTypeCodes()
	{
	final JFrame frame = new JFrame("Cheat Codes");
	frame.setSize(400, 150);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
	
	
	
	
	JButton button = new JButton("Enter");
	final JLabel words = new JLabel("Enter your cheat code.");
	final JTextField input = new JTextField(20);
	
	final JPanel panel = new JPanel();
	panel.setBackground(Color.white);
	frame.add(panel);
	panel.add(words);
	panel.add(input);
	panel.add(button);
	button.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) 
			{
			if(input.getText().equals("^^VV<><>ba"))
				{
				cheat = 1;
				}
			jOutput();
			frame.dispose();
			
			}
		});
	
	frame.setVisible(true);
	}
	
	public static void jResults()
	{
	final JFrame frame = new JFrame("Results");
	frame.setSize(550, 335);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
	
	
	
	JButton button = new JButton("Okay");
	final JLabel words = new JLabel("VS.");
	JLabel imgLabel1 = new JLabel(new ImageIcon(BattleRunner.contestants[0].getPic()), JLabel.LEFT);
	imgLabel1.setBorder(BorderFactory.createTitledBorder(BattleRunner.contestants[0].getName()));
	JLabel imgLabel2 = new JLabel(new ImageIcon(BattleRunner.contestants[1].getPic()), JLabel.RIGHT);
	imgLabel2.setBorder(BorderFactory.createTitledBorder(BattleRunner.contestants[1].getName()));
	String winner = "";
	
	if(cheat==1)
	{
		winner = BattleRunner.contestants[1].faint();
	}
	else if(BattleRunner.contestants[0].isLegendaryStatus()==true&&BattleRunner.contestants[1].isLegendaryStatus()==true) 
	{
		winner = BattleRunner.contestants[1].faint();
	}
	
	else if(BattleRunner.contestants[0].getName().equals("Magikarp"))
	{
		winner = BattleRunner.contestants[0].faint();
	}
	
	else if(BattleRunner.contestants[1].getName().equals("Magikarp"))
	{
		winner = BattleRunner.contestants[1].faint();
	}
	
	else if(BattleRunner.contestants[0].isLegendaryStatus()==false&&BattleRunner.contestants[1].isLegendaryStatus()==true)
	{
		winner = ("Your oppent blew you out of the water!");
	}
	
	else if(BattleRunner.contestants[0].isLegendaryStatus()==true&&BattleRunner.contestants[1].isLegendaryStatus()==false)
	{
		winner = ("You overpowered your opponent! Hurray!!");
	}
	
	else if(BattleRunner.contestants[0].getType().equals("fire")&&BattleRunner.contestants[1].getType().equals("water"))
	{
		winner = BattleRunner.contestants[0].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals("water")&&BattleRunner.contestants[1].getType().equals("fire"))
	{
		winner = BattleRunner.contestants[1].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals("fire")&&BattleRunner.contestants[1].getType().equals("grass"))
	{
		winner = BattleRunner.contestants[1].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals("grass")&&BattleRunner.contestants[1].getType().equals("fire"))
	{
		winner = BattleRunner.contestants[0].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals("grass")&&BattleRunner.contestants[1].getType().equals("water"))
	{
		winner = BattleRunner.contestants[1].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals("water")&&BattleRunner.contestants[1].getType().equals("grass"))
	{
		winner = BattleRunner.contestants[0].faint();
	}
	
	else if(BattleRunner.contestants[0].getType().equals(BattleRunner.contestants[1].getType()))
	{
		winner = ("Both pokemon faint because they are equally matched!");
	}
	

	final JLabel outcome = new JLabel(winner);
	outcome.setVerticalAlignment(SwingConstants.BOTTOM);
	button.setVerticalAlignment(SwingConstants.BOTTOM);
	
	final JPanel panel = new JPanel();
	panel.setBackground(Color.white);
	frame.add(panel);
	panel.add(imgLabel1);
	panel.add(words);
	panel.add(imgLabel2);
	panel.add(outcome);
	panel.add(button);
	button.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) 
			{
				
			frame.dispose();
			
			}
		});
	
	frame.setVisible(true);
	}
	
	public static void jAskCus()
		{
		final JFrame frame = new JFrame("Custom Pokemon Creator");
		frame.setSize(400, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
		
		JButton button = new JButton("Yes");
		JButton button2 = new JButton("No");
		final JLabel words = new JLabel("Do you wish to create a new pokemon?");
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		panel.add(words);
		panel.add(button);
		panel.add(button2);
		button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				jAskLegend();
				frame.dispose();
				}
			});
		button2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				jGetCodes();
				frame.dispose();
				
				}
			});
		
		frame.setVisible(true);
		}
	
	public static void jAskLegend()
	{
	final JFrame frame = new JFrame("Pokemon Creator");
	frame.setSize(400, 70);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
	
	JButton button = new JButton("Yes");
	JButton button1 = new JButton("No");
	final JLabel words = new JLabel("Wll your new pokemon be legendary?");
	
	final JPanel panel = new JPanel();
	panel.setBackground(Color.white);
	frame.add(panel);
	panel.add(words);
	panel.add(button);
	panel.add(button1);
	button.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) 
			{
			legendary = true;
			frame.dispose();
			jMakeCus();
			
			}
		});
	button1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent arg0) 
		{
		frame.dispose();
		jMakeCus();
		}
	});
	
	frame.setVisible(true);
	}
	
	public static void jMakeCus()
		{
		final JFrame frame = new JFrame("Pokemon Creator");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Sets JPanel to center of screen
		String [] types = new String[] {"Fire", "Water", "Grass"};
		
		
		JPanel smallPanel = new JPanel();
		String [] typing = new String[] {"Fire", "Water", "Grass"};
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
		final JComboBox<String> dropdown = new JComboBox<String>(types);
		JButton button = new JButton("Finish");
		JLabel jName = new JLabel("Name:");
		final JTextField nameText = new JTextField(15);
		JLabel jCry = new JLabel("Cry:");
		JLabel jType = new JLabel("Type:");
		final JTextField cryText = new JTextField(15);
		final JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		smallPanel.add(jName);
		smallPanel.add(jCry);
		smallPanel.add(jType);
		panel.add(smallPanel);
		
		smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
		smallPanel.add(nameText);
		smallPanel.add(cryText);
		smallPanel.add(dropdown);
		panel.add(smallPanel);
		panel.add(button);
		button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				String jTypeCus = dropdown.getSelectedItem().toString();
				if(legendary==true)
				{
				if(dropdown.getSelectedItem().equals("Fire"))
					{
					FCusLeg.setType(jTypeCus.toLowerCase());
					String jNameCus = nameText.getText();
					FCusLeg.setName(jNameCus);
					String cryCus = cryText.getText();
					FCusLeg.setCry(cryCus);
					FCusLeg.setPic("unown.png");
					BattleRunner.pokedex.add(FCusLeg);
					
					}
				else if(dropdown.getSelectedItem().equals("Water"))
					{
					WCusLeg.setType(jTypeCus.toLowerCase());
					String nameCus = nameText.getText();
					WCusLeg.setName(nameCus);
					String cryCus = cryText.getText();
					WCusLeg.setCry(cryCus);
					WCusLeg.setPic("unown.png");
					BattleRunner.pokedex.add(WCusLeg);
					
					}
				else if(dropdown.getSelectedItem().equals("Grass"))
					{
					GCusLeg.setType(jTypeCus.toLowerCase());
					String nameCus = nameText.getText();
					GCusLeg.setName(nameCus);
					String cryCus = cryText.getText();
					GCusLeg.setCry(cryCus);
					GCusLeg.setPic("unown.png");
					BattleRunner.pokedex.add(GCusLeg);
					
					}
				}
			else if(legendary==false)
				{
				if(dropdown.getSelectedItem().equals("Fire"))
					{
					FCus.setType(jTypeCus.toLowerCase());
					String nameCus = nameText.getText();
					FCus.setName(nameCus);
					String cryCus = cryText.getText();
					FCus.setCry(cryCus);
					FCus.setPic("unown.png");
					BattleRunner.pokedex.add(FCus);
					
					}
				else if(dropdown.getSelectedItem().equals("Water"))
					{
					WCus.setType(jTypeCus.toLowerCase());
					String nameCus = nameText.getText();
					WCus.setName(nameCus);
					String cryCus = cryText.getText();
					WCus.setCry(cryCus);
					WCus.setPic("unown.png");
					BattleRunner.pokedex.add(WCus);
					
					}
				else if(dropdown.getSelectedItem().equals("Grass"))
					{
					GCus.setType(jTypeCus.toLowerCase());
					String nameCus = nameText.getText();
					GCus.setName(nameCus);
					String cryCus = cryText.getText();
					GCus.setCry(cryCus);
					GCus.setPic("unown.png");
					BattleRunner.pokedex.add(GCus);
					
					}
				}
				frame.dispose();
				jGetCodes();
				
				}
			});
		
		frame.setVisible(true);
		}
}