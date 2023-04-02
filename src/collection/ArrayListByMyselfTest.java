package collection;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListByMyselfTest {
    @Test
    public void testAddElement(){
        ArrayListByMyself arrList = new ArrayListByMyself();
        arrList.setArrayLenght(5);
        arrList.setArrayList(new Integer[arrList.getArrayLenght()]);

        arrList.addElement(1);
        arrList.addElement(3);
        arrList.addElement(5);
        arrList.addElement(7);

        Assert.assertArrayEquals(new Integer[]{1, 3, 5,7,null},arrList.getArrayList());
    }
    @Test
    public  void testGet(){
        ArrayListByMyself arrList = new ArrayListByMyself();
        arrList.setArrayLenght(5);
        arrList.setArrayList(new Integer[]{5,7,8,9,10});

        int expected = 9;
        int actual = arrList.get(3);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testContains(){
        ArrayListByMyself arrList = new ArrayListByMyself();
        arrList.setArrayLenght(5);
        arrList.setArrayList(new Integer[]{5,7,8,9,10});
        boolean expected = true;
        boolean actual = arrList.contains(9);
        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected, arrList.contains(12));
    }
    @Test
    public void testRemove(){
        ArrayListByMyself arrList = new ArrayListByMyself();
        arrList.setArrayLenght(5);
        arrList.setArrayList(new Integer[]{5,7,8,9,10});

        boolean expected = true;
        boolean actual = arrList.remove(3);
        boolean actual2 = arrList.remove(4);
        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected,actual2);
   }

}
