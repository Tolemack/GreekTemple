package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import models.blank.helpers.BlankWindow;

import java.util.HashMap;

public class BlankRoom2 extends BlankThing{
    float wall_thickness = BlankWall.getWall_thickness();

    float length;
    float height;
    float width;

    BlankWall roof;
    BlankWall leftWall;
    BlankWall rightWall;
    BlankWall backWall;
    BlankWall frontWall;

    //HashMap<String, Boolean> wallsToDraw;

    public BlankRoom2(AssetManager assetManager, float length, float height, float width) {
        super(assetManager);

        this.length = length;
        this.height = height;
        this.width = width;

        node = new Node("BlankRoom");

        this.roof = new BlankWall(assetManager, length, width);
        this.leftWall = new BlankWall(assetManager, width, height-wall_thickness);
        this.rightWall = new BlankWall(assetManager, width, height-wall_thickness);
        this.backWall = new BlankWall(assetManager, length-wall_thickness*2, height-wall_thickness);
        this.frontWall = new BlankWall(assetManager, length-wall_thickness*2, height-wall_thickness);

        /*this.wallsToDraw = new HashMap<String, Boolean>();
        this.wallsToDraw.put("roof", true);
        this.wallsToDraw.put("leftWall", true);
        this.wallsToDraw.put("rightWall", true);
        this.wallsToDraw.put("backWall", true);
        this.wallsToDraw.put("frontWall", true);*/

    }

    public void addWindow(String wall, BlankWindow window){
        float windowPositionX = window.getPosition().getX();
        float windowPositionY = window.getPosition().getY();
        switch(wall){
            case "leftWall":
                this.leftWall.addWindow(window);
                break;
            case "rightWall":
                this.rightWall.addWindow(window);
                break;
            case "backWall":
                windowPositionX-=wall_thickness;
                window.setPosition(new Vector2f(windowPositionX,windowPositionY));
                this.backWall.addWindow(window);
                break;
            case "frontWall":
                windowPositionX-=wall_thickness;
                window.setPosition(new Vector2f(windowPositionX,windowPositionY));
                this.frontWall.addWindow(window);
                break;
            default:
                this.roof.addWindow(window);
        }
    }

    private BlankWall getBlankWallByName(String wall){
        switch(wall){
            case "leftWall":
                return this.leftWall;
            case "rightWall":
                return this.rightWall;
            case "backWall":
                return this.backWall;
            case "frontWall":
                return this.frontWall;
            default:
                return this.roof;
        }
    }

    public void draw(){
        //Création du Node Principal
        node = new Node("BlankRoom");

        //Draw walls
        this.roof.draw();
        this.leftWall.draw();
        this.rightWall.draw();
        this.frontWall.draw();
        this.backWall.draw();

        //Node pour les walls
        Node roofNode = new Node("roof");
        Node leftWallNode = new Node("leftWall");
        Node rightWallNode = new Node("rightWall");
        Node backWallNode = new Node("backWall");
        Node frontWallNode = new Node("frontWall");

        //Attacher les walls aux NodeWall
        roofNode.attachChild(roof.getNode());
        leftWallNode.attachChild(leftWall.getNode());
        rightWallNode.attachChild(rightWall.getNode());
        backWallNode.attachChild(backWall.getNode());
        frontWallNode.attachChild(frontWall.getNode());

        //Déplacer les walls
        roofNode.setLocalTranslation(new Vector3f(0,height-wall_thickness/2,width/2));
        roofNode.setLocalRotation(new Quaternion().fromAngles((float)(-90*Math.PI/180),0,0));
        leftWallNode.setLocalTranslation(new Vector3f(-length/2+wall_thickness/2,0,0));
        leftWallNode.setLocalRotation(new Quaternion().fromAngles(0,(float)(-90*Math.PI/180),0));
        rightWallNode.setLocalTranslation(new Vector3f(length/2-wall_thickness/2,0,0));
        rightWallNode.setLocalRotation(new Quaternion().fromAngles(0,(float)(90*Math.PI/180),0));
        backWallNode.setLocalTranslation(new Vector3f(0,0,-width/2+wall_thickness/2));
        frontWallNode.setLocalTranslation(new Vector3f(0,0,width/2-wall_thickness/2));

        //Attacher les NodeWalls au NodeMain
        node.attachChild(roofNode);
        node.attachChild(leftWallNode);
        node.attachChild(rightWallNode);
        node.attachChild(backWallNode);
        node.attachChild(frontWallNode);
    }

    /*public void amputeWall(String wall){
        switch(wall){
            case "leftWall":
            case "rightWall":
            case "backWall":
            case "frontWall":
            default:
        }
    }*/
}
