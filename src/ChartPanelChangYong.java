

import java.awt.Graphics;
import java.awt.Panel;

public class ChartPanelChangYong extends Panel {

	@Override
	public void paint(Graphics g) {
	
		super.paint(g);
		
		//차트 테두리 선 그려오기
		
		g.drawLine(70, 50, 70, 410);
		g.drawString("인원(명)", 50, 30);
		g.drawString("▲", 64, 50);
		g.drawLine(60, 400, 610, 400);
		g.drawString("▶", 610, 405);
		g.drawLine(600, 410, 600, 50);		
		g.drawString("누적상대도수(%)", 550, 30);
		g.drawString("▲", 594, 50);
		
		
		for(int j=1;j<6;j++){
			for(int i=70;i<=600;i=i+4)
				g.drawString("- ", i,400-59*j);
				
			g.drawString(j*2+"", 55, 400-59*j);
			g.drawString(j*20+"", 605, 400-59*j);
			
				
				
				
			
		}
		
	}
}
