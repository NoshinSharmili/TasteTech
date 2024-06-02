import java.io.*;

public class FileUtility {


    public static void saveMenuToFile(Menu menu, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(menu);
            System.out.println("Menu saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving menu to file: " + e.getMessage());
        }
    }


    public static Menu loadMenuFromFile(String filePath) {
        Menu menu = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            menu = (Menu) inputStream.readObject();
            System.out.println("Menu loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading menu from file: " + e.getMessage());
        }
        return menu;
    }
}

