package chars;

import java.util.*;

/**
 * Each NPC will be randomly generated. They will have entities, ages, nicknames, professions (and magic if suitable for profession), inventory, relationships, key information etc.
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class NPC {

    private String fullName;
    private String firstName;
    private String lastName;

    private LinkedHashMap<String, Integer> stats = new LinkedHashMap();
    private LinkedHashMap<String, Integer> inventory = new LinkedHashMap();
    private LinkedHashMap<String, Integer> magic = new LinkedHashMap();


    //TODO: Generate entities according to gender
    //TODO: Get entities according to Race
    //TODO: Get entities from a database
    ArrayList<String> firstNames = new ArrayList<>(
            Arrays.asList("Steve", "Richard", "John", "Bertie", "Alex", "Josh"));

    ArrayList<String> lastNames = new ArrayList<>(
            Arrays.asList("Williams", "Cox", "Smith", "Davidson", "Blake", "Richards"));

    public NPC() {
        Random random = new Random();
        int index = random.nextInt(firstNames.size());
        firstName = firstNames.get(index).toString();

        Random random2 = new Random();
        int index2 = random2.nextInt(lastNames.size());
        lastName = lastNames.get(index2).toString();

        fullName = firstName + " " + lastName;

    }

    public String getName() {
        return this.fullName;
    }

}


