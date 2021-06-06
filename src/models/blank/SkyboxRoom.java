package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankRoom;

public class SkyboxRoom extends BlankRoom {
    //private static ColorRGBA skyColor = new ColorRGBA(200f/255f,250f/255f,250f/255f,0);

    public SkyboxRoom(float length, float height, float width) {
        super(length, height, width);
        Material skyWall = BasicMaterials.skyWall;

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

    public void putSimpleDummyGrass(){
        this.setFloorMaterial(BasicMaterials.dummyGrass);
        this.getNode().getChild("Floor").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }
}
