package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import models.blank.helpers.BlankRoomWall;
import models.blank.helpers.BlankWindow;

import java.util.ArrayList;
import java.util.HashMap;

/*
    Salle avec des fenetres
    Possibilité d'amputer les murs
 */

public class BlankRoom3 extends BlankThing{
    float wall_thickness = BlankWall.getWall_thickness();

    float length;
    float height;
    float width;

    HashMap<String, BlankRoomWall> roomWalls;

    public BlankRoom3(float length, float height, float width) {
        super();

        this.length = length;
        this.height = height;
        this.width = width;

        node = new Node("BlankRoom");

        BlankRoomWall roof = new BlankRoomWall("roof",
                new BlankWall(length, width));
        roof.setTranslation(new Vector3f(0,height-wall_thickness/2,width/2));
        roof.setRotation(new Quaternion().fromAngles((float)(-90*Math.PI/180),0,0));
        BlankRoomWall leftWall = new BlankRoomWall("leftWall",
                new BlankWall(width, height-wall_thickness));
        leftWall.setTranslation(new Vector3f(-length/2+wall_thickness/2,0,0));
        leftWall.setRotation(new Quaternion().fromAngles(0,(float)(-90*Math.PI/180),0));
        BlankRoomWall rightWall = new BlankRoomWall("rightWall",
                new BlankWall(width, height-wall_thickness));
        rightWall.setTranslation(new Vector3f(length/2-wall_thickness/2,0,0));
        rightWall.setRotation(new Quaternion().fromAngles(0,(float)(90*Math.PI/180),0));
        BlankRoomWall backWall = new BlankRoomWall("backWall",
                new BlankWall(length-wall_thickness*2, height-wall_thickness));
        backWall.setTranslation(new Vector3f(0,0,-width/2+wall_thickness/2));
        backWall.setRotation(new Quaternion().fromAngles(0,(float)(180*Math.PI/180),0));
        BlankRoomWall frontWall = new BlankRoomWall("frontWall",
                new BlankWall(length-wall_thickness*2, height-wall_thickness));
        frontWall.setTranslation(new Vector3f(0,0,width/2-wall_thickness/2));
        frontWall.setRotation(new Quaternion().fromAngles(0,0,0));

        this.roomWalls = new HashMap<String, BlankRoomWall>();
        this.roomWalls.put(roof.getName(), roof);
        this.roomWalls.put(leftWall.getName(), leftWall);
        this.roomWalls.put(rightWall.getName(), rightWall);
        this.roomWalls.put(backWall.getName(), backWall);
        this.roomWalls.put(frontWall.getName(), frontWall);

    }

    public void addWindow(String wall, BlankWindow window){
        float windowPositionX = window.getPosition().getX();
        float windowPositionY = window.getPosition().getY();
        switch(wall){
            case "leftWall":
                this.roomWalls.get("leftWall").addWindow(window);
                break;
            case "rightWall":
                this.roomWalls.get("rightWall").addWindow(window);
                break;
            case "backWall":
                windowPositionX-=wall_thickness;
                window.setPosition(new Vector2f(windowPositionX,windowPositionY));
                this.roomWalls.get("backWall").addWindow(window);
                break;
            case "frontWall":
                windowPositionX-=wall_thickness;
                window.setPosition(new Vector2f(windowPositionX,windowPositionY));
                this.roomWalls.get("frontWall").addWindow(window);
                break;
            default:
                this.roomWalls.get("roof").addWindow(window);
        }
    }

    private BlankWall getBlankWallByName(String wall){
        return this.roomWalls.get(wall);
    }

    public void draw(){
        //Création du Node Principal
        node = new Node("BlankRoom");

        //Draw walls
        for(BlankRoomWall brw : this.roomWalls.values()){
            brw.draw();
        }

        //Node pour les walls
        Node roofNode = new Node("roof");
        Node leftWallNode = new Node("leftWall");
        Node rightWallNode = new Node("rightWall");
        Node backWallNode = new Node("backWall");
        Node frontWallNode = new Node("frontWall");

        //Attacher les walls aux NodeWall
        roofNode.attachChild(this.roomWalls.get("roof").getNode());
        leftWallNode.attachChild(this.roomWalls.get("leftWall").getNode());
        rightWallNode.attachChild(this.roomWalls.get("rightWall").getNode());
        backWallNode.attachChild(this.roomWalls.get("backWall").getNode());
        frontWallNode.attachChild(this.roomWalls.get("frontWall").getNode());

        //Attacher les NodeWalls au NodeMain
        node.attachChild(roofNode);
        node.attachChild(leftWallNode);
        node.attachChild(rightWallNode);
        node.attachChild(backWallNode);
        node.attachChild(frontWallNode);

        //Appliquer les translations et rotations respectives
        for(BlankRoomWall brw : this.roomWalls.values()){
            this.node.getChild(brw.getName()).setLocalTranslation(brw.getTranslation());
            this.node.getChild(brw.getName()).setLocalRotation(brw.getRotation());
        }
    }

    public void amputeWall(String wall){

        this.roomWalls.get(wall).setDraw(false);

        if(wall.equals("leftWall") || wall.equals("rightWall")){
            float multiply = 1;
            if(wall.equals("rightWall")){
                multiply = -1;
            }

            BlankRoomWall brwFrontWall = this.roomWalls.get("frontWall");
            brwFrontWall.setWidth(brwFrontWall.getWidth()+wall_thickness);
            brwFrontWall.setTranslation(
                    brwFrontWall.getTranslation().add(-wall_thickness/2*multiply,0,0)
            );
            ArrayList<BlankWindow> brwFrontWallWindows = brwFrontWall.getWindows();
            for(BlankWindow brwWindow : brwFrontWallWindows){
                brwWindow.setPosition(
                    brwWindow.getPosition().add(new Vector2f(wall_thickness*multiply,0))
                );
            }

            BlankRoomWall brwBackWall = this.roomWalls.get("backWall");
            brwBackWall.setWidth(brwBackWall.getWidth()+wall_thickness);
            brwBackWall.setTranslation(
                    brwBackWall.getTranslation().add(-wall_thickness/2*multiply,0,0)
            );
            for(BlankWindow brwWindow : brwFrontWallWindows){
                brwWindow.setPosition(
                    brwWindow.getPosition().add(new Vector2f(-wall_thickness*multiply,0))
                );
            }
        }
        if(wall.equals("roof")){
            BlankRoomWall brwFrontWall = this.roomWalls.get("frontWall");
            BlankRoomWall brwBackWall = this.roomWalls.get("backWall");
            BlankRoomWall brwLeftWall = this.roomWalls.get("leftWall");
            BlankRoomWall brwRightWall = this.roomWalls.get("rightWall");
            brwFrontWall.setHeight(brwFrontWall.getHeight()+wall_thickness);
            brwBackWall.setHeight(brwBackWall.getHeight()+wall_thickness);
            brwLeftWall.setHeight(brwLeftWall.getHeight()+wall_thickness);
            brwRightWall.setHeight(brwRightWall.getHeight()+wall_thickness);
        }
    }
}
