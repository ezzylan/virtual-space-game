public class MenuCake extends MenuItem {

    @Override
    public String getMenuName() {
        return "Cake";
    }

    @Override
    public String getMenuImage() {
        return "resources/cake.png";
    };

    @Override
    public String getMenuDesc() {
        return "Simple and delicious, topped with house-made chocolate fondue.";
    };

    @Override
    public Double getMenuPrice() {
        return 10.0;
    };
}
