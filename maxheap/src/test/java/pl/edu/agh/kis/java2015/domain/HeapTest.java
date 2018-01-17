package pl.edu.agh.kis.java2015.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}
	@Test
	public void extractMax() {

		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);

		assertEquals(6,heap.extractMax(),0.001);

	}

	@Test
	public void deleteMax() {

		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		heap.deleteMax();
		assertEquals(5,heap.top(),0.001);
		heap.deleteMax();
		assertEquals(3,heap.top(),0.001);


	}
	@Test
	public void replace() {

		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		heap.replace(heap.top(),7);
		assertEquals(7,heap.top(),0.001);
		heap.replace(heap.top(),9);
		assertEquals(9,heap.top(),0.001);

	}

	@Test
	public void heapify(){

		Heap heap = new Heap();
		double[] tab={1.0,2.0,3.0};
		assertEquals(3,heap.heapify(tab).top(),0.001);
		Heap heap2 = new Heap();
		double[] tab2={11.0,22.0,31.0};
		assertEquals(31,heap2.heapify(tab2).top(),0.001);


	}

	@Test
	public void merge(){
		Heap heap = new Heap();
		Heap heap2 = new Heap();
		heap2.insert(0);
		heap2.insert(2);
		heap2.insert(3);
		heap2.insert(5);
		heap2.insert(6);

		Heap heap3 = new Heap();
		heap3.insert(0);
		heap3.insert(2);
		heap3.insert(3);
		heap3.insert(5);
		heap3.insert(100);
		assertEquals(100,heap.merge(heap2,heap3).top(),0.001);

	}
	@Test
	public void meld(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		Heap heap2 = new Heap();
		heap2.insert(7);
		heap2.insert(8);
		heap2.insert(9);
		heap2.insert(11);
		heap2.insert(12);
		assertEquals(12,heap.meld(heap2).top(),0.001);

		Heap heap3 = new Heap();
		heap3.insert(0);
		heap3.insert(2);
		heap3.insert(3);
		heap3.insert(5);
		heap3.insert(100);
		assertEquals(100,heap.meld(heap3).top(),0.001);




	}

}



