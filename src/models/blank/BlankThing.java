package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import java.util.Random;

public class BlankThing {
    Node node;
    Material blankUnshaded;
    Material blankShaded;

    public BlankThing(AssetManager assetManager){
        this.node = new Node("Thing");

        Material blankUnshaded = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blankUnshaded.setColor("Color", ColorRGBA.Gray);
        this.blankUnshaded = blankUnshaded;

        Material blankShaded = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        blankShaded.setBoolean("UseMaterialColors", true);
        blankShaded.setColor("Ambient", ColorRGBA.Gray);
        blankShaded.setColor("Diffuse", ColorRGBA.Gray);
        this.blankShaded = blankShaded;
    }

    public Node getNode() {
        return node;
    }

    public void replaceMaterial(Material material){
        for(int i=0; i<this.getNode().getChildren().size(); i++){
            Geometry child = (Geometry)this.getNode().getChild(i);
            child.setMaterial(material);
        }
    }

    public void setBlankShaded(AssetManager assetManager){
        for(int i=0; i<this.getNode().getChildren().size(); i++){
            Geometry child = (Geometry)this.getNode().getChild(i);
            child.setMaterial(this.blankShaded);
            child.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        }
    }

    public void setMulticolorShaded(AssetManager assetManager){
        Random rand = new Random();
        for(int i=0; i<this.getNode().getChildren().size(); i++){
            ColorRGBA randomColor = new ColorRGBA(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0);
            Spatial child = this.getNode().getChild(i);
            Material randomColorMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
            randomColorMat.setBoolean("UseMaterialColors", true);
            randomColorMat.setColor("Ambient", randomColor);
            randomColorMat.setColor("Diffuse", randomColor);
            child.setMaterial(randomColorMat);
            child.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        }
    }

}
