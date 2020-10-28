package com.tutorial.main;

import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
	
	Handler handler;
	HUD hud;
	
	private int B1 = 100;
	private int B2 = 100;
	private int B3 = 100;
	
	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.setFont(new Font("Ink Free", 0, 48));
		g.drawString("SHOP", (int) (Game.WIDTH/2-100), 50);
		
		//box 1
		g.setFont(new Font("Ink Free", 0, 12));
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost: " + B1, 110, 140);
		g.drawRect(100, 100, 100, 80);
		
		//box 2
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost: " + B2, 260, 140);
		g.drawRect(250, 100, 100, 80);
				
		//box 3
		g.drawString("Refill Health", 410, 120);
		g.drawString("Cost: " + B3, 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		g.drawString("SCORE: " + hud.getScore(), (int) (Game.WIDTH/2-50), 300);
		g.drawString("Press Space to go back", (int) (Game.WIDTH/2-50), 330);
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		//box1
		if(mx >= 100 && mx <=200) {
			if(my >= 100 && my <= 180) {
				//you have selected box 1
				if(hud.getScore() >= B1) {
					
					hud.setScore(hud.getScore() - B1);
					B1 += 100;
					hud.bounds += 20;
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
		
		//box2
		if(mx >= 250 && mx <= 350) {
			if(my >= 100 && my <= 180) {
				//you have selected box 2
                if(hud.getScore() >= B2) {
					
					hud.setScore(hud.getScore() - B2);
					B2 += 100;
					handler.spd++;
				}
			}
		}
				
		//box3
	 	if(mx >= 400 && mx <=500) {
			if(my >= 100 && my <= 180) {
				//you have selected box 3
                if(hud.getScore() >= B3) {
					
					hud.setScore(hud.getScore() - B3);
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
				
	}

}
