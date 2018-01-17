package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public double extractMax(){
		double value=top();
		tab.remove(0);
		heapSize--;
		return value;
	}

	public void deleteMax(){
		//double value2=top();
		tab.remove(0);
		heapSize--;
	}

	public Heap heapify(double tab[]){
		Heap newHeap=new Heap();
		for(int i=0;i<tab.length;i++){
			newHeap.insert(tab[i]);

		}
		return newHeap;

	}
	public void replace(double old_,double new_){
		deleteMax();
		insert(new_);
	}

	public Heap merge(Heap one, Heap two){
		Heap toReturn=new Heap();
		toReturn=one;
		for(int i=0; i <two.getTab().size(); i++){
			toReturn.insert(two.getTab().get(i));
		}
		return toReturn;
	}


	public Heap meld(Heap two ){
		for(int i=0;i<two.getTab().size();i++){
			this.insert(two.getTab().get(i));
		}

		return this;
	}

	public ArrayList<Double> getTab() {
		return tab;
	}
}
