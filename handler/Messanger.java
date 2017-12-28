package handler;

import message.IMessage;
import message.Message;

import java.util.ArrayList;

/**
 * Created by Артём on 28.12.2017.
 */
public class Messanger implements IMessanger {
    private IHandler mHandler;
    private ArrayList<IMessage> mMessages;

    public Messanger(IHandler handler) {
        mHandler = handler;
        mMessages = new ArrayList<IMessage>();
    }

    @Override
    public void send(IMessage message) {
        mHandler.accept(message);
    }
}
