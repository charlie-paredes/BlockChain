/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){
		/*
	* Enqueue method:
    *   if head is null
    *       set head equal to new message
    *       set tail equal to new message
    *   else
    *       set tail's next to new message
    *       set tail equal to new message*/
        P2PMessage newNode = new P2PMessage();
        tail = oMessage;
        newNode.setMessage(tail.getMessage());

        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

		/*
	* Dequeue method:
    *   if head is null
    *       return null
    *   else
    *       set a new message object to head.
    *       set head equal to head's next
    *       return temp object*/
        if (head == null){
            return null;
        }else{
            P2PMessage newMessage = head;
            head = head.next;
            return newMessage;
        }
    }


    public boolean hasNodes(){
        /*
	* HasNodes method:
    *   if head is null
    *       return false
    *   else
    *       return true*/
        if (head == null)
            return false;
        else
            return true;
    }
}

