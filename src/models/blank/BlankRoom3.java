package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import models.blank.helpers.BlankRoomWall;
import models.blank.helpers.BlankWindow;

import java.util.HashMap;

public class BlankRoom3 extends BlankThing{
    float wall_thickness = BlankWall.getWall_thickness();

    float length;
    float height;
    float width;

    HashMap<String, BlankRoomWall> roomWalls;

    public BlankRoom3(AssetManager assetManager, float length, float height, float width) {
        super(assetManager);

        this.length = length;
        this.height = height;
        this.width = width;

        node = new Node("BlankRoom");

        BlankRoomWall roof = new BlankRoomWall(assetManager,"roof",
                new BlankWall(assetManager, length, width));
        roof.setTranslation(new Vector3f(0,height-wall_thickness/2,width/2));
        roof.setRotation(new Quaternion().fromAngles((float)(-90*Math.PI/180),0,0));
        BlankRoomWall leftWall = new BlankRoomWall(assetManager,"leftWall",
                new BlankWall(assetManager, width, height-wall_thickness));
        leftWall.setTranslation(new Vector3f(-length/2+wall_thickness/2,0,0));
        leftWall.setRotation(new Quaternion().fromAngles(0,(float)(-90*Math.PI/180),0));
        BlankRoomWall rightWall = new BlankRoomWall(assetManager,"rightWall",
                new BlankWall(assetManager, width, height-wall_thickness));
        rightWall.setTranslation(new Vector3f(length/2-wall_thickness/2,0,0));
        rightWall.setRotation(new Quaternion().fromAngles(0,(float)(90*Math.PI/180),0));
        BlankRoomWall backWall = new BlankRoomWall(assetManager,"backWall",
                new BlankWall(assetManager, length-wall_thickness*2, height-wall_thickness));
        backWall.setTranslation(new Vector3f(0,0,-width/2+wall_thickness/2));
        backWall.setRotation(new Quaternion().fromAngles(0,0,0));
        BlankRoomWall frontWall = new BlankRoomWall(assetManager,"frontWall",
                new BlankWall(assetManager, length-wall_thickness*2, height-wall_thickness));
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
