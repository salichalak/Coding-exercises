package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private static final String TEST = "Test";
    private static final String SECOND_TEST = "SecondTest";

    private CustomLinkedList<String> linkedList;

    @Before
    public void initialiseLinkedList() {
        this.linkedList = new CustomLinkedList<>();
        this.linkedList.add(TEST);
    }

    @Test
    public void checkCorrectAddingElementToList() {
        Assert.assertTrue(this.linkedList.contains(TEST));
    }

    @Test
    public void tryGetElementOfListWithValidIndex() {
        this.linkedList.add(SECOND_TEST);

        String element = this.linkedList.get(1);
        Assert.assertEquals(SECOND_TEST, element);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryGetElementOfListWithInvalidIndex() {
        this.linkedList.add(SECOND_TEST);

        this.linkedList.get(5);
    }

    @Test
    public void checkCorrectWorkingContainsElementInList() {
        this.linkedList.add(SECOND_TEST);

        Assert.assertTrue(this.linkedList.contains(TEST));
    }

    @Test
    public void checkCorrectRemoveElementOfList() {
        int index = this.linkedList.remove(TEST);
        Assert.assertEquals(0, index);
    }

    @Test
    public void checkCorrectReturnIndexIfRemovedElementNotContained() {
        this.linkedList.remove(TEST);
        int index = this.linkedList.remove(TEST);
        Assert.assertEquals(-1, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryRemoveAtWithInvalidIndex() {
        this.linkedList.removeAt(-1);
    }

    @Test
    public void removeElementAtIndexIfWorkingReturnCorrectValue() {
        this.linkedList.add(SECOND_TEST);
        String element = this.linkedList.removeAt(1);
        Assert.assertEquals(SECOND_TEST, element);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trySetElementOnInvalidIndex() {
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);

        this.linkedList.set(69, TEST);
    }

    @Test
    public void trySetElementOnValidIndex() {
        this.linkedList.add(SECOND_TEST);
        this.linkedList.add(TEST);

        this.linkedList.set(2, SECOND_TEST);
        Assert.assertEquals(SECOND_TEST, this.linkedList.get(2));
    }
}