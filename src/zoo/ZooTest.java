
package zoo;
import org.junit.Assert;
import org.junit.Test;

public class ZooTest {
    @Test
    public void testAddAnimal(){
        Zoo1 zoo1 = new Zoo1();
        Horse horse = new Horse("horse", "Elly", "oat", false);
        zoo1.addAnimals(horse);
        Assert.assertEquals(horse,zoo1.getAnimals()[0]);
    }
    @Test
    public void testPayingProcess(){
        Zoo1 zoo1 = new Zoo1();
        var result = zoo1.payingProcess(20,10);
        var expected  = true;
        Assert.assertEquals(expected, result);
        result = zoo1.payingProcess(30,30);
        expected  = true;
        Assert.assertEquals(expected, result);
        result = zoo1.payingProcess(20,30);
        expected  = false;
        Assert.assertEquals(expected, result);
    }
    @Test
    public  void testPayingResult(){
        Zoo1 zoo1 = new Zoo1();
        Visitor visitor = new Visitor();
        visitor.setMoney(20);
        var result = zoo1.payingProcess(visitor.getMoney(), 10);
        var expected = true;
        Assert.assertEquals(expected,result);
        result = zoo1.payingProcess(visitor.getMoney(), 15);
        expected = true;
        Assert.assertEquals(expected,result);
        result = zoo1.payingProcess(visitor.getMoney(), 50);
        expected = false;
        Assert.assertEquals(expected,result);
    }
}




