package fuzzy0320;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FuzzyFrame extends JFrame {
	JButton startButton=new JButton("Move Car");
	Fuzzy fuzzy=new Fuzzy();
	
	public FuzzyFrame(){
		super("fuzzy");
		FuzzyPanel fuzzyPanel=new FuzzyPanel();
		add(fuzzyPanel,BorderLayout.CENTER);
		add(startButton,BorderLayout.SOUTH);
		
		startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//double turn=fuzzy.detectValue(fuzzyPanel.countFrontLen(),fuzzyPanel.countSideLen());
				//System.out.printf("¥´%f«×\n",turn);
				//fuzzyPanel.moveCar(turn);
				
				//repaint();
				Thread moveThread=new Thread(){
					public void run(){
						for(int i=0;i<1000;i++){
							fuzzyPanel.moveCar(fuzzy.detectValue(fuzzyPanel.countFrontLen(),fuzzyPanel.countSideLen()));
							//fuzzyPanel.moveCar(30);
							repaint();
							
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				};
				moveThread.start();	
			}
		});
	}
	
}
