package materials;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

public class BasicMaterials {
    //VARIABLES UTILISEES
    //Base
    public static Material blankUnshaded;
    public static Material blankShaded;
    public static Material skyWall;
    public static Material dummyGrass;

    //Temple Grec - SHADED
    public static Material templeGrecPaleYellow;
    public static Material templeGrecPaleBlue;
    public static Material templeGrecBleu;
    public static Material templeGrecRouge;
    public static Material templeGrecGold;

    //CONFIG COULEURS
    private static ColorRGBA skyColor = new ColorRGBA(200f/255f,250f/255f,250f/255f,0);

    private static ColorRGBA color_templeGrecPaleYellow = new ColorRGBA(223f/255f,210f/255f,157f/255f,0);
    private static ColorRGBA color_templeGrecPaleBlue = new ColorRGBA(175f/255f,207f/255f,206f/255f,0);
    private static ColorRGBA color_templeGrecBleu = new ColorRGBA(63f/255f,72f/255f,204f/255f,0);
    private static ColorRGBA color_templeGrecRouge = new ColorRGBA(241f/255f,73f/255f,82f/255f,0);
    private static ColorRGBA color_templeGrecGold = new ColorRGBA(255f/255f,201f/255f,14f/255f,0);

    public BasicMaterials(AssetManager assetManager){
        blankUnshaded = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blankUnshaded.setColor("Color", ColorRGBA.Gray);

        blankShaded = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        blankShaded.setBoolean("UseMaterialColors", true);
        blankShaded.setColor("Ambient", ColorRGBA.Gray);
        blankShaded.setColor("Diffuse", ColorRGBA.Gray);

        skyWall = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        skyWall.setColor("Color", skyColor);

        dummyGrass = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        dummyGrass.setBoolean("UseMaterialColors", true);
        dummyGrass.setColor("Ambient", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));
        dummyGrass.setColor("Diffuse", new ColorRGBA(50f/255f,150f/255f,50f/255f,0));

        templeGrecPaleYellow = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        templeGrecPaleYellow.setBoolean("UseMaterialColors", true);
        templeGrecPaleYellow.setColor("Ambient", color_templeGrecPaleYellow.mult(0.75f));
        templeGrecPaleYellow.setColor("Diffuse", color_templeGrecPaleYellow);

        templeGrecPaleBlue = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        templeGrecPaleBlue.setBoolean("UseMaterialColors", true);
        templeGrecPaleBlue.setColor("Ambient", color_templeGrecPaleBlue.mult(0.75f));
        templeGrecPaleBlue.setColor("Diffuse", color_templeGrecPaleBlue);

        templeGrecBleu = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        templeGrecBleu.setBoolean("UseMaterialColors", true);
        templeGrecBleu.setColor("Ambient", color_templeGrecBleu.mult(0.75f));
        templeGrecBleu.setColor("Diffuse", color_templeGrecBleu);

        templeGrecRouge = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        templeGrecRouge.setBoolean("UseMaterialColors", true);
        templeGrecRouge.setColor("Ambient", color_templeGrecRouge.mult(0.75f));
        templeGrecRouge.setColor("Diffuse", color_templeGrecRouge);

        templeGrecGold = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        templeGrecGold.setBoolean("UseMaterialColors", true);
        templeGrecGold.setColor("Ambient", color_templeGrecGold.mult(0.75f));
        templeGrecGold.setColor("Diffuse", color_templeGrecGold);
        templeGrecGold.setFloat( "Shininess", 64f);
    }
}
