package controller;

import java.util.List;

public class MenuOption implements ProductDAO {
    Menu m = new Menu();
    List<MenuOption> products;

    public MenuOption(){

   }

    @Override
    public List<MenuOption> getAllProducts() {
        m.DisplayMenu();
        return products;
    }

}
