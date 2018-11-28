package com.lanmei.ouqi.event;

import com.lanmei.ouqi.bean.AddressListBean;

import java.util.List;

/**
 * Created by xkai on 2018/10/23.
 *
 */

public class AddressListEvent {

    private List<AddressListBean> list;

    public List<AddressListBean> getList() {
        return list;
    }

    public AddressListEvent(List<AddressListBean> list) {
        this.list = list;
    }
}
