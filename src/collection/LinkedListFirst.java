package collection;
// недостатки связного списка по сравнению с массивом:
// больше памяти, т к нужны указатели
//отсутствует локальность памяти, как в массиве, где данные идут один за другим, а тут непонятно, куда джава положит следующие данные
public class LinkedListFirst {
    // попытаемся создать связанный список - структура,
    // где есть элемент(нода node - узел), есть следующий элемент и есть указатель с предыдущего на следующего
    public static void main(String[] args) {
        /* начальные пробы, пока не было отдельного класса LinkedList, дальше
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.next = node2;
        node2.next = node3;*/
        var linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);

        linkedList.print();
    }
}
class LinkedList{
    private Node root; //сcылка на первый элемент
    private Node last; // ссылка на последний элемент
    // обе они постоянно передвигаются по мере добавлени элементов в связанный список

    public boolean add (int data){
        if (root == null){
            root = new Node(data);
            last = root;
        }
        else{
            last.next = new Node(data);
            last = last.next;
        }
        return true;
    }
    public void print(){
        var current = root;
        while (current != null){
            System.out.println(current.payload);
            current = current.next;
        }
    }
}
class Node{
    // класс узел (нода), поле payload - полезная нагрузка, по сути то, где мы будем хранить информацию
    int payload;
    // поле, по сути рекурсивная структура, ссылка на следующего
    Node next;

    public Node(int payload) {
        this.payload = payload;
    }
}


