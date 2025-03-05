package Data_Structure.LinkedListQueue;
import Interface_form.Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 *
 * @param <E> the type of elements in this Queue
 * @see Queue
 *
 */

public class LinkedListQueue<E> implements Queue<E>, Cloneable {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);

        // 비어있을 경우
        if(size == 0) {
            head = newNode;
        }
        // 그 외의 경우 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 한다.
        else {
            tail.next = newNode;
        }
        /**
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail = newNode;
        size++;
        return true;
    }



    @Override
    public E poll() {

        // 삭제할 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        // 삭제될 요소의 데이터를 반환하기 위한 임시 변수
        E element = head.data;

        // head 노드의 다음노드
        Node<E> nextNode = head.next;

        // head의 모든 데이터들을 삭제
        head.data = null;
        head.next = null;

        // head 가 가리키는 노드를 삭제된 head노드의 다음노드를 가리키도록 변경
        head = nextNode;
        size--;

        return element;
    }

    public E remove() {

        E element = poll();

        if(element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {

        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }
        return head.data;
    }

    public E element() {

        E element = peek();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {

        /**
         * head 데이터부터 x가 null 이 될 때까지 value랑 x의 데이터(x.data)랑
         * 같은지를 비교하고 같을 경우 true를 반환한다.
         */
        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {

        for(Node<E> x = head; x != null; ) {

            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        size = 0;
        head = tail = null;

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
            // Array.newInstance(컴포넌트 타입, 생성할 크기)
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        // 얕은 복사를 위한 s 배열
        Object[] s = a;
        for (Node<E> x = head; x != null; x = x.next)
            s[i++] = x.data;

        return a;
    }


    @Override
    public Object clone() {

        // super.clone() 은 CloneNotSupportedException 예외를 처리해주어야 한다.
        try {
            @SuppressWarnings("unchecked")
            LinkedListQueue<E> clone = (LinkedListQueue<E>) super.clone();	// 새로운 큐 객체 생성
            clone.head = null;
            clone.tail = null;
            clone.size = 0;

            // 내부까지 복사되는 것이 아니기 때문에 내부 데이터들을 모두 복사해준다.
            for(Node<E> x = head; x != null; x = x.next) {
                clone.offer(x.data);
            }
            return clone;

        } catch (CloneNotSupportedException e) {
            throw new Error(e);	// 예외처리는 여러분들이 자유롭게 구성하면 된다.
        }
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
        // 정렬 된 a 배열을 큐로 복사한다.
        for (Node<E> x = head; x != null; x = x.next, i++) {
            x.data = (E) a[i];
        }
    }
}