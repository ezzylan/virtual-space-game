package see_Menu;

public class MenuIterator implements Iterator {
    MenuItem[] items;
    int index = 0;
    
    public MenuIterator(MenuItem[] items){
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return !(index >= items.length || items[index] == null);
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[index];
        index = index + 1;
        return menuItem;
    }
    
}
