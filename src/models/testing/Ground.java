package models.testing;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Ground {
    public Ground(AssetManager assetManager, float length, float width, float level){
        Material matGround = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        matGround.setBoolean("UseMaterialColors", true);
        matGround.setColor("Ambient", ColorRGBA.Green);
        matGround.setColor("Diffuse", ColorRGBA.Green);

        Box groundBox = new Box(length/2, 0.1f, width/2);
        Geometry geomGround = new Geometry("Ground",groundBox);
        geomGround.setLocalTranslation(new Vector3f(0,level,0));
        geomGround.setMaterial(matGround);
    }
}
