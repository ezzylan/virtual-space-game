package see_Menu;

//template method for each menu item
public abstract class MenuItem {

    public abstract String getMenuName();

    public abstract String getMenuImage();

    public abstract String getMenuDesc();

    public abstract Double getMenuPrice();

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
