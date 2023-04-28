import java.util.HashSet;
import java.util.Set;

/**
 * For this challenge, we'll assume a simple singly liked list like the following:
 *
 * public class Node {
 *   public Node next;
 *   public int data;
 *
 *   public Node(int data) {
 *     this.data = data;
 *   }
 *
 *   @Override
 *   public String toString() {
 *     StringBuilder sb = new StringBuilder();
 *
 *     Node nextNode = next;
 *
 *     sb.append(data);
 *
 *     while (nextNode != null) {
 *       sb.append("->");
 *
 *       sb.append(nextNode.data);
 *
 *       nextNode = nextNode.next;
 *     }
 *
 *     return sb.toString();
 *   }
 * }
 */
public class Main {

  /**
   * Write code to remove duplicates from an unsorted linked list.
   *
   * For this challenge, we'll use <b>Set</b> to store all the unique values and each time we visit a node with existing value
   * -> we delete it.
   *
   * We'll use a similar method as in (link to DeleteNodeInLinkedList) for checking the next node from the current one,
   * so it's easier to delete the repeating ones.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static Node removeDupsV1(Node node) {
    if (node == null) {
      return null;
    }

    Node n = node;

    Set<Integer> values = new HashSet<>();
    values.add(n.data);

    while (n.next != null) {
      if (!values.contains(n.next.data)) {
        values.add(n.next.data);
        n = n.next;
      } else {
        n.next = n.next.next;
      }
    }

    return node;
  }

  /**
   * This version solves the challenge without the usage of temporary buffer.
   *
   * In this approach we'll start by iterating the elements from left to right and for each visited one
   * we'll pass through the elements on its right side and remove each duplicate we find. There won't be a need to check the elements on its left (if any)
   * as by deleting them on the right side, we guarantee that no such value will be found as we proceed to the next steps. Few considerations:
   *
   * <ol>
   *   <li>We need to return the head node at the end, so it needs to be saved</li>
   *   <li>Once all nodes on the right of a concrete one are visited, we need to move to the next main node</li>
   * </ol>
   *
   * Time Complexity: O(N^2)
   * Space Complexity: O(1)
   */
  public static Node removeDupsV2(Node n) {
    if (n == null) {
      return null;
    }

    Node head = n;
    Node runner;

    // Until all the unique value nodes are visited
    while (n != null) {
      runner = n;

      // Checks if there are duplicates
      while (runner.next != null) {
        // If such is found -> replace pointers
        if (runner.next.data == n.data) {
          runner.next = runner.next.next;
        } else {
          // If not -> get the next one
          runner = runner.next;
        }
      }

      // move to the next main node
      n = n.next;
    }

    // The initial node with modified points (if duplicates)
    return head;
  }
}
