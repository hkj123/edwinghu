package com.springboot.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.applet.*;
import java.awt.*;

public class AppletController extends Applet{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void paint (Graphics g)
    {
        g.drawString ("Hello World", 25, 50);
    }
}
