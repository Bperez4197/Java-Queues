
public class LinkedQueue<T> implements QueueADT<T> {
		private int count;
		private LinearNode<T> front, rear;
		
		public LinkedQueue() {
			count = 0;
			front = rear = null;
		}
		
		public void enqueue (T element) {
			LinearNode<T> node = new LinearNode<T>(element);
			
			if(isEmpty()) {
				front = node;
			}else {
				rear.setNext(node);
			}
			
			rear = node;
			count++;
		}
		
		public T dequeue() throws EmptyCollectionException {
			if(isEmpty()) {
				throw new EmptyCollectionException("queue");
			}else {
				T result = front.getElement();
				front = front.getNext();
				count--;
				if(isEmpty()) {
					rear = null;
				}
				return result;
			}
		}
		
		public int size() {
			return count;
		}
		
		public T first(){
			return front.getElement();
		}
		
		public boolean isEmpty() {
			if(count == 0) {
				return true;
			}else {
				return false;
			}
		}
		
		public String toString() {
			String message = "";
			T node = first();
			for(int i = 0; i < size(); i++) {
				message += first() + " ";
				this.dequeue();
				this.enqueue(node);
			}
			
			return message;
		}
	}