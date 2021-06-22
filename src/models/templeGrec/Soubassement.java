package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Soubassement extends BlankThing {
    private final float default_hauteur_marches = 0.5f;
    private final int default_nombre_marches = 3;

    private float largeur_base;
    private float longueur_base;
    private float hauteur_marches = default_hauteur_marches;
    private int nombre_marches = default_nombre_marches;

    public Soubassement(int nbColonnesLarge, int nbColonnesLong, float ecartColonnes){
        super();
        this.setNbColonnesLarge(nbColonnesLarge, ecartColonnes);
        this.setNbColonnesLong(nbColonnesLong, ecartColonnes);
    }

    public void setNbColonnesLarge(int nbColonnesLarge, float ecart_colonnes){
        this.largeur_base = ecart_colonnes*(nbColonnesLarge-0.5f)
            +(this.hauteur_marches*this.nombre_marches*2);
    }

    public void setNbColonnesLong(int nbColonnesLong, float ecart_colonnes){
        this.longueur_base = ecart_colonnes*(nbColonnesLong-0.5f)
            +(this.hauteur_marches*this.nombre_marches*2);
    }

    public void setNombreMarches(int nombreMarches){
        this.largeur_base -= (this.hauteur_marches*this.nombre_marches*2);
        this.longueur_base -= (this.hauteur_marches*this.nombre_marches*2);
        this.nombre_marches = nombreMarches;
        this.largeur_base += (this.hauteur_marches*this.nombre_marches*2);
        this.longueur_base += (this.hauteur_marches*this.nombre_marches*2);
    }

    public void setHauteurMarches(float hauteurMarches){
        this.largeur_base -= (this.hauteur_marches*this.nombre_marches*2);
        this.longueur_base -= (this.hauteur_marches*this.nombre_marches*2);
        this.hauteur_marches = hauteurMarches;
        this.largeur_base += (this.hauteur_marches*this.nombre_marches*2);
        this.longueur_base += (this.hauteur_marches*this.nombre_marches*2);
    }

    public void draw(){
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

    public float getHauteur(){
        return hauteur_marches*nombre_marches;
    }
}
