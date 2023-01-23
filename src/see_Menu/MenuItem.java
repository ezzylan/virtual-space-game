package see_Menu;

public abstract class MenuItem {

    abstract String getMenuName();

    abstract String getMenuImage();

    abstract String getMenuDesc();

    abstract Double getMenuPrice();

    public void addItemToCart() {
        System.out.println("Add item to cart");
    }

    public void removeItemFromCart() {
        System.out.println("Remove item from cart");
    }

    public void countTotal() {
        System.out.println("Total:");
    }

}
