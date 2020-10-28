/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ecchilord
 */
public class Handler{
    
    LinkedList<GameObject> object = new LinkedList<>();
    
    public int spd = 5;
    
    public void tick(){
        for(int i = 0; i < object.size(); i++){
           GameObject tempObject = object.get(i);
           
           tempObject.tick();
        }
    }
    
    public void render(Graphics g){
    try {    for(int j = 0; j<object.size(); j++){
            GameObject tempObject = object.get(j);
            
            tempObject.render(g);
        }}catch(Exception e) {}
        
    }
    
    public void clearEnemys(){
       for(int i = 0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            
            if(tempObject.getId() == ID.Player){
                object.clear();
                if(Game.gameState != Game.STATE.End)
                addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player,this));
            }
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    
}
    
    
    
    
    
    
    

