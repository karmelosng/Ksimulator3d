/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karmelos.ksimulator.view.swing;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.karmelos.ksimulator.model.SimComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author jumoke
 */
public class CustomJFrame extends JFrame implements  WindowListener{
  private LwjglAWTCanvas lac;
  private List<SimComponent> listing;
  View vv;
    public CustomJFrame(List<SimComponent> listed) throws HeadlessException, IOException {
        this.setIconImage(ImageIO.read(this.getClass().getResource("/com/karmelos/ksimulator/2ndbaricon/kicon.png")));
        this.setTitle("3D-View");
        
           listing= listed;
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        vv = new View(listing);
        lac= new LwjglAWTCanvas(vv, true);
        contentPane.add(lac.getCanvas(),BorderLayout.CENTER);
        
        pack();
        setVisible(true);       
        setSize(600, 500); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent we) {
       
    }

    @Override
    public void windowClosing(WindowEvent we) {
//lac = null;
        System.out.println("destroyed in closing");
       //this.setVisible(false);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        System.out.println("destroyed in closed");
//        vv.dispose();
    }

    @Override
    public void windowIconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 
}
