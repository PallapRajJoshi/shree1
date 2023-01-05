import java.util.Scanner;
public class CQueue {
  int SIZE = 5; // Size of Circular Queue
  int front, rear;
  int items[] = new int[SIZE];

  CQueue() {
    front = -1;
    rear = -1;
  }

  // Check if the queue is full
  boolean isFull() {
    if (front == 0 && rear == SIZE - 1) {
      return true;
    }
    if (front == rear + 1) {
      return true;
    }
    return false;
  }

  // Check if the queue is empty
  boolean isEmpty() {
    if (front == -1)
      return true;
    else
      return false;
  }

  // Adding an element
  void Enqueue(int element) {
    if (isFull()) {
      System.out.println("Queue is full");
    } else {
      if (front == -1)
        front = 0;
      rear = (rear + 1) % SIZE;
      items[rear] = element;
      System.out.println("Inserted " + element);
    }
  }

  // Removing an element
  int Dequeue() {
    int element;
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return (-1);
    } else {
      element = items[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      } /* Q has only one element, so we reset the queue after deleting it. */
      else {
        front = (front + 1) % SIZE;
      }
      return (element);
    }
  }

  void Display() {
    /* Function to display status of Circular Queue */
    int i;
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } else {
      System.out.println("Front -> " + front);
      System.out.println("Items -> ");
      for (i = front; i != rear; i = (i + 1) % SIZE)
        System.out.print(items[i] + " ");
      System.out.println(items[i]);
      System.out.println("Rear -> " + rear);
    }
  }

  public static void main(final String args[]) {
        int choice;
        int data;
        final Scanner sc = new Scanner(System.in);
        final CQueue sl = new CQueue();
    System.out.println("1.Enqueue");
    System.out.println("2.Dequeue");
    System.out.println("3.Display");
    System.out.println("4.Exit");
        do
            {
            System.out.println("Enter Your Choice:");
            choice=sc.nextInt();
            switch(choice)
                {
                case 1:
                System.out.println("Enter data:");
                data=sc.nextInt();
                sl.Enqueue(data);
                break;
                case 2:
                sl.Dequeue();
                break;
                case 3:
                sl.Display();
                break;
                default:
                System.out.println("Invalid Choice..Try Again");
                }
        }while(choice<4);
    }
}
