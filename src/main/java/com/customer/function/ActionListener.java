package com.customer.function;

import javafx.event.ActionEvent;

import java.util.EventListener;

/**
 * @className: ActionListener
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/9/30
 **/
public interface ActionListener extends EventListener {
    public void actionPerformed(ActionEvent event);
}
