/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.weblaf;

import com.alee.extended.debug.TestFrame;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.toolbar.WhiteSpace;
//import com.alee.skin.dark.WebDarkSkin;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Admin
 */
public class QuickStart
{
     public static void main ( final String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            public void run ()
            {
//                try {
//                    UIManager.setLookAndFeel ( NimbusLookAndFeel.class.getCanonicalName () );
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(QuickStart.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InstantiationException ex) {
//                    Logger.getLogger(QuickStart.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    Logger.getLogger(QuickStart.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (UnsupportedLookAndFeelException ex) {
//                    Logger.getLogger(QuickStart.class.getName()).log(Level.SEVERE, null, ex);
//                }
               // WebLookAndFeel.install ();

                // You can also specify preferred skin right-away
                WebLookAndFeel.install ( );

                // You can also do that in one of the old-fashioned ways
                // UIManager.setLookAndFeel ( new WebLookAndFeel () );
                // UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
                // UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );
               // WebLookAndFeel.initializeManagers ();
                // Initialize L&F here, before creating any UI

                final JTextArea textArea = new JTextArea ( "Simple text area" );
                final JScrollPane scrollPane = new JScrollPane ( textArea );
                scrollPane.setPreferredSize ( new Dimension ( 300, 150 ) );
                scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
                scrollPane.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );

                final JProgressBar progressBar = new JProgressBar ();
                progressBar.setIndeterminate ( true );

                final JButton ok = new JButton ( "Ok" );
                final JButton cancel = new JButton ( "Cancel" );

                TestFrame.show ( new GroupPanel ( GroupingType.fillFirst, 5, false, scrollPane, progressBar,
                        new GroupPanel ( GroupingType.fillFirst, 5, new WhiteSpace (), ok, cancel ) ), 5 );
            }
        } );
    }
}
