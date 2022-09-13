package pro.sky.hw2.IntegerList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.hw2.StringList.IntegerListImpl;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.hw2.StringList.Constans.*;

class IntegerListImplTest {

    private final IntegerListImpl IntegerList = new IntegerListImpl();

    @Test
    public void addTest(){
        Assertions.assertEquals(QWE, IntegerList.add(QWE));
    }

    @Test
    public void addInIndexTest(){
        IntegerList.add(0,(ASD));
        Assertions.assertEquals(0, IntegerList.indexOf(ASD));
    }

    @Test
    public void removeTest(){
        IntegerList.add(ASD);
        assertEquals(ASD, IntegerList.remove(ASD));
    }


    @Test
    public void removeInIndexTest(){
        IntegerList.add(QWE);
        IntegerList.add(ASD);
        Assertions.assertEquals(ASD, IntegerList.remove(1));
    }

    @Test
    public void setTest(){
        Assertions.assertEquals(RTY, IntegerList.set(1, RTY));
    }

    @Test
    public void containsTest(){
        IntegerList.add(ASD);
        Assertions.assertTrue(IntegerList.contains(ASD));
    }

    @Test
    public void indexOfTest(){
        IntegerList.add(0, RTY);
        IntegerList.add(1, ASD);
        Assertions.assertEquals(1, IntegerList.indexOf(ASD));
    }

    @Test
    public void lastIndexOf(){
        IntegerList.add(0, RTY);
        IntegerList.add(1, ASD);
        Assertions.assertEquals(0, IntegerList.lastIndexOf(RTY));
    }

    @Test
    public void getTest(){
        IntegerList.add(0, RTY);
        IntegerList.add(1, ASD);
        Assertions.assertEquals(ASD, IntegerList.get(1));
    }

    @Test
    public void equalsTest(){
        IntegerList.add(ASD);
        IntegerList.add(QWE);
        Assertions.assertTrue(IntegerList.equals(IntegerList));
    }

    @Test
    public void sizeTest(){
        IntegerList.add(ASD);
        IntegerList.add(QWE);
        Assertions.assertEquals(2, IntegerList.size());
    }

    @Test
    public void isEmptyTest(){
        Assertions.assertTrue(IntegerList.isEmpty());
    }

    @Test
    public void clearTest(){
        IntegerList.add(ASD);
        IntegerList.add(QWE);
        IntegerList.clear();
        Assertions.assertTrue(IntegerList.isEmpty());
    }

    @Test
    public void toArrayTest(){
        Integer[] expected = {ASD, QWE};
        IntegerList.add(ASD);
        IntegerList.add(QWE);
        Assertions.assertArrayEquals(expected, IntegerList.toArray());
    }
}