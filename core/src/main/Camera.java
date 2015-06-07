package main;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Martin on 07/06/2015.
 */
public class Camera extends OrthographicCamera{

    public Camera(int width, int height){
        super(width, height);
        this.position.x=width/2;
        this.position.y=height/2;
    }

}
