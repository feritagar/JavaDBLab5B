package model;

import java.sql.*;

public class StoreDatabase {

    public StoreDatabase() {

        try {
            final String DB_URL = "jdbc:derby:StoreDB;create=true";

            Connection con = DriverManager.getConnection(DB_URL);

            dropTables(con);

            buildProductTable(con);

            con.close();

        } catch (Exception e) {
            System.out.println("Error Creating the Table");
            System.out.println(e.getMessage());
        }
    }

    //menu option 2 - display all products
    public void runDatabase(){
            outputDB();
    }

    public static void dropTables(Connection con) {

        try {
            Statement st = con.createStatement();

            try {
                st.execute("DROP TABLE Product");
//                System.out.println("Product table dropped.");
            } catch (SQLException ex) {

            }
            try {
                // Drop the ShoppingCart table.
                st.execute("DROP TABLE ShoppingCart");
//                System.out.println("ShoppingCart table dropped.");
            } catch (SQLException ex) {

            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void buildProductTable(Connection con) {
        try {
            // Get a Statement object.
            Statement st = con.createStatement();

            // Create the table.
            st.execute("CREATE TABLE Product (" +
                    "ProductID INTEGER NOT NULL PRIMARY KEY, " +
                    "ProductName CHAR(25),"+
                    "Description VARCHAR(250)," +
                    "Price DOUBLE )");

            // Insert row #1.
            st.execute("INSERT INTO Product VALUES ( " +
                    "1, " +
                    "'Hazal Dress', " +
                    "'They are manufactured  from %100 cotton.',"+
                    "35.00)");

            // Insert row #1.
            st.execute("INSERT INTO Product VALUES ( " +
                    "2, " +
                    "'Beste Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "25.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "3, " +
                    "'Kanavice Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "30.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "4, " +
                    "'Pecvork Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "40.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "5, " +
                    "'Manyana Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "20.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "6, " +
                    "'Polen Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "50.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "7, " +
                    "'Monalisa Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "25.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "8, " +
                    "'Frilly Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "45.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "9, " +
                    "'Yalena Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "45.00)");
            st.execute("INSERT INTO Product VALUES ( " +
                    "10, " +
                    "'Daisy Dress', " +
                    "'They are manufactured from %100 cotton.', "+
                    "35.00)");


//            System.out.println("Product table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void outputDB(){
        final String DB_URL = "jdbc:derby:StoreDB";
        Statement st = null;
        Connection con = null;
        try{
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL);
//            System.out.println("Creating statement...");
            st = con.createStatement();
            String sql;
            sql = "SELECT ProductID, ProductName, Description, Price FROM Product";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProductID");
                String name = rs.getString("ProductName");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");


                //Display values
                System.out.println("ID: " + id.trim());
                System.out.println("Product Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);
                System.out.println("====================================================");

            }
            //STEP 6: Clean-up environment   bu siralamada olmali.
            rs.close();
            st.close();
            con.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

}
