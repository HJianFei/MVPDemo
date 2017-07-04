package com.apecs.im.utils;

import android.graphics.Bitmap;

import com.apecs.im.utils.xmpp.XMPPConnUtils;

import org.jivesoftware.smackx.vcardtemp.packet.VCard;

public class ImgConfig {

    public static Bitmap showHeadImg(String username) {

        if (username == null) {
            return null;
        }
        VCard vCard = XMPPConnUtils.getInstance().getUserInfo(username);
        if (vCard != null) {
            String avatar = vCard.getField("avatar");
            if (avatar != null) {
                return ImageUtil.getBitmapFromBase64String(avatar);
            }
        }
        return null;

    }
}
