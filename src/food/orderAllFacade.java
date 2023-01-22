package food;

import javafx.scene.image.Image;

public class orderAllFacade {

    plate cake;
    plate juice;
    plate pasta;

    public orderAllFacade(){
        this.cake = new cakePlate();
        this.juice = new juicePlate();
        this.pasta = new pastaPlate();
    }

    public Image getCakeImage(){
        Image cakeImage = new Image(getClass().getResourceAsStream("../resources/img/cake.png"));
        return cakeImage;
    }

    public Image getJuiceImage(){
        Image juiceImage = new Image(getClass().getResourceAsStream("../resources/img/juice.png"));
        return juiceImage;
    }

    public Image getPastaImage(){
        Image pastaImage = new Image(getClass().getResourceAsStream("../resources/img/pasta.png"));
        return pastaImage;
    }
    
}
