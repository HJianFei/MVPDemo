package com.apecs.im.utils.xmpp;

import com.apecs.im.anyevent.UserEvent;
import com.apecs.im.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;

/**
 * Created by Administrator on 2017/6/27.
 * 描述：用户好友关系类（请求、删除、通过、拒绝、上线、离线）
 */

public class XMPPPresenceListener implements PacketListener {

    @Override
    public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
        if (stanza instanceof Presence) {
            Presence presence = (Presence) stanza;
            //发送方
            String from = presence.getFrom();
            LogUtils.d("onResponse", presence.getType().name());
            LogUtils.d("onResponse", presence.getType().toString());
            //接收方
//            String to = presence.getTo();
            if (presence.getType().equals(Presence.Type.subscribe)) {
                LogUtils.d("onResponse", "请求添加好友：" + from);
                EventBus.getDefault().post(new UserEvent(from + "请求添加好友", 0));
            } else if (presence.getType().equals(Presence.Type.subscribed)) {//对方同意订阅
                EventBus.getDefault().post(new UserEvent(from + "同意你的好友请求", 2));
                LogUtils.d("onResponse", "同意订阅" + from);
            } else if (presence.getType().equals(Presence.Type.unsubscribe)) {//取消订阅
                EventBus.getDefault().post(new UserEvent(from + "从他的好友列表将你移除", 1));
                LogUtils.d("onResponse", "取消订阅" + from);
            } else if (presence.getType().equals(Presence.Type.unsubscribed)) {//拒绝订阅
                EventBus.getDefault().post(new UserEvent(from + "拒绝你的好友请求", 3));
                LogUtils.d("onResponse", "拒绝订阅" + from);
            } else if (presence.getType().equals(Presence.Type.unavailable)) {//离线
                EventBus.getDefault().post(new UserEvent(from + "好友离线啦", 5));
                LogUtils.d("onResponse", "离线" + from);
            } else if (presence.getType().equals(Presence.Type.available)) {//上线
                EventBus.getDefault().post(new UserEvent(from + "好友上线啦", 4));
                LogUtils.d("onResponse", "上线" + from);
            }
        }
    }

}
