package collection;

public class ArrayListByMyself {
    /*Ruslan, [24.11.2022 21:16]
    Домашка:
            1. Реализовать свою структуру данных, не используя ничего готового из collections framework. На вібор: ArrayList, LinkedList.
    Минимальній набор методов:
    public boolean add(T data);
    public boolean remove(int index);
    public T get(int index);
    public void print();
    public boolean contains(T data);

2. Написать тесті для структурі данніх.

// проблема з тим, що масив росте, а по факту даних може не бути, будуть null, а якщо спиратись на довжину, то буде не коректно
//тобто якщо видаляти, то може написати правда, замість неправда і видалити налл

     */
    private    int arrayLenght=3;
    private Integer arrayList[] = new Integer[this.arrayLenght];

    public ArrayListByMyself() {
    }

    public Integer[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(Integer[] arrayList) {
        this.arrayList = arrayList;
    }

    public int getArrayLenght() {
        return arrayLenght;
    }

    public void setArrayLenght(int arrayLenght) {
        this.arrayLenght = arrayLenght;
    }

    public ArrayListByMyself(Integer[] arrayList, int arrayLenght) {
        this.arrayList = arrayList;
        this.arrayLenght = arrayLenght;
    }

    public boolean addElement(int element){
        boolean result = false;

        if (arrayList[arrayLenght-1] != null){
                Integer arrayListTemp[] = new Integer[arrayLenght*2];
                for (int i = 0; i < arrayLenght; i++){
                    arrayListTemp[i] = arrayList[i];
                }
                arrayLenght = arrayLenght*2;
                arrayList = arrayListTemp;
        }
        for (int i = 0; i< arrayLenght; i++){
            if (arrayList[i]==null){
                arrayList[i] = element;
                result = true;
                break;
            }
        }
        if (result) System.out.println("element "+ element+ " is added");
        return result;
    }
    public Integer get(int index){
        if (index >= arrayLenght|| arrayList[index] ==null) System.out.println("the index is larger, than the array's lenght");
        return arrayList[index];
    }
    public void print(){
        for (Integer i : arrayList){
            if (i==null) break;
            else System.out.print(i+ " ");
        }
        System.out.println();
    }
    public boolean contains (int element){
        boolean result = false;
        for(Integer i : arrayList){
            if (i == null) break;
            if (i == element) result = true;
        }
        return result;
    }
    public boolean remove(int index){
        boolean result = false;


        int counter =0;
        for (int i = 0; i< arrayLenght; i++){
            if(arrayList[i]!=null) counter++;
        }
        for (int i = 0; i< counter; i++) {
            arrayList[i] = arrayList[i];
        }
        arrayLenght = counter;
        if (index>= counter) return false;
        Integer arrayListTemp[] = new Integer[counter];
        for (int i = 0; i < counter-1; i++){
             if(i!=index){
                 arrayListTemp[i] = arrayList[i];
             }
        }
        arrayList = arrayListTemp;
        result = true;
        return result;
    }
    public static void main(String[] args) {
        ArrayListByMyself first = new ArrayListByMyself();

        first.addElement(4);
        first.addElement(5);
        first.addElement(6);
        first.addElement(7);

        first.print();

        System.out.println( "The element with index 3 is "+first.get(3));
        System.out.println("The element with index 4 is "+first.get(4));

        System.out.println("the array contains 7  - "+first.contains(7));
        System.out.println("the array contains 9  - "+first.contains(9));

        first.print();
        System.out.println(first.remove(3));
        System.out.println(first.remove(3));

        first.print();
        }
}
