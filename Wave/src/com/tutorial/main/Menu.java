/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import static com.tutorial.main.Game.HEIGHT;
import com.tutorial.main.Game.STATE;
import static com.tutorial.main.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
/**
 *
 * @author ecchilord
 */
public class Menu extends MouseAdapter{
    
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    
    public void mousePressed(MouseEvent e){
        
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == STATE.Menu){
        
             //play button
        if(mouseOver(mx, my, 210, 150, 200, 64)){
            
            game.gameState = STATE.Select;
            AudioPlayer.getSound("menu_sound").play();
            return;
        }
        
        // help button
        if(mouseOver(mx, my, 210, 250, 200, 64)){
            game.gameState = STATE.Help;
            
            AudioPlayer.getSound("menu_sound").play();
        }
        
       
        //quit button
        if(mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(1);
        }
            
        }
        
        if(game.gameState == STATE.Select){
            
            //normal button
       if(mouseOver(mx, my, 210, 150, 200, 64)){
           
           game.gameState = STATE.Game;
           handler.addObject(new Player((int)Game.WIDTH/2-32, (int)Game.HEIGHT/2-32, ID.Player, handler));
           handler.clearEnemys();
           handler.addObject(new BasicEnemy(r.nextInt((int) (Game.WIDTH - 50)), r.nextInt((int) (Game.HEIGHT - 50)), ID.BasicEnemy, handler));
           
           game.diff = 0;
           
           AudioPlayer.getSound("menu_sound").play();
           
       }
       
       // hard button
       if(mouseOver(mx, my, 210, 250, 200, 64)){
    	   game.gameState = STATE.Game;
           handler.addObject(new Player((int)Game.WIDTH/2-32, (int)Game.HEIGHT/2-32, ID.Player, handler));
           handler.clearEnemys();
           handler.addObject(new HardEnemy(r.nextInt((int) (Game.WIDTH - 50)), r.nextInt((int) (Game.HEIGHT - 50)), ID.HardEnemy, handler));
           
           game.diff = 1;
           
           AudioPlayer.getSound("menu_sound").play();
       }
       
      
       //back button
       if(mouseOver(mx, my, 210, 350, 200, 64)){
    	   game.gameState = STATE.Menu;
           AudioPlayer.getSound("menu_sound").play();
           return;
           
       }
           
       }
       
        
       
        
        //back button for help
        if(game.gameState == STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
                
            }
        }
        
        //try again button for restart
        if(game.gameState == STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
                AudioPlayer.getSound("menu_sound").play(); 
            }
        }
    
    }
    
    public void mouseReleased(MouseEvent e){
        
        
    } 
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
                                
            }else return false;
        }else return false;
        
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if(game.gameState == STATE.Menu){
            
             Font fnt = new Font("EXOTC350 Bd BT", 1, 90);
        Font fnt2 = new Font("MS Serif", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("WAVE", 190, 70);
              
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play :-)", 270, 190);
                
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help :-p", 270, 290);
                
        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit :-/", 270, 390);
            
        } else if(game.gameState == STATE.Help){
            Font fnt = new Font("MS Serif", 1, 50);
            Font fnt2 = new Font("Roboto", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help :-p", 240, 70);
            
        g.setFont(fnt3);
        g.drawString("Use W A S D keys to move and dodge enemies", 100, 200);
                
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 270, 390);
        }
        else if(game.gameState == STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("GAME OVER !!!!!", 210, 70);
            
        g.setFont(fnt3);
        g.drawString("YOU LOST WITH A SCORE OF: "+ hud.getScore(), 175, 200);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Try Again?", 240, 390);
        }
        else
         if(game.gameState == STATE.Select){
            
            Font fnt = new Font("arial", 1, 50);
       Font fnt2 = new Font("arial", 1, 30);
       
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("SELECT DIFFICULTY", 75, 70);
             
       g.setFont(fnt2);
       g.drawRect(210, 150, 200, 64);
       g.drawString("Normal!", 270, 190);
               
       g.drawRect(210, 250, 200, 64);
       g.drawString("HARD!!", 270, 290);
               
       g.drawRect(210, 350, 200, 64);
       g.drawString("Back", 270, 390);
           
       } 
        
       
    }
    
}
