package Observers;

public interface MyObservable {
	void notifyListeners(String actions);
	void addListener(MyObserver observer);
	void removeListener(MyObserver observer);
}
