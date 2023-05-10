package test.misc;

import misc.ListNode;
import misc.RemoveDuplicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static misc.RemoveDuplicates.insertDuplicates;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDuplicatesTest {

    private ListNode duplicateList;
    @BeforeEach
    public void setUp(){
        duplicateList = ListNode.createListNode(6);
        duplicateList = insertDuplicates(duplicateList);
    }

    @Test
    public void testBeforeRemoveDuplicate(){
        assertTrue(RemoveDuplicates.checkDuplicates(duplicateList));
    }

    @Test
    public void testAfterRemoveDuplicate(){
        assertFalse(RemoveDuplicates.checkDuplicates(RemoveDuplicates.deleteDuplicates(duplicateList)));
    }
}
