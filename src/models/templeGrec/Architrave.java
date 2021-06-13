package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Architrave extends BlankThing {

    private static float default_hauteur = 1;
    private float largeur;
    private float longueur;
    private float hauteur = default_hauteur;
    private float ratio = 0.75f;
    private float marge = hauteur*(1-ratio);

    public Architrave(float width, float length){
        super();
        largeur = width;
        longueur = length;

        Box b1 = new Box(
                largeur/2,
                hauteur/2*ratio,
                longueur/2
        );
        Geometry b1Geom = new Geometry("B1",b1);
        b1Geom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box b2 = new Box(
                largeur/2+marge,
                hauteur/2*(1-ratio),
                longueur/2+marge
        );
        Geometry b2Geom = new Geometry("B2",b2);
        b2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        this.node.attachChild(b1Geom);
        this.node.attachChild(b2Geom);

        this.node.getChild("B1").setLocalTranslation(
                new Vector3f(0,hauteur/2*ratio,0)
        );
        this.node.getChild("B1").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        this.node.getChild("B2").setLocalTranslation(
                new Vector3f(0,(hauteur/2*(1-ratio))+(hauteur*ratio),0)
        );
        this.node.getChild("B2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

    }
}
