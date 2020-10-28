
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ecchilord
 */
public class Player extends GameObject {
    
    Random r = new Random();
    Handler handler;
    
    public Player(float x, float y, ID id , Handler handler){
        super(x, y, id);
        this.handler = handler;
       
    }    
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 32, 32);
    }
    
    public void tick() {
     
        x += velX;
        y += velY;
        
        x = Game.clamp((int) x, 0, (int)Game.WIDTH - 37);
        y = Game.clamp((int) y, 0, (int)Game.HEIGHT - 69);
        
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.05f, handler));

        
        collision();
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){  //tempObject is now basic enemy
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
    
    public void render(Graphics g) {        
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y, 32, 32);
        
    }
    
}
