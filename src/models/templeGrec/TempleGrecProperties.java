package models.templeGrec;

public class TempleGrecProperties {

    public class Parameters {
        public int nbMarches = 3;
        public int nbColonnesLarge = 8;
        public int nbColonnesLong = 10;
        public float ecart_colonnes = 3.0f;
        /*public int nbMetopeLarge;
        public int nbMetopeLong;*/
    }

    public class Soubassement {
        public float hauteur_marches = 0.5f;
        public int nbMarches;
        public float largeur_base;
        public float longueur_base;

        public void update(){
            this.nbMarches = parameters.nbMarches;
            this.largeur_base = parameters.ecart_colonnes*(parameters.nbColonnesLarge-0.5f)
                    +(this.hauteur_marches*parameters.nbMarches*2);
            this.longueur_base = parameters.ecart_colonnes*(parameters.nbColonnesLong-0.5f)
                    +(this.hauteur_marches*parameters.nbMarches*2);
        }

        public float getHauteur(){
            return hauteur_marches*nbMarches;
        }
    }

    public class Colonnes {
        public int nbColonnesLarge = 8;
        public int nbColonnesLong = 10;
        public float ecart_colonnes = 3.0f;
        public Colonne colonne = new Colonne(6);

        public void update() {
            this.nbColonnesLarge = parameters.nbColonnesLarge;
            this.nbColonnesLong = parameters.nbColonnesLong;
            this.ecart_colonnes = parameters.ecart_colonnes;
        }

        public float getHauteur(){
            return this.colonne.getHauteur();
        }

    }

    public class Architrave {
        float largeur;
        float longueur;
        float hauteur = 1;
        float epaisseur = colonnes.colonne.getLargeurBase();
        float ratio = 0.75f;
        float marge = hauteur*(1-ratio);

        public void update() {
            this.largeur = parameters.ecart_colonnes*(parameters.nbColonnesLarge-0.5f);
            this.longueur = parameters.ecart_colonnes*(parameters.nbColonnesLong-0.5f);
        }

        public float getHauteur() {
            return hauteur;
        }
    }

    public class Metope {
        int nbMetopeLong;
        int nbMetopeLarge;
        float hauteur = 1;
        float epaisseur = colonnes.colonne.getLargeurBase();
        float longueurArchitrave;
        float largeurArchitrave;

        public void update() {
            this.nbMetopeLong = (parameters.nbColonnesLong-1)*2;
            this.nbMetopeLarge = (parameters.nbColonnesLarge-1)*2;
            this.longueurArchitrave = architrave.longueur;
            this.largeurArchitrave = architrave.largeur;
        }

        public float getHauteur() {
            return hauteur;
        }
    }

    public class Roof {
        float longueur;
        float largeur;
        float hauteur;
        float epaisseur = 0.5f;
        float profondeurTympan = 0;
        float marge;

        public void update() {
            this.largeur = parameters.ecart_colonnes*(parameters.nbColonnesLarge-0.5f);
            this.longueur = parameters.ecart_colonnes*(parameters.nbColonnesLong-0.5f);
            this.hauteur = computeRoofHeight();
            this.marge = this.epaisseur;
        }

        public float getHauteur() {
            return hauteur;
        }
    }

    public final Parameters parameters = new Parameters();
    public final Soubassement soubassement = new Soubassement();
    public final Colonnes colonnes = new Colonnes();
    public final Architrave architrave = new Architrave();
    public final Metope metope = new Metope();
    public final Roof roof = new Roof();

    public TempleGrecProperties(){
        updateAll();
    }

    public void updateNbMarches(int nbMarches){
        this.parameters.nbMarches = nbMarches;
        updateAll();
    }

    public void updateNbColonnesLarge(int nbColonnesLarge){
        this.parameters.nbColonnesLarge = nbColonnesLarge;
        updateAll();
    }

    public void updateNbColonnesLong(int nbColonnesLong){
        this.parameters.nbColonnesLong = nbColonnesLong;
        updateAll();
    }

    public void updateColonneSize(float size){
        this.colonnes.colonne = new Colonne(size);
        updateAll();
    }

    private void updateAll(){
        soubassement.update();
        colonnes.update();
        architrave.update();
        metope.update();
        roof.update();
    }

    private float computeRoofHeight() {
        return (soubassement.getHauteur()+ colonnes.getHauteur()+ architrave.getHauteur()+ metope.getHauteur())*3/10;
    }

    public void incrementNbColonnesLarge(){
        updateNbColonnesLarge(this.parameters.nbColonnesLarge+1);
    }

    public void decrementNbColonnesLarge(){
        updateNbColonnesLarge(this.parameters.nbColonnesLarge-1);
    }

    public void incrementNbColonnesLong(){
        updateNbColonnesLong(this.parameters.nbColonnesLong+1);
    }

    public void decrementNbColonnesLong(){
        updateNbColonnesLong(this.parameters.nbColonnesLong-1);
    }

    public void incrementNbMarches(){
        updateNbMarches(this.parameters.nbMarches+1);
    }

    public void decrementNbMarches(){
        updateNbMarches(this.parameters.nbMarches-1);
    }

    public void incrementColonneSize(){
        updateColonneSize(this.colonnes.colonne.getHauteur()+1);
    }

    public void decrementColonneSize(){
        updateColonneSize(this.colonnes.colonne.getHauteur()-1);
    }

}
