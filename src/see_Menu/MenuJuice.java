package see_Menu;

public class MenuJuice extends MenuItem {
    @Override
    public String getMenuName() {
        return "Juice";
    }

    @Override
    public String getMenuImage() {
        return "resources/img/juice.png";
    };

    @Override
    public String getMenuDesc() {
        return "Fresh orange juice may even be more intense and enjoyable, like eating a freshly peeled orange.";
    };

    @Override
    public Double getMenuPrice() {
        return 5.0;
    };
}
