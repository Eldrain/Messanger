package handler;

import message.IMessage;
import message.Message;

import java.util.LinkedList;

/**
 * Created by Артём on 28.12.2017.
 */
public abstract class Handler implements IHandler {
    LinkedList<Message> mQueue;

    public Handler() {
        mQueue = new LinkedList<Message>();
    }

    @Override
    public void handle() {
        synchronized (mQueue) {
            if(!mQueue.isEmpty()) {
                handle(mQueue.removeFirst());
            }
        }
    }

    @Override
    public IMessanger getMessanger() {
        return new Messanger(this);
    }

    @Override
    public void accept(Message message) {
        synchronized (mQueue) {
            mQueue.push(message);
        }
    }
}
