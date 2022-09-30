import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Run extends JPanel implements MouseListener, MouseMotionListener
{
    Color bgc1=new Color(0x0b0c10);
    Color bgc2=new Color(0x1f2833);
    Color bgc3=new Color(0x45a29e);
    Color text_c1=new Color(0x66fcf1);
    Color text_c2=new Color(0xc5c6c7);

    JButton acp=new JButton();
    JButton rcp=new JButton();
    JButton ap1=new JButton();
    JButton ap2=new JButton();
    JButton run=new JButton();

    // JTextField run=new JTextField();

    ImageIcon cp_icon=new ImageIcon(getClass().getResource("cp_icon.png"));
    ImageIcon ap_icon=new ImageIcon(getClass().getResource("ap_icon.png"));

    ArrayList<JButton> points=new ArrayList<>();

    public void setButtons()
    {
        acp.setText("ADD CONTROL POINT");
        acp.addMouseListener(this);
        acp.setOpaque(true);
        acp.setForeground(text_c1);
        acp.setBackground(bgc2);
        acp.setBorder(BorderFactory.createLineBorder(text_c2, 1));
        acp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        rcp.setText("REMOVE CONTROL POINT");
        rcp.addMouseListener(this);
        rcp.setOpaque(true);
        rcp.setForeground(text_c1);
        rcp.setBackground(bgc2);
        rcp.setBorder(BorderFactory.createLineBorder(text_c2, 1));
        rcp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        run.setText("DRAG POINTS TO MOVE THEM");
        run.setOpaque(true);
        run.setForeground(text_c1);
        run.setBackground(bgc2);
        run.setBorder(BorderFactory.createLineBorder(text_c2, 1));
        run.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        run.setHorizontalAlignment(JTextField.CENTER);
        run.addMouseListener(this);
    }

    public void Set_RunPanel(int panel_width, int panel_height, JPanel run_panel)
    {
        run_panel.setLayout(null);
        run_panel.setOpaque(true);
        run_panel.setBackground(bgc1);

        setButtons(); setAnchorPoints();

        run_panel.add(acp);
        run_panel.add(rcp);
        run_panel.add(run);
        run_panel.add(this);

        this.setLayout(null);
        this.setBounds(50, 150, 1150, 640);
        this.setBackground(bgc2);
        this.setBorder(BorderFactory.createLineBorder(text_c2, 1));
        this.add(ap1); 
        this.add(ap2);
        this.addMouseListener(this);
        ap1.setBounds(50, 320, 20, 20);
        ap2.setBounds(1100, 320, 20, 20);

        acp.setBounds(50, 25, 370, 100); 
        run.setBounds(440, 25, 370, 100);
        rcp.setBounds(830, 25, 370, 100);
    }

    public void setAnchorPoints()
    {
        ap1.setIcon(ap_icon);
        ap1.setBorderPainted(false);
        ap1.addMouseMotionListener(this);
        ap1.addMouseListener(this);

        ap2.setIcon(ap_icon);
        ap2.setBorderPainted(false);
        ap2.addMouseMotionListener(this);
        ap2.addMouseListener(this);
    }

    boolean acp_active=false;
    boolean rcp_active=false;
    boolean run_active=false;

    public void mouseClicked(MouseEvent me)
    {
        if(me.getSource()==acp)
        {
            if(acp_active==false)
            {
                acp.setForeground(bgc1);
                acp.setBackground(text_c1);
                acp_active=true;
            }
            else
            {
                acp.setForeground(text_c1);
                acp.setBackground(bgc2);
                acp_active=false;
            }
        }
        if(me.getSource()==rcp)
        {
            if(rcp_active==false)
            {
                rcp.setForeground(bgc1);
                rcp.setBackground(text_c1);
                rcp_active=true;
            }
            else
            {
                rcp.setForeground(text_c1);
                rcp.setBackground(bgc2);
                rcp_active=false;
            }
        }
        if(acp_active && me.getSource()==this)
        {
            JButton cp=new JButton();
            int x=me.getX(), y=me.getY();
            cp.setBorderPainted(false);
            cp.setIcon(cp_icon);
            cp.addMouseMotionListener(this);
            cp.addMouseListener(this);
            this.add(cp);
            cp.setBounds(x-10, y-10, 20, 20);
            points.add(cp);
            repaint();
        }
        for(int i=0; i<points.size(); i++)
        {
            if(rcp_active && me.getSource()==points.get(i))
            {
                remove(points.get(i));
                points.remove(i);
                repaint();
            }
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource()==acp && acp_active==false)
        {
            acp.setBackground(bgc3);
        }
        if(me.getSource()==rcp && rcp_active==false)
        {
            rcp.setBackground(bgc3);
        }
        if(me.getSource()==run)
        {
            run.setBackground(bgc3);
        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource()==acp && acp_active==false)
        {
            acp.setBackground(bgc2);
        }
        if(me.getSource()==rcp && rcp_active==false)
        {
            rcp.setBackground(bgc2);
        }
        if(me.getSource()==run)
        {
            run.setBackground(bgc2);
        }
    }

    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    
    public void mouseDragged(MouseEvent me)
    {
        if(me.getSource()==ap1)
        {
            int x=me.getX(), y=me.getY();
            ap1.setLocation(ap1.getX()+x-10, ap1.getY()+y-10);
            repaint();
        }
        if(me.getSource()==ap2)
        {
            int x=me.getX(), y=me.getY();
            ap2.setLocation(ap2.getX()+x-10, ap2.getY()+y-10);
            repaint();
        }
        for(int i=0; i<points.size(); i++)
        {
            if(me.getSource()==points.get(i))
            {
                int x=me.getX(), y=me.getY();
                points.get(i).setLocation(points.get(i).getX()+x-10, points.get(i).getY()+y-10);
                repaint();
            }
        }
    }
    public void mouseMoved(MouseEvent me){}

    logic obj=new logic();

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(text_c1);

        ArrayList<JButton> p=new ArrayList<>();
        p.add(ap1);
        for(JButton i: points)
        {
            p.add(i);
        }
        p.add(ap2);

        for(int i=0; i<p.size()-1; i++)
        {
            int x1=p.get(i).getX()+10;
            int y1=p.get(i).getY()+10;
            int x2=p.get(i+1).getX()+10;
            int y2=p.get(i+1).getY()+10;

            g2d.drawLine(x1, y1, x2, y2);
        }
        
        float step=0.03125f;
        ArrayList<int[]> lp=new ArrayList<>();
        lp=obj.get_points(p, step);
        for(int i=0; i<lp.size()-1; i++)
        {
            int x1=lp.get(i)[0]+10;
            int y1=lp.get(i)[1]+10;
            int x2=lp.get(i+1)[0]+10;
            int y2=lp.get(i+1)[1]+10;

            g2d.drawLine(x1, y1, x2, y2);
        }

    }
}
