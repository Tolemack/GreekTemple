package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Soubassement extends BlankThing {
    private static float default_hauteur_marches = 0.5f;
    private static int default_nombre_marches = 3;
    private float largeur_base;
    private float longueur_base;
    private float hauteur_marches = default_hauteur_marches;
    private int nombre_marches = default_nombre_marches;

    public Soubassement(float width, float length){
        super();
        largeur_base = width;
        longueur_base = length;

        for(int i=0; i<nombre_marches; i++){
            Box b = new Box(
                    (largeur_base/2)-(i*hauteur_marches),
                    hauteur_marches/2,
                    (longueur_base/2)-(i*hauteur_marches)
            );
            Geometry bGeom = new Geometry("B"+i,b);
            bGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);
            this.node.attachChild(bGeom);
            this.node.getChild("B"+i).setLocalTranslation(
                    new Vector3f(0,(hauteur_marches/2)+(i*hauteur_marches),0)
            );
            this.node.getChild("B"+i).setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        }
    }

    public static float getDefault_hauteur_marches() {
        return default_hauteur_marches;
    }

    public static int getDefault_nombre_marches() {
        return default_nombre_marches;
    }
}
