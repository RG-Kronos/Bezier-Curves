import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window implements MouseListener
{
    JFrame frame=new JFrame();

    int panel_width=1350, panel_height=840;

    JPanel main_panel=new JPanel();
    JPanel display_panel=new JPanel();
    JPanel menubar=new JPanel();
    JPanel home_panel=new JPanel();
    JPanel info_panel=new JPanel();
    JPanel run_panel=new JPanel();

    JButton home=new JButton();
    JButton info=new JButton();
    JButton run=new JButton();
    JButton exit=new JButton();
    
    String cwd=System.getProperty("user.dir");

    ImageIcon home_icon=new ImageIcon(cwd+"/images/HomeIcon.png");
    ImageIcon info_icon=new ImageIcon(cwd+"/images/InfoIcon.png");
    ImageIcon run_icon=new ImageIcon(cwd+"/images/RunIcon.png");
    ImageIcon exit_icon=new ImageIcon(cwd+"/images/ExitIcon.png");

    Color bgc1=new Color(0x0b0c10);
    Color bgc2=new Color(0x1f2833);
    Color text_c1=new Color(0x66fcf1);
    Color text_c2=new Color(0xc5c6c7);

    Home home_obj=new Home();
    Info info_obj=new Info();
    Run run_obj=new Run();

    public void Set_MenuBar()
    {
        menubar.setBackground(bgc2);
        menubar.setLayout(null);

        menubar.add(home);
        menubar.add(info);
        menubar.add(run);
        menubar.add(exit);

        home.setIcon(home_icon);
        home.setHorizontalAlignment(JButton.CENTER);
        home.setBorderPainted(false);
        home.setBounds(25, 290, 50, 50);
        home.setFocusable(false);
        home.addMouseListener(this);

        info.setIcon(info_icon);
        info.setHorizontalAlignment(JButton.CENTER);
        info.setBorderPainted(false);
        info.setBounds(25, 360, 50, 50);
        info.setFocusable(false);
        info.addMouseListener(this);

        run.setIcon(run_icon);
        run.setHorizontalAlignment(JButton.CENTER);
        run.setBorderPainted(false);
        run.setBounds(25, 430, 50, 50);
        run.setFocusable(false);
        run.addMouseListener(this);

        exit.setIcon(exit_icon);
        exit.setHorizontalAlignment(JButton.CENTER);
        exit.setBorderPainted(false);
        exit.setBounds(25, 500, 50, 50);
        exit.setFocusable(false);
        exit.addMouseListener(this);

    }

    public void Set_Panel()
    {
        Set_MenuBar();
        home_obj.Set_HomePanel(panel_width, panel_height, home_panel);
        info_obj.Set_InfoPanel(panel_width, panel_height, info_panel);
        run_obj.Set_RunPanel(panel_width, panel_height, run_panel);

        main_panel.setPreferredSize(new Dimension(panel_width, panel_height));
        main_panel.setLayout(null);
        main_panel.add(menubar);
        main_panel.add(display_panel);
        display_panel.setBounds(100, 0, panel_width-100, panel_height);
        display_panel.setLayout(null);
        home_panel.setBounds(0, 0, panel_width-100, panel_height);
        info_panel.setBounds(0, 0, panel_width-100, panel_height);
        run_panel.setBounds(0, 0, panel_width-100, panel_height);
        display_panel.add(home_panel);
        menubar.setBounds(0, 0, 100, panel_height);
    }

    public void Set_Frame()
    {
        Set_Panel();
        frame.add(main_panel);
        frame.setTitle("Bèzier Curves");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        if(me.getSource()==home)
        {
            display_panel.remove(info_panel);
            display_panel.remove(run_panel);
            display_panel.add(home_panel);
            display_panel.repaint();
        }
        if(me.getSource()==info)
        {
            display_panel.remove(home_panel);
            display_panel.remove(run_panel);
            display_panel.add(info_panel);
            display_panel.repaint();
        }
        if(me.getSource()==run)
        {
            display_panel.remove(home_panel);
            display_panel.remove(info_panel);
            display_panel.add(run_panel);
            display_panel.repaint();
        }
        if(me.getSource()==exit)
        {
            frame.dispose();
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource()==home)
        {
            home.setBounds(0, home.getY(), 100, 50);
            home.setText("HOME");
            home.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            home.setIcon(null);
            home.setForeground(text_c1);
            home.setOpaque(true);
            home.setBackground(bgc1);
        }
        if(me.getSource()==info)
        {
            info.setBounds(0, info.getY(), 100, 50);
            info.setText("INFO");
            info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            info.setIcon(null);
            info.setForeground(text_c1);
            info.setOpaque(true);
            info.setBackground(bgc1);
        }
        if(me.getSource()==run)
        {
            run.setBounds(0, run.getY(), 100, 50);
            run.setText("RUN");
            run.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            run.setIcon(null);
            run.setForeground(text_c1);
            run.setOpaque(true);
            run.setBackground(bgc1);
        }
        if(me.getSource()==exit)
        {
            exit.setBounds(0, exit.getY(), 100, 50);
            exit.setText("EXIT");
            exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            exit.setIcon(null);
            exit.setForeground(text_c1);
            exit.setOpaque(true);
            exit.setBackground(bgc1);
        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource()==home)
        {
            home.setBounds(25, home.getY(), 50, 50);
            home.setText("");
            home.setIcon(home_icon);
            home.setBackground(bgc2);
        }
        if(me.getSource()==info)
        {
            info.setBounds(25, info.getY(), 50, 50);
            info.setText("");
            info.setIcon(info_icon);
            info.setBackground(bgc2);
        }
        if(me.getSource()==run)
        {
            run.setBounds(25, run.getY(), 50, 50);
            run.setText("");
            run.setIcon(run_icon);
            run.setBackground(bgc2);
        }
        if(me.getSource()==exit)
        {
            exit.setBounds(25, exit.getY(), 50, 50);
            exit.setText("");
            exit.setIcon(exit_icon);
            exit.setBackground(bgc2);
        }
    }
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public static void main(String[] args) 
    {
        Window obj=new Window();
        obj.Set_Frame();
    }
}
