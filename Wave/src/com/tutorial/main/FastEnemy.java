/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ecchilord
 */
public class FastEnemy extends GameObject{
    
    private Handler handler;
    
    public FastEnemy(float x, float y, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 2;
        velY = 9;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
    public void tick(){
      x += velX;
      y += velY;
      
      if(y <= 0 || y >= (int)Game.HEIGHT - 32) velY *= -1;
      if(x <= 0 || x >= (int)Game.WIDTH - 16) velX *= -1;
      
      handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
