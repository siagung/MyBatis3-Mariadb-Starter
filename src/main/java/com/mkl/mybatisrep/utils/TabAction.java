/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkl.mybatisrep.utils;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;

/**
 *
 * @author lenovo
 */
public class TabAction{
    private boolean forward;

    public TabAction(boolean forward)
    {
        this.forward = forward;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (forward)
            tabForward();
        else
            tabBackward();
    }

    private void tabForward()
    {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.focusNextComponent();
    }

    private void tabBackward()
    {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.focusPreviousComponent();
    }
}
