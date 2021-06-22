package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;

public class BlankRoof extends BlankThing{
    float wall_thickness = 5f;
    float length;
    float width;
    float height;

    public BlankRoof(float length, float width, float height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        this.setRoofAngle((float)Math.toRadians(45.0f));

        this.createMesh2();
    }

    public void setRoofAngle(float angle){
        this.height = (float)Math.tan(angle)*width/2;
    }

    public float getRoofAngle(){
        return (float)Math.atan(this.height/this.width/2);
    }

    public float getRoofPanelWidth(){
        return (float)Math.sqrt(Math.pow(this.height,2)*Math.pow(this.width/2,2));
    }

    public void createMesh(){
        Mesh mesh = new Mesh();
        Vector3f[] vertices = new Vector3f[6];
        vertices[0] = new Vector3f(0,0,-this.width/2);
        vertices[1] = new Vector3f(0,0,this.width/2);
        vertices[2] = new Vector3f(0,this.height,0);
        vertices[3] = new Vector3f(wall_thickness,this.height,0);
        vertices[4] = new Vector3f(wall_thickness,0,this.width/2);
        vertices[5] = new Vector3f(wall_thickness,0,-this.width/2);

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        int [] indexes = {0,1,2, 3,2,1, 3,1,4, 3,4,5, 3,5,0, 2,3,0};

        float[] normals = new float[]{
                -1,0,0, //-1,0,0, -1,0,0,
                0,1,-1, //0,1,-1, 0,1,-1,
                0,1,-1, //0,1,-1, 0,1,-1,
                1,1,0, //1,1,0, 1,1,0,
                0,1,1, //0,1,1, 0,1,1,
                0,0,1, //0,0,1, 0,0,1
        };

        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
        mesh.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes));
        mesh.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals));
        mesh.updateBound();

        Geometry geo = new Geometry("OurMesh", mesh); // using our custom mesh object
        geo.setMaterial(this.blankUnshaded);

        this.node.attachChild(geo);
        //this.setMulticolorShaded(assetManager);
    }

    public void createMesh2(){
        Mesh mesh = new Mesh();
        Vector3f[] vertices = new Vector3f[14];
        vertices[0] = new Vector3f(0,0,-this.width/2);
        vertices[1] = new Vector3f(0,0,this.width/2);
        vertices[2] = new Vector3f(0,this.height,0);

        vertices[3] = new Vector3f(0,0,this.width/2);
        vertices[4] = new Vector3f(0,this.height,0);
        vertices[5] = new Vector3f(wall_thickness,this.height,0);
        vertices[6] = new Vector3f(wall_thickness,0,this.width/2);
        //5, 3 , 6

        vertices[7] = new Vector3f(wall_thickness,this.height,0);
        vertices[8] = new Vector3f(wall_thickness,0,this.width/2);
        vertices[9] = new Vector3f(wall_thickness,0,-this.width/2);

        vertices[10] = new Vector3f(wall_thickness,this.height,0);
        vertices[11] = new Vector3f(wall_thickness,0,-this.width/2);
        vertices[12] = new Vector3f(0,0,-this.width/2);
        vertices[13] = new Vector3f(0,this.height,0);
        //10 11 12 12 13 10

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        int [] indexes = {0,1,2, 5,4,3, 5,3,6, 7,8,9, 10,11,12, 12,13,10};

        float[] normals = new float[]{
                -1,0,0, -1,0,0, -1,0,0,
                1,1,0, 1,1,0, 1,1,0, 1,1,0,
                1,0,0, 1,0,0, 1,0,0,
                0,1,-1, 0,1,-1, 0,1,-1, 0,1,-1
        };

        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
        mesh.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes));
        mesh.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals));
        mesh.updateBound();

        Geometry geo = new Geometry("OurMesh", mesh); // using our custom mesh object
        geo.setMaterial(blankShaded);

        this.node.attachChild(geo);
        this.node.setLocalRotation(new Quaternion().fromAngles(0,3.14f/4,0));
        this.setBlankShaded();
    }
}
