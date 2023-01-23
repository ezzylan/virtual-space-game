package food;

import javafx.scene.image.Image;

public class orderAllFacade {

    plate cake;
    plate juice;
    plate pasta;

    public orderAllFacade(){
        cake = new cakePlate();
        juice = new juicePlate();
        pasta = new pastaPlate();
    }

    public Image getCakeImage(){
        return cake.display();
    }

    public Image getJuiceImage(){
        return juice.display();
    }

    public Image getPastaImage(){
        return pasta.display();
    }
    
}
