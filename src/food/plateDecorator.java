package food;

import javafx.scene.image.Image;

public abstract class plateDecorator implements plate{
    plate p;

    public plateDecorator(plate plateFood){
        this.p = plateFood;
    }

    @Override
    public Image display() {
        return p.display();
    }
    
}
