package order_Food;

import javafx.scene.image.Image;

public class foodItemDecorator extends plateDecorator {
    int a; 
    
    public foodItemDecorator(plate plateFood) {
        super(plateFood);
    }

    @Override
    public Image display() {
        enjoy(p);
        return p.display();
    }

    public void enjoy(plate plateFood){
        System.out.print("\nPlease enjoy!");
    }
    
}
