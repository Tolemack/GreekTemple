//TODO : Optimiser le modele en remplaçant les box par des polygones
//TODO : Ampute les coordonnées d'une fenetre si elle dépasse
package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import models.blank.helpers.BlankWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BlankWall extends BlankThing{
    private static float wall_thickness = 0.1f;

    private float height;
    private float width;
    private ArrayList<BlankWindow> windows;

    Comparator<Float> FloatComparator = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return Float.compare(o1, o2);
        }
    };

    public BlankWall(AssetManager assetManager, float width, float height) {
        super(assetManager);

        this.setHeight(height);
        this.setWidth(width);
        this.setWindows(new ArrayList<BlankWindow>());
    }

    public BlankWall(AssetManager assetManager, float width, float height, ArrayList<BlankWindow> windows){
        this(assetManager, width, height);
        this.setWindows(windows);
        this.draw();
    }

    public static float getWall_thickness() {
        return wall_thickness;
    }

    public void addWindow(BlankWindow window) {
        this.getWindows().add(window);
    }

    public void draw(){
        this.node.detachAllChildren();

        float wall_point_right_X = -this.getWidth() /2;
        float wall_point_left_X = this.getWidth() /2;
        float wall_point_top_Y = this.getHeight();
        float wall_point_bottom_Y = 0;

        ArrayList<Float> points_X = new ArrayList<Float>();
        ArrayList<Float> points_Y = new ArrayList<Float>();
        ArrayList<Float> window_points_X = new ArrayList<Float>();
        ArrayList<Float> window_points_Y = new ArrayList<Float>();

        points_X.add(wall_point_right_X);
        points_X.add(wall_point_left_X);
        points_Y.add(wall_point_top_Y);
        points_Y.add(wall_point_bottom_Y);

        for(int index_window = 0; index_window< this.getWindows().size(); index_window++) {
            BlankWindow window = this.getWindows().get(index_window);
            float windowPositionX = window.getPosition().getX() - this.getWidth() / 2;
            float windowPositionY = window.getPosition().getY();
            float window_point_right_X = windowPositionX - window.getWidth() / 2;
            float window_point_left_X = windowPositionX + window.getWidth() / 2;
            float window_point_top_Y = windowPositionY + window.getHeight() / 2;
            float window_point_bottom_Y = windowPositionY - window.getHeight() / 2;

            points_X.add(window_point_right_X);
            points_X.add(window_point_left_X);
            points_Y.add(window_point_top_Y);
            points_Y.add(window_point_bottom_Y);
            window_points_X.add(window_point_right_X);
            window_points_X.add(window_point_left_X);
            window_points_Y.add(window_point_bottom_Y);
            window_points_Y.add(window_point_top_Y);
        }

        Collections.sort(points_X, FloatComparator);
        Collections.sort(points_Y, FloatComparator);

        System.out.println("points_X : "+points_X);
        System.out.println("points_Y : "+points_Y);
        System.out.println("window_points_X : "+window_points_X);
        System.out.println("window_points_Y : "+window_points_Y);


        boolean draw=true;
        for(int index_Y=0; index_Y<points_Y.size()-1;index_Y++){
            for(int index_X=0; index_X<points_X.size()-1;index_X++){
                draw=true;

                float point_X1 = points_X.get(index_X);
                float point_X2 = points_X.get(index_X+1);
                float point_Y1 = points_Y.get(index_Y);
                float point_Y2 = points_Y.get(index_Y+1);

                for(int window_index=0; window_index<window_points_Y.size(); window_index=window_index+2){
                    float window_index_X_left = window_points_X.get(window_index);
                    float window_index_X_right = window_points_X.get(window_index+1);
                    float window_index_Y_bottom = window_points_Y.get(window_index);
                    float window_index_Y_top = window_points_Y.get(window_index+1);

                    if(point_X1>=window_index_X_left && point_X1<=window_index_X_right
                            && point_X2>=window_index_X_left && point_X2<=window_index_X_right
                            && point_Y1>=window_index_Y_bottom && point_Y1<=window_index_Y_top
                            && point_Y2>=window_index_Y_bottom && point_Y2<=window_index_Y_top){
                        draw=false;
                    }
                }

                if(draw){
                    Box wallBox = new Box((point_X2-point_X1)/2, (point_Y2-point_Y1)/2, getWall_thickness() /2);
                    Geometry wallGeom = new Geometry("WallX"+point_X1+"Y"+point_Y1,wallBox);
                    wallGeom.setMaterial(this.blankUnshaded);
                    wallGeom.setLocalTranslation(new Vector3f(point_X1+(point_X2-point_X1)/2,point_Y1+(point_Y2-point_Y1)/2,0));
                    this.node.attachChild(wallGeom);
                }
            }
        }

        //GeometryBatchFactory.optimize(this.node);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public ArrayList<BlankWindow> getWindows() {
        return windows;
    }

    public void setWindows(ArrayList<BlankWindow> windows) {
        this.windows = windows;
    }
}
