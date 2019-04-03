package controller;

import model.StoreDatabase;

import java.sql.*;

import java.util.Scanner;

public class Menu{

    StoreDatabase sd = new StoreDatabase();

    public void DisplayMenu(){
        Menu();
    }


    //Display Console Menu & Control Action
    private void Menu() {

        System.out.println("FA Online Shopping Store");
        System.out.println("========================");
        System.out.println("1- Home Page");
        System.out.println("2- Display Products");
        System.out.println("3- Search Product");
        System.out.println("4- Shopping Cart");
        System.out.println("5- Exit");


        Scanner keyboard = new Scanner(System.in);
        String userPick;
        System.out.println("Please Select a Menu Item");
        userPick = keyboard.nextLine();

        do {
            if (userPick.equals("1")) {
                System.out.println("Home page FA Online Store. Please Select Your Action");
                DisplayMenu();
            }
            else if (userPick.equals("2")) {
                //display all products from database
                sd.runDatabase();
            }
            else if (userPick.equals("3")) {
                System.out.println("Please enter product ID");
                String searchID = keyboard.nextLine();
                searchProduct(searchID);
            }
            else if (userPick.equals("4")) {
                System.out.println("Shopping Cart");
            }
            else {

                System.out.println("If you don't want to exit program, Please Select a Menu Item. OR\nType '5' to exit program");
            }
//            System.out.println("Please Select a Menu Item.\nType '5' to exit program");
            userPick = keyboard.nextLine();

        } while (!userPick.equals("5"));
        System.out.println("THANK YOU!!!");

    }

    private void searchProduct(String searchID) {
        final String DB_URL = "jdbc:derby:StoreDB";
        Statement statement = null;
        Connection connection = null;
        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            String sql;
            sql = "SELECT ProductID, ProductName, Description, Price FROM Product";
            ResultSet resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                //Retrieve by column name
                String id  = resultSet.getString("ProductID");
                String name = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                double price = resultSet.getDouble("Price");

                //Display search result
                if(searchID.equals(id)) {
                    System.out.println("ID: " + id.trim());
                    System.out.println("Product Name: " + name);
                    System.out.println("Description: " + description);
                    System.out.println("Price: " + price);
                    System.out.println("====================================================");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }finally{

            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }



    }

}
