package models.templeGrec;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.shape.Box;
import com.jme3.util.BufferUtils;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class GtRoof extends BlankThing {
    private float longueur;
    private float largeur;
    private float hauteur;

    private float epaisseur = 0.5f;
    private float profondeurTympan = 0;

    private float marge;

    private Node baseNode;
    private Node roofNode;
    private Node tympanNode;
    private Node tympanNode2;

    public GtRoof(float length, float width, float height){
        this.longueur = length;
        this.largeur = width;
        this.hauteur = height;

        marge = epaisseur;
    }

    public void draw(){
        //Base Box

        baseNode = new Node();
        roofNode = new Node();
        tympanNode = new Node();
        tympanNode2 = new Node();

        this.drawBaseBox();
        this.drawRoof();
        this.drawTympan();
        //this.drawTympan2();

        this.node.attachChild(this.baseNode);
        this.node.attachChild(this.roofNode);
        this.node.attachChild(this.tympanNode);
        //this.node.attachChild(this.tympanNode2);
    }

    public void drawTympan(){
        Mesh mesh1 = new Mesh();

        Vector3f[] vertices1 = new Vector3f[3];
        vertices1[0] = new Vector3f(0,0,0);
        vertices1[1] = new Vector3f(1,0,0);
        vertices1[2] = new Vector3f(0.5f,1,0);

        int[] indexes1 = new int[vertices1.length];
        for(int i=0;i<indexes1.length;i++){
            indexes1[i] = indexes1.length-i-1;
        }

        float[] normals1 = new float[]{0,0,-1, 0,0,-1, 0,0,-1};

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        mesh1.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices1));
        mesh1.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh1.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes1));
        mesh1.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals1));
        mesh1.updateBound();

        Geometry geo1 = new Geometry("tympan", mesh1);
        geo1.setMaterial(BasicMaterials.templeGrecBleu);
        this.tympanNode.attachChild(geo1);
        this.tympanNode.scale(largeur+2*marge,hauteur,1);

        this.tympanNode.getChild("tympan")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        this.tympanNode.move(new Vector3f(
                -largeur/2-marge,
                epaisseur,
                -longueur/2+profondeurTympan
        ));

    }

    public void drawRoof(){
        Roof roof = new Roof(
                this.longueur+2*marge,
                this.largeur+2*marge,
                this.hauteur);
        roof.draw();
        roofNode.attachChild(roof.getNode());
        roof.getNode().setMaterial(BasicMaterials.templeGrecPaleYellow);
        roof.getNode().setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.roofNode.move(new Vector3f(0,epaisseur,0));
    }

    public void drawBaseBox(){
        Box baseBox = new Box(
                largeur/2+marge,
                epaisseur/2,
                longueur/2+marge
        );
        Geometry baseBoxGeom = new Geometry("baseBox",baseBox);
        baseBoxGeom.setMaterial(BasicMaterials.templeGrecRouge);
        this.baseNode.attachChild(baseBoxGeom);
        this.baseNode.getChild("baseBox").setLocalTranslation(
                new Vector3f(
                        0,
                        epaisseur/2,
                        0)
        );
        this.baseNode.getChild("baseBox")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    public float getHauteur() {
        return hauteur;
    }

    public void drawTympan2Old(){
        Mesh mesh1 = new Mesh();

        Vector3f[] vectors = new Vector3f[6];
        vectors[0] = new Vector3f(0,0,0);
        vectors[1] = new Vector3f(0,1,0);
        vectors[2] = new Vector3f(1,1,0);
        vectors[3] = new Vector3f(1,0,0);
        vectors[4] = new Vector3f(0,1,1);
        vectors[5] = new Vector3f(1,1,1);

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        //Mesh 1
        Vector3f[] vertices1 = new Vector3f[12];
        vertices1[0] = vectors[0];
        vertices1[1] = vectors[2];
        vertices1[2] = vectors[1];
        vertices1[3] = vectors[2];
        vertices1[4] = vectors[0];
        vertices1[5] = vectors[3];
        vertices1[6] = vectors[1];
        vertices1[7] = vectors[5];
        vertices1[8] = vectors[4];
        vertices1[9] = vectors[2];
        vertices1[10] = vectors[5];
        vertices1[11] = vectors[1];

        int[] indexes1 = new int[vertices1.length];
        for(int i=0;i<indexes1.length;i++){
            indexes1[i] = indexes1.length-i-1;
        }

        float[] normals1 = new float[]{

                0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1,
                0,1,0, 0,1,0, 0,1,0, 0,1,0, 0,1,0, 0,1,0,

        };

        mesh1.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices1));
        mesh1.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh1.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes1));
        mesh1.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals1));
        mesh1.updateBound();

        Geometry geo1 = new Geometry("tympanFront", mesh1);
        geo1.setMaterial(BasicMaterials.templeGrecPaleYellow);
        this.tympanNode2.attachChild(geo1);
        this.tympanNode2.getChild("tympanFront")
                .scale(largeur,profondeurTympan,1);
        this.tympanNode2.getChild("tympanFront")
                .move(new Vector3f(-largeur/2, 0,0));
        this.tympanNode2.getChild("tympanFront")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        this.tympanNode2.move(0,epaisseur, -longueur/2);
    }

    public void drawTympan2(){
        //Points Necessaires
        Vector3f[] vectors = new Vector3f[3];
        vectors[0] = new Vector3f(0,0,0);
        vectors[1] = new Vector3f(largeur+2*marge,0,0);
        vectors[2] = new Vector3f((largeur+2*marge)/2,hauteur,0);

        //Points à relier dans le sens antihoraire
        Vector3f[] vertices1 = new Vector3f[3];
        vertices1[0] = vectors[0];
        vertices1[1] = vectors[1];
        vertices1[2] = vectors[2];

        //Je ne sais plus à quoi ça sert mais ok
        int[] indexes1 = new int[vertices1.length];
        for(int i=0;i<indexes1.length;i++){
            indexes1[i] = indexes1.length-i-1;
        }

        //1 normale par vertices1
        float[] normals1 = new float[]{
                0,0,-1, 0,0,-1, 0,0,-1
        };

        //Pour la gestion des textures
        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        //Création du mesh
        Mesh mesh1 = new Mesh();
        mesh1.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices1));
        mesh1.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh1.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes1));
        mesh1.setBuffer(VertexBuffer.Type.Normal,   3, BufferUtils.createFloatBuffer(normals1));
        mesh1.updateBound();

        //Geometry + Rattachement Node
        Geometry geo1 = new Geometry("NAME", mesh1);
        geo1.setMaterial(BasicMaterials.templeGrecBleu);
        this.node.attachChild(geo1);

        //Recentrer si necessaire
        this.node.getChild("NAME").move(new Vector3f(
                0,
                0,
                0
        ));
    }
}
