package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

import java.util.ArrayList;

public class TempleGrec extends BlankThing {

    final TempleGrecProperties prop;

    public int nbMarches;
    public int nbColonnesLarge;
    public int nbColonnesLong;
    public float ecart_colonnes = 3.0f;
    /*public int nbMetopeLarge;
    public int nbMetopeLong;*/

    private float largeur;
    private float longueur;

    private final Soubassement soubassement;
    private final GtColonneManager colonneManager;
    private final Architrave architrave;
    private final GtMetopeManager metopeManager;
    private final GtRoof roof;

    private float current_hauteur_max = 0;

    public TempleGrec(TempleGrecProperties prop){
        this.prop = prop;
        this.soubassement = new Soubassement(prop.soubassement);
        this.colonneManager = new GtColonneManager(prop.colonnes);
        this.architrave = new Architrave(prop.architrave);
        this.metopeManager = new GtMetopeManager(prop.metope);
        this.roof = new GtRoof(prop.roof);
    }

    public void draw(){
        this.current_hauteur_max = 0;

        this.nbColonnesLarge = prop.parameters.nbColonnesLarge;
        this.nbColonnesLong = prop.parameters.nbColonnesLong;
        this.largeur = prop.parameters.ecart_colonnes*(prop.parameters.nbColonnesLarge-0.5f);
        this.longueur = prop.parameters.ecart_colonnes*(prop.parameters.nbColonnesLong-0.5f);

        this.drawSoubassement();
        this.drawColonnes();
        this.drawArchitrave();
        this.drawMetope();
        this.drawRoof();
    }

    private void drawSoubassement(){
        this.soubassement.clear();
        this.soubassement.draw();
        this.node.attachChild(soubassement.getNode());
        this.current_hauteur_max += prop.soubassement.getHauteur();
    }

    private void drawColonnes(){
        this.colonneManager.clear();
        this.colonneManager.draw();
        this.node.attachChild(colonneManager.getNode());
        this.colonneManager.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += prop.colonnes.getHauteur();
    }

    private void drawArchitrave(){
        this.architrave.clear();
        this.architrave.draw();
        this.node.attachChild(architrave.getNode());
        this.architrave.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += prop.architrave.getHauteur();
    }

    private void drawMetope(){
        this.metopeManager.clear();
        this.metopeManager.draw();
        this.node.attachChild(metopeManager.getNode());
        this.metopeManager.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += prop.metope.getHauteur();
    }

    private void drawRoof(){
        this.roof.clear();
        this.roof.draw();
        this.node.attachChild(roof.getNode());
        this.roof.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += prop.roof.getHauteur();
    }
}
