package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import models.blank.helpers.BlankWindow;

import java.util.ArrayList;
import java.util.HashMap;

public class BlankRoom extends BlankThing{
    static float wall_thickness = 0.1f;

    float length;
    float height;
    float width;

    public BlankRoom(AssetManager assetManager, float length, float height, float width) {
        super(assetManager);

        this.length = length;
        this.height = height;
        this.width = width;

        node = new Node("BlankRoom");

        //Boxes
        Box h1Box = new Box(length/2, wall_thickness/2, width/2);
        Geometry h1Geom = new Geometry("Floor",h1Box);
        h1Geom.setLocalTranslation(new Vector3f(0,-wall_thickness/2,0));
        h1Geom.setMaterial(this.blankUnshaded);
        Box h2Box = new Box(length/2, wall_thickness/2, width/2);
        Geometry h2Geom = new Geometry("Roof",h2Box);
        h2Geom.setLocalTranslation(new Vector3f(0,height-wall_thickness/2,0));
        h2Geom.setMaterial(this.blankUnshaded);

        Box l1Box = new Box(wall_thickness/2, height/2-wall_thickness/2, width/2);
        Geometry l1Geom = new Geometry("LeftWall",l1Box);
        l1Geom.setLocalTranslation(new Vector3f(-length/2+wall_thickness/2,height/2-wall_thickness/2,0));
        l1Geom.setMaterial(this.blankUnshaded);
        Box l2Box = new Box(wall_thickness/2, height/2-wall_thickness/2, width/2);
        Geometry l2Geom = new Geometry("RightWall",l2Box);
        l2Geom.setLocalTranslation(new Vector3f(length/2-wall_thickness/2,height/2-wall_thickness/2,0));
        l2Geom.setMaterial(this.blankUnshaded);

        Box w1Box = new Box(length/2- wall_thickness, height/2-wall_thickness/2, wall_thickness/2);
        Geometry w1Geom = new Geometry("BackWall",w1Box);
        w1Geom.setLocalTranslation(new Vector3f(0,height/2- wall_thickness /2,-width/2+wall_thickness/2));
        w1Geom.setMaterial(this.blankUnshaded);
        Box w2Box = new Box(length/2- wall_thickness, height/2-wall_thickness/2, wall_thickness/2);
        Geometry w2Geom = new Geometry("FrontWall",w2Box);
        w2Geom.setLocalTranslation(new Vector3f(0,height/2- wall_thickness/2,width/2-wall_thickness/2));
        w2Geom.setMaterial(this.blankUnshaded);

        //Attach to Node
        node.attachChild(h1Geom);
        node.attachChild(h2Geom);
        node.attachChild(l1Geom);
        node.attachChild(l2Geom);
        node.attachChild(w1Geom);
        node.attachChild(w2Geom);
    }

    public void removeWall(String wall){
        node.detachChild(node.getChild(wall));
    }

    /*public void addWindow(AssetManager assetManager, String wall, BlankWindow window){
        //Suppression de l'ancienMur
        this.removeWall(wall);
        //Creation du node
        Node newWallNode = new Node(wall);

        float wallWidth = this.width;
        float wallHeight = this.height-wall_thickness;

        //en fonction du mur
        float windowPositionX = window.getPosition().getX();
        if(wall=="BackWall" || wall=="FrontWall") {
            windowPositionX -= wall_thickness;
            wallWidth-=wall_thickness*2;
        }
        float windowPositionY = window.getPosition().getY();

        new BlankWall(assetManager, wallWidth, wallHeight, this.wallsWindows.get(wall));


        this.wallsWindows.put(wall,window);
    }*/
}
