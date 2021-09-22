package p01_Database;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] ARRAY_WITH_MORE_THAN_MAX_ELEMENTS = new Integer[17];
    private static final Integer[] VALID_ARRAY = {1, 2, 3};
    private static final int VALUE_TO_ADD = 5;
    private static final int SEARCHED_VALUE = 3;

    private Database database;

    @Test(expected = OperationNotSupportedException.class)
    public void testInitializeWithMoreThanMaxElements() throws OperationNotSupportedException {
        this.database = new Database(ARRAY_WITH_MORE_THAN_MAX_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInitializeWithZeroElements() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Before
    public void testInitializeDatabase() throws OperationNotSupportedException {
        this.database = new Database(VALID_ARRAY);
    }

    @Test
    public void testIfInitializedDatabaseIsValid() {
        Integer[] elements = this.database.getElements();
        Assert.assertArrayEquals(VALID_ARRAY, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddValidData() throws OperationNotSupportedException {
        this.database.add(VALUE_TO_ADD);
        Integer[] elements = this.database.getElements();
        Assert.assertEquals(VALUE_TO_ADD, elements[3].intValue());
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        this.database.add(VALUE_TO_ADD);
        this.database.remove();
        Integer[] elements = this.database.getElements();
        Assert.assertEquals(SEARCHED_VALUE, elements[2].intValue());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMoreElementsThanAvailable() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }
}