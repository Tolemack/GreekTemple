package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Soubassement extends BlankThing {
    TempleGrecProperties.Soubassement prop;

    public Soubassement(TempleGrecProperties.Soubassement prop){
        this.prop = prop;
    }

    public void draw(){
        float hauteur_marches = prop.hauteur_marches;
        int nbMarches = prop.nbMarches;
        float largeur_base = prop.largeur_base;
        float longueur_base = prop.longueur_base;

        for(int i=0; i<nbMarches; i++){
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

    public float getHauteur(){
        return prop.hauteur_marches*prop.nbMarches;
    }
}
