import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  private Node head;

  @BeforeEach
  void setUp() {
    head = new Node(1);
    Node first = new Node(2);
    Node second = new Node(3);
    Node third = new Node(4);
    Node fourth = new Node(5);
    Node fifth = new Node(5);
    Node sixth = new Node(5);
    Node seventh = new Node(6);
    Node eighth = new Node(6);
    Node ninth = new Node(7);

    head.next = first;
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    seventh.next = eighth;
    eighth.next = ninth;
  }

  @Test
  void removeDupsV1WithInvalidData() {
    Assertions.assertNull(Main.removeDupsV1(null));
  }

  @Test
  void removeDupsV1() {
    Assertions.assertEquals("1->2->3->4->5->6->7", Main.removeDupsV1(head).toString());
  }

  @Test
  void removeDupsV1WithoutDups() {
    Node first = new Node(2);
    Node second = new Node(3);
    Node third = new Node(4);

    first.next = second;
    second.next = third;

    Assertions.assertEquals("2->3->4", Main.removeDupsV1(first).toString());
  }

  @Test
  void removeDupsV1WithManyOfTheSameValue() {
    Node first = new Node(2);
    Node second = new Node(3);
    Node third = new Node(3);
    Node fourth = new Node(3);
    Node fifth = new Node(3);
    Node sixth = new Node(3);
    Node seventh = new Node(3);
    Node eighth = new Node(3);
    Node ninth = new Node(3);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    seventh.next = eighth;
    eighth.next = ninth;

    Assertions.assertEquals("2->3", Main.removeDupsV1(first).toString());
  }

  @Test
  void removeDupsV2WithInvalidData() {
    Assertions.assertNull(Main.removeDupsV2(null));
  }

  @Test
  void removeDupsV2() {
    Assertions.assertEquals("1->2->3->4->5->6->7", Main.removeDupsV2(head).toString());
  }

  @Test
  void removeDupsV2WithoutDups() {
    Node first = new Node(2);
    Node second = new Node(3);
    Node third = new Node(4);

    first.next = second;
    second.next = third;

    Assertions.assertEquals("2->3->4", Main.removeDupsV2(first).toString());
  }

  @Test
  void removeDupsV2WithManyOfTheSameValue() {
    Node first = new Node(2);
    Node second = new Node(3);
    Node third = new Node(3);
    Node fourth = new Node(3);
    Node fifth = new Node(3);
    Node sixth = new Node(3);
    Node seventh = new Node(3);
    Node eighth = new Node(3);
    Node ninth = new Node(3);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    seventh.next = eighth;
    eighth.next = ninth;

    Assertions.assertEquals("2->3", Main.removeDupsV2(first).toString());
  }
}
