package pro.sky.hw2.StringList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.hw2.StringList.Constans.*;

class StringListImplTest {

    private final StringListImpl stringList = new StringListImpl();

    @Test
    public void addTest(){
        Assertions.assertEquals(QWE, stringList.add(QWE));
    }

    @Test
    public void addInIndexTest(){
        stringList.add(0, ASD);
        Assertions.assertEquals(0, stringList.indexOf(ASD));
    }

    @Test
    public void removeTest(){
        stringList.add(ASD);
        assertEquals(ASD, stringList.remove(ASD));
    }


    @Test
    public void removeInIndexTest(){
        stringList.add(QWE);
        stringList.add(ASD);
        Assertions.assertEquals(ASD, stringList.remove(1));
    }

    @Test
    public void setTest(){
        Assertions.assertEquals(RTY, stringList.set(1, RTY));
    }

    @Test
    public void containsTest(){
        stringList.add(ASD);
        Assertions.assertTrue(stringList.contains(ASD));
    }

    @Test
    public void indexOfTest(){
        stringList.add(0,RTY);
        stringList.add(1,ASD);
        Assertions.assertEquals(1, stringList.indexOf(ASD));
    }

    @Test
    public void lastIndexOf(){
        stringList.add(0,RTY);
        stringList.add(1,ASD);
        Assertions.assertEquals(0, stringList.lastIndexOf(RTY));
    }

    @Test
    public void getTest(){
        stringList.add(0,RTY);
        stringList.add(1,ASD);
        Assertions.assertEquals(ASD, stringList.get(1));
    }

    @Test
    public void equalsTest(){
        stringList.add(ASD);
        stringList.add(QWE);
        Assertions.assertTrue(stringList.equals(stringList));
    }

    @Test
    public void sizeTest(){
        stringList.add(ASD);
        stringList.add(QWE);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void isEmptyTest(){
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void clearTest(){
        stringList.add(ASD);
        stringList.add(QWE);
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void toArrayTest(){
        String[] expected = {ASD, QWE};
        stringList.add(ASD);
        stringList.add(QWE);
        Assertions.assertArrayEquals(expected, stringList.toArray());
    }
}