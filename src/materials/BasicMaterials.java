package materials;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

public class BasicMaterials {
    public static Material blankUnshaded;
    public static Material blankShaded;
    public static Material skyWall;
    public static Material dummyGrass;

    private static ColorRGBA skyColor = new ColorRGBA(200f/255f,250f/255f,250f/255f,0);

    public BasicMaterials(AssetManager assetManager){
        this.blankUnshaded = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blankUnshaded.setColor("Color", ColorRGBA.Gray);

        this.blankShaded = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        blankShaded.setBoolean("UseMaterialColors", true);
        blankShaded.setColor("Ambient", ColorRGBA.Gray);
        blankShaded.setColor("Diffuse", ColorRGBA.Gray);

        this.skyWall = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        skyWall.setColor("Color", skyColor);

        this.dummyGrass = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        dummyGrass.setBoolean("UseMaterialColors", true);
        dummyGrass.setColor("Ambient", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));
        dummyGrass.setColor("Diffuse", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));
    }
}
