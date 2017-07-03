package com.apaces.demo.model.user_detail;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.Friend;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.entity.UserDetailResult;
import com.apaces.demo.utils.XMPPLoadThread;
import com.apaces.demo.utils.xmpp.XMPPConnUtils;

import org.jivesoftware.smackx.vcardtemp.packet.VCard;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class UserDetailModelImpl implements UserDetailModel {
    @Override
    public void getUserDetail(Map<String, Object> map, final onFinishListener listener) {
        final String username = (String) map.get("username");
        new XMPPLoadThread() {

            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().getUserInfo(username);
            }

            @Override
            protected void result(Object object) {
                VCard vCard = (VCard) object;
                UserDetailResult userDetail = new UserDetailResult();
                userDetail.setNickname(vCard.getField("nickName"));
                userDetail.setEmail(vCard.getField("email"));
                userDetail.setPhone(vCard.getField("mobile"));
                userDetail.setAvatar(vCard.getField("avatar"));
                BaseResponse<UserDetailResult> response = new BaseResponse<>();
                response.setCode(200);
                response.setMsg("success");
                response.setData(userDetail);
                listener.onFinished(response);

            }
        };


    }

    @Override
    public void delFriend(Map<String, Object> map, final onFinishListener listener) {

        final String username = (String) map.get("username");
        new XMPPLoadThread() {
            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().delFriend(username);
            }

            @Override
            protected void result(Object object) {
                boolean flag = (boolean) object;
                ResultCode resultCode = new ResultCode();
                if (flag) {
                    resultCode.code = 200;
                    resultCode.msg = "success";
                } else {
                    resultCode.code = 201;
                    resultCode.msg = "fault";
                }

                listener.onDelFinished(resultCode);

            }
        };
    }

    @Override
    public void addFriend(Map<String, Object> map, final onFinishListener listener) {
        final String username = (String) map.get("username");
        new XMPPLoadThread() {

            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().addUser(username);
            }

            @Override
            protected void result(Object object) {
                boolean flag = (boolean) object;
                ResultCode resultCode = new ResultCode();
                if (flag) {
                    resultCode.code = 200;
                    resultCode.msg = "success";
                } else {
                    resultCode.code = 201;
                    resultCode.msg = "fault";
                }

                listener.onAddFriendFinished(resultCode);
            }
        };


    }

    @Override
    public void isFriend(Map<String, Object> map, final onFinishListener listener) {

        final String username = (String) map.get("username");
        new XMPPLoadThread() {

            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().getFriends().contains(new Friend(username));
            }

            @Override
            protected void result(Object object) {
                boolean flag = (boolean) object;
                ResultCode resultCode = new ResultCode();
                if (flag) {
                    resultCode.code = 200;
                    resultCode.msg = "success";
                } else {
                    resultCode.code = 201;
                    resultCode.msg = "fault";
                }

                listener.onIsFriendFinished(resultCode);
            }
        };

    }
}
