package Data_Structure.SinglyLinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import Interface_form.List;	// 리스트 인터페이스가 있는 패키지다.
/**
 *
 *
 * @param <E> the type of elements in this list
 *
 */
public class SLinkedList<E> implements List<E>, Cloneable {

    private Node<E> head; // 노드의 첫 부분
    private Node<E> tail; // 노드의 마지막 부분
    private int size; // 요소 개수

    // 생성자
    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    // 특정 위치의 노드를 반환하는 메소드
    private Node<E> search(int index) {

        // 범위 밖(잘못된 위치)일 경우 예외 던지기
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head; // head부터 시작

        for (int i = 0; i < index; i++) {
            x = x.next; // x노드의 다음 노드를 x에 저장한다.
        }
        return x;
    }

    public void addFirst(E value) {

        Node<E> newNode = new Node<E>(value); // 새 노드 생성
        newNode.next = head; // 새 노드의 다음 노드로 head 노드를 연결
        head = newNode; // head가 가리키는 노드를 새 노드로 변경
        size++;

        /**
         * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우)
         * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
         * 마지막 노드다. 즉 tail = head 다.
         */
        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value); // 새 노드 생성

        if (size == 0) { // 처음 넣는 노드일 경우 addFisrt로 추가
            addFirst(value);
            return;
        }

        /**
         * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, E value) {

        // 잘못된 인덱스를 참조할 경우 예외 발생
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
        if (index == 0) {
            addFirst(value);
            return;
        }
        // 추가하려는 index가 마지막 위치일 경우 addLast 호출
        if (index == size) {
            addLast(value);
            return;
        }

        // 추가하려는 위치의 이전 노드
        Node<E> prev_Node = search(index - 1);

        // 추가하려는 위치의 노드
        Node<E> next_Node = prev_Node.next;

        // 추가하려는 노드
        Node<E> newNode = new Node<E>(value);

        /**
         * 이전 노드가 가리키는 노드를 끊은 뒤
         * 새 노드로 변경해준다.
         * 또한 새 노드가 가리키는 노드는 next_Node로
         * 설정해준다.
         */
        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;

    }

    public E remove() {

        Node<E> headNode = head;

        if (headNode == null)
            throw new NoSuchElementException();

        // 삭제된 노드를 반환하기 위한 임시 변수
        E element = headNode.data;

        // head의 다음 노드
        Node<E> nextNode = head.next;

        // head 노드의 데이터들을 모두 삭제
        head.data = null;
        head.next = null;

        // head 가 다음 노드를 가리키도록 업데이트
        head = nextNode;
        size--;

        /**
         * 삭제된 요소가 리스트의 유일한 요소였을 경우
         * 그 요소는 head 이자 tail이었으므로
         * 삭제되면서 tail도 가리킬 요소가 없기 때문에
         * size가 0일경우 tail도 null로 변환
         */
        if(size == 0) {
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {

        // 삭제하려는 노드가 첫 번째 원소일 경우
        if (index == 0) {
            return remove();
        }

        // 잘못된 범위에 대한 예외
        if (index >= size || size < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index - 1);	// 삭제할 노드의 이전 노드
        Node<E> removedNode = prevNode.next;	// 삭제할 노드
        Node<E> nextNode = removedNode.next;	// 삭제할 노드의 다음 노드

        E element = removedNode.data;	// 삭제되는 노드의 데이터를 반환하기 위한 임시변수

        // 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경
        prevNode.next = nextNode;
        // 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
        if(prevNode.next == null) {
            tail = prevNode;
        }
        // 데이터 삭제
        removedNode.next = null;
        removedNode.data = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {

        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> x = head;	// removedNode

        // value 와 일치하는 노드를 찾는다.
        for (; x != null; x = x.next) {
            if (value.equals(x.data)) {
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        // 일치하는 요소가 없을 경우 false 반환
        if(x == null) {
            return false;
        }

        // 만약 삭제하려는 노드가 head라면 기존 remove()를 사용
        if (x.equals(head)) {
            remove();
            return true;
        }

        else {
            // 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
            prevNode.next = x.next;

            // 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
            if(prevNode.next == null) {
                tail = prevNode;
            }
            x.data = null;
            x.next = null;
            size--;
            return true;
        }
    }


    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {

        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for (Node<E> x = head; x != null; x = x.next) {
            if (value.equals(x.data)) {
                return index;
            }
            index++;
        }
        // 찾고자 하는 요소를 찾지 못했을 경우 -1 반환
        return -1;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null;) {
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }



    public Object clone() throws CloneNotSupportedException {

        @SuppressWarnings("unchecked")
        SLinkedList<? super E> clone = (SLinkedList<? super E>) super.clone();

        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        for (Node<E> x = head; x != null; x = x.next) {
            clone.addLast(x.data);
        }

        return clone;
    }


    public Object[] toArray() {
        Object[] array = new Object[size];
        int idx = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            array[idx++] = (E) x.data;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Arrya.newInstance(컴포넌트 타입, 생성할 크기)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.data;
        }
        return a;
    }

    public void sort() {
        /**
         *  Comparator를 넘겨주지 않는 경우 해당 객체의 Comparable에 구현된
         *  정렬 방식을 사용한다.
         *  만약 구현되어있지 않으면 cannot be cast to class java.lang.Comparable
         *  에러가 발생한다.
         *  만약 구현되어있을 경우 null로 파라미터를 넘기면
         *  Arrays.sort()가 객체의 compareTo 메소드에 정의된 방식대로 정렬한다.
         */
        sort(null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);

        int i = 0;
        for (Node<E> x = head; x != null; x = x.next, i++) {
            x.data = (E) a[i];
        }
    }

}