import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class PicClass extends JFrame
	{
	
	static int cheat = 0;

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
		panel.setBackground(Color.white);
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
		frame.setSize(400, 100);
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
				jMakeCus();
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
	
	public static void jMakeCus()
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
		panel.setBackground(Color.white);
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
}