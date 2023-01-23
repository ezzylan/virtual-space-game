package see_Menu;

public class MenuRepository {
    
    // Create list array to hold menu items
    MenuItem [] menuItems;
    
    public MenuRepository(){
        menuItems = new MenuItem[3];
        
        // Create Menu Object
        MenuItem pasta = new MenuPasta();
        MenuItem cake = new MenuCake();
        MenuItem juice = new MenuJuice();
        
        //Add object to the list
        menuItems[0] = pasta;
        menuItems[1] = cake;
        menuItems[2] = juice;
    }
    
    public Iterator createIterator() {
        return new MenuIterator(menuItems);
    }
    
}
