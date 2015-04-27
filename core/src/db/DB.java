package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * All DB read/write functions and connectivity is here
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class DB {

    /**
     * Retrieves every record in the MAGIC table in the database.
     *
     * @return An ArrayList containing each table row as an ArrayList object
     */
    public static ArrayList<ArrayList> getMagic() {
        try
        {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:~/db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MAGIC");

            ArrayList<ArrayList> rows = new ArrayList<>();

            //Creates an ArrayList containing each table row
            while( rs.next() ) {
                ArrayList<String> row = new ArrayList<>();
                row.add(rs.getString("NAME"));
                row.add(rs.getString("DESCRIPTION"));
                row.add(rs.getString("BATTLE_USE"));
                row.add(rs.getString("WORLD_USE"));
                row.add(rs.getString("MOD_AGILITY"));
                row.add(rs.getString("MOD_DEFENCE"));
                row.add(rs.getString("MOD_EVASION"));
                row.add(rs.getString("MOD_HIT"));
                row.add(rs.getString("MOD_LUCK"));
                row.add(rs.getString("MOD_MAGIC"));
                row.add(rs.getString("MOD_SPIRIT"));
                row.add(rs.getString("MOD_STRENGTH"));
                row.add(rs.getString("MOD_HP"));
                row.add(rs.getString("ELEMENT"));
                row.add(rs.getString("BASE_DAMAGE"));
                row.add(rs.getString("EFFECT_NAME"));
                row.add(rs.getString("EFFECT_CHANCE"));

                //Add to master array list
                rows.add(row);
            }

            stmt.close();
            con.close();
            return rows;
        } catch( Exception e )        {
            System.out.println("FATAL: Can't connect to database. Please verify game files.");
            return null;
        }
    }
}
