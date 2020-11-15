package models.testing;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class Room {
    private static float  thickness = 0.1f;
    private Node node;

    public Room(AssetManager assetManager, float length, float height, float width) {
        node = new Node("Room");

        //Materials
        Material lWalls = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        lWalls.setBoolean("UseMaterialColors", true);
        lWalls.setColor("Ambient", new ColorRGBA(155f/255f,171f/255f,185f/255f,0));
        lWalls.setColor("Diffuse", new ColorRGBA(155f/255f,171f/255f,185f/255f,0));

        Material wWalls = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        wWalls.setBoolean("UseMaterialColors", true);
        wWalls.setColor("Ambient", new ColorRGBA(209f/255f,16f/255f,98f/255f,0));
        wWalls.setColor("Diffuse", new ColorRGBA(209f/255f,16f/255f,98f/255f,0));

        Material hWalls = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        hWalls.setBoolean("UseMaterialColors", true);
        hWalls.setColor("Ambient", new ColorRGBA(227f/255f,205f/255f,117f/255f,0));
        hWalls.setColor("Diffuse", new ColorRGBA(227f/255f,205f/255f,117f/255f,0));

        //Boxes
        Box h1Box = new Box(length/2, thickness/2, width/2);
        Geometry h1Geom = new Geometry("Floor",h1Box);
        h1Geom.setLocalTranslation(new Vector3f(0,-thickness/2,0));
        h1Geom.setMaterial(hWalls);
        Box h2Box = new Box(length/2, thickness/2, width/2);
        Geometry h2Geom = new Geometry("Roof",h2Box);
        h2Geom.setLocalTranslation(new Vector3f(0,height-thickness/2,0));
        h2Geom.setMaterial(hWalls);

        Box l1Box = new Box(thickness/2, height/2-thickness/2, width/2);
        Geometry l1Geom = new Geometry("LeftWall",l1Box);
        l1Geom.setLocalTranslation(new Vector3f(-length/2+thickness/2,height/2-thickness/2,0));
        l1Geom.setMaterial(lWalls);
        Box l2Box = new Box(thickness/2, height/2-thickness/2, width/2);
        Geometry l2Geom = new Geometry("RightWall",l2Box);
        l2Geom.setLocalTranslation(new Vector3f(length/2-thickness/2,height/2-thickness/2,0));
        l2Geom.setMaterial(lWalls);

        Box w1Box = new Box(length/2-thickness, height/2-thickness/2, thickness/2);
        Geometry w1Geom = new Geometry("BackWall",w1Box);
        w1Geom.setLocalTranslation(new Vector3f(0,height/2-thickness/2,-width/2+thickness/2));
        w1Geom.setMaterial(wWalls);
        Box w2Box = new Box(length/2-thickness, height/2-thickness/2, thickness/2);
        Geometry w2Geom = new Geometry("FrontWall",w2Box);
        w2Geom.setLocalTranslation(new Vector3f(0,height/2-thickness/2,width/2-thickness/2));
        w2Geom.setMaterial(wWalls);

        //Attach to Node
        node.attachChild(h1Geom);
        node.attachChild(h2Geom);
        node.attachChild(l1Geom);
        node.attachChild(l2Geom);
        node.attachChild(w1Geom);
        node.attachChild(w2Geom);
    }

    public Node getNode() {
        return node;
    }

    public void addDoor(){
        node.detachChild(node.getChild("FrontWall"));

    }
}
