package collection;

import java.util.*;
import java.util.LinkedList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList data = new ArrayList<>(); // так не пишуть, пишуть через дженеріки:
        ArrayList<String> data1 = new ArrayList<>(); // так
        var data2 = new ArrayList<Integer>();// або так


        List<Integer> data3 = new ArrayList<Integer>(); // створення нового обєкту ліст типу аррайліст(саморозширюючийся масив)
        List<Integer> data4 = new java.util.LinkedList<Integer>();//створення нового обєкту ліст типу лінкедліст(звязаний список)
        // сучачні черги Queue і стеки stack влаштовані на лінкедліст
        Queue<Integer> data5= new java.util.LinkedList<>();// створення нового обєкту черга типу лінкедліст(звязаний список),обєкт
        // звичайний лінкет ліст, він обмежений тим інтерфейсом, що ми вказали - чергою, тобто перелік операцій з ним
        // і спосіб, як з ним взаємодіяти - це інтерфейс типу черга

        Deque<Integer> data6= new LinkedList<>(); // створення нового обєкту черга типу лінкедліст(звязаний список),обєкт
        // звичайний лінкет ліст інтерфейсу типу двонаправлена черга - це черга, яка може читатися з двох сторін,
        // типу черга і стек одночасно
        // видно, що структури даних базуються на інших структурах даних (тут черга і стек на ліенкедлисту)
    }
}
