package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import models.blank.BlankThing;

import java.util.ArrayList;

public class GtColonneManager extends BlankThing {
    private final Colonne default_colonne = new Colonne(6);
    private final float default_ecart_colonnes = 3.0f;

    private Colonne baseColonne = default_colonne;

    private ArrayList<Colonne> colonnes;
    private float ecart_colonnes = default_ecart_colonnes;
    private int nbColonnesLarge;
    private int nbColonnesLong;

    public GtColonneManager(int nbColonnesLarge, int nbColonnesLong){
        super();
        this.nbColonnesLarge = nbColonnesLarge;
        this.nbColonnesLong = nbColonnesLong;
        colonnes = new ArrayList<>();
    }

    public void draw(){
        for(int iColLarge=0; iColLarge<nbColonnesLarge; iColLarge++){
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    ((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    -((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
        }
        for(int iColLong=1; iColLong<nbColonnesLong-1; iColLong++){
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    ((nbColonnesLarge-1)*ecart_colonnes)/2,
                                    0,
                                    (ecart_colonnes*iColLong)-(((nbColonnesLong-1)*ecart_colonnes)/2)
                            )
                    );
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    -((nbColonnesLarge-1)*ecart_colonnes)/2,
                                    0,
                                    (ecart_colonnes*iColLong)-(((nbColonnesLong-1)*ecart_colonnes)/2)
                            )
                    );
        }
    }

    public float getHauteur(){
        return this.baseColonne.getHauteur();
    }

    public void setHauteur(float hauteur){
        this.baseColonne.setHauteur(hauteur);
    }

    public Colonne getBaseColonne() {
        return this.baseColonne;
    }
}
