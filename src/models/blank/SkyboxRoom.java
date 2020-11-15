package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import models.blank.BlankRoom;

public class SkyboxRoom extends BlankRoom {
    private static ColorRGBA skyColor = new ColorRGBA(200f/255f,250f/255f,250f/255f,0);

    public SkyboxRoom(AssetManager assetManager, float length, float height, float width) {
        super(assetManager, length, height, width);
        Material skyWall = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        skyWall.setColor("Color", skyColor);

        for(int i=0; i<this.getNode().getChildren().size(); i++){
            Geometry child = (Geometry)this.getNode().getChild(i);
            child.setMaterial(skyWall);
        }
    }

    public void setFloorMaterial(Material material){
        this.removeWall("Floor");

        Box h1Box = new Box(length/2, wall_thickness/2, width/2);
        Geometry h1Geom = new Geometry("Floor",h1Box);
        h1Geom.setLocalTranslation(new Vector3f(0,-wall_thickness/2,0));
        h1Geom.setMaterial(material);
        node.attachChild(h1Geom);
    }

    public void putSimpleDummyGrass(AssetManager assetManager){
        Material dummyGrass = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        dummyGrass.setBoolean("UseMaterialColors", true);
        dummyGrass.setColor("Ambient", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));
        dummyGrass.setColor("Diffuse", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));
        this.setFloorMaterial(dummyGrass);
        this.getNode().getChild("Floor").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }
}
