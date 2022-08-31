package SourceCode;

import java.net.URL;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;

public class Info implements MouseListener
{
    JTextField title=new JTextField();

    JTextArea description=new JTextArea();

    JLabel image=new JLabel();

    JButton next=new JButton();
    JButton previous =new JButton();
    JButton play=new JButton();

    ImageIcon next_icon=new ImageIcon(getClass().getResource("Next_Icon.png"));
    ImageIcon previous_icon=new ImageIcon(getClass().getResource("Previous_Icon.png"));
    ImageIcon display_image1=new ImageIcon(getClass().getResource("PierreBezier.png"));
    ImageIcon display_gif=new ImageIcon(getClass().getResource("BezierAnimation.gif"));
    ImageIcon play_icon=new ImageIcon(getClass().getResource("PlayIcon.png"));

    String text="";

    Color bgc1=new Color(0x0b0c10);
    Color bgc2=new Color(0x1f2833);
    Color text_c1=new Color(0x66fcf1);
    Color text_c2=new Color(0xc5c6c7);

    public void Set_InfoPanel(int panel_width, int panel_height, JPanel info_panel)
    {
        title.setText("Bèzier Curves: What are they?");
        title.setBorder(null);
        title.setBounds(20, 20, 750, 80);
        title.setForeground(text_c2);
        title.setBackground(bgc1);
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));

        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBounds(635, 120, 535, 620);
        description.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        description.setBackground(bgc1);
        description.setForeground(text_c1);
        
        image.setIcon(display_image1);
        image.setHorizontalAlignment(JLabel.CENTER);
        
        info_panel.add(image);
        image.setBounds(80, 170, 535, 500);
        image.setBackground(bgc1);
        
        info_panel.setLayout(null);
        info_panel.setOpaque(true);
        info_panel.setBackground(bgc1);
        info_panel.add(title);
        info_panel.add(description);
        
        info_panel.add(play);
        play.setBounds(317, 680, 100, 100);
        play.setBorderPainted(false);
        play.setIcon(play_icon);
        play.setEnabled(false);
        play.addMouseListener(this);

        info_panel.add(next);
        next.setBounds(1190, 420, 30, 30);
        next.setIcon(next_icon);
        next.setBorderPainted(false);
        next.addMouseListener(this);

        info_panel.add(previous);
        previous.setBounds(30, 420, 30, 30);
        previous.setIcon(previous_icon);
        previous.setBorderPainted(false);
        previous.setEnabled(false);
        previous.addMouseListener(this);

        get_Info(1);
        description.append(text);
    }

    void get_Info(int pn)
    {
        if(pn==1)
        {
            try
            {
                URL path = Info.class.getResource("info1.txt");
                File f = new File(path.getFile());
                FileReader reader=new FileReader(f);
                int letter=reader.read();
                while(letter!=-1)
                {
                    text+=(char)letter;
                    letter=reader.read();
                }
                reader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(pn==2)
        {
            try
            {
                URL path = Info.class.getResource("info2.txt");
                File f = new File(path.getFile());
                FileReader reader=new FileReader(f);
                int letter=reader.read();
                while(letter!=-1)
                {
                    text+=(char)letter;
                    letter=reader.read();
                }
                reader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                URL path = Info.class.getResource("info3.txt");
                File f = new File(path.getFile());
                FileReader reader=new FileReader(f);
                int letter=reader.read();
                while(letter!=-1)
                {
                    text+=(char)letter;
                    letter=reader.read();
                }
                reader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    int index=1;

    @Override
    public void mouseClicked(MouseEvent me)
    {
        if(me.getSource()==next)
        {
            ++index;
            if(index==2)
            {
                previous.setEnabled(true);
                next.setEnabled(true);
                image.removeAll();
                image.setIcon(display_gif);
                image.repaint();
                description.setText("");
                text="";
                get_Info(2);
                description.append(text);
                play.setEnabled(true);
            }
            else
            {
                next.setEnabled(false);
                description.setText("");
                text="";
                get_Info(3);
                description.append(text);
            }
        }
        if(me.getSource()==previous)
        {
            --index;
            if(index==1)
            {
                previous.setEnabled(false);
                next.setEnabled(true);
                image.removeAll();
                image.setIcon(display_image1);
                image.repaint();
                description.setText("");
                text="";
                get_Info(1);
                description.append(text);
                play.setEnabled(false);
            }
            else
            {
                previous.setEnabled(true);
                description.setText("");
                text="";
                get_Info(2);
                description.append(text);
            }
        }
        if(me.getSource()==play)
        {

            image.setIcon(null);
            display_gif.getImage().flush();
            image.setIcon(display_gif);
        }
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
}
