package loopLengthLinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import loopLengthLinkedList.LoopLengthDemo.Node;

public class LoopLengthTest {
	LoopLengthDemo loop = new LoopLengthDemo();

	@Test
	public void shouldReturnLoopCount() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = head.next;

		int actual = loop.countNodesinLoop(head);
		assertEquals(4, actual);
	}

	@Test
	public void shouldReturnZeroIfListIsNull() {

		int actual = loop.countNodesinLoop(null);
		assertEquals(0, actual);
	}

	@Test
	public void shouldReturnZeroIfSecondNodeIsNull() {
		Node head = new Node(1);
		head.next = null;

		int actual = loop.countNodesinLoop(head);
		assertEquals(0, actual);
	}

	@Test
	public void shouldReturnZeroIfListDoesNotContainAnyLoop() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = null;

		int actual = loop.countNodesinLoop(head);
		assertEquals(0, actual);
	}

}
