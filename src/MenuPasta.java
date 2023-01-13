public class MenuPasta extends MenuItem {
    @Override
    public String getMenuName() {
        return "Pasta";
    }

    @Override
    public String getMenuImage() {
        return "resources/pasta.png";
    };

    @Override
    public String getMenuDesc() {
        return "Simple and delicious, with house-made tomato-basil marinara, drizzled with Tusean olive oil.";
    };

    @Override
    public Double getMenuPrice() {
        return 12.0;
    };
}
