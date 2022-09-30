import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home 
{
    JLabel title_label=new JLabel();

    JTextField title1=new JTextField();
    JTextField title2=new JTextField();
    
    JPanel line=new JPanel();

    Color bgc1=new Color(0x0b0c10);
    Color bgc2=new Color(0x1f2833);
    Color text_c1=new Color(0x66fcf1);
    Color text_c2=new Color(0xc5c6c7);

    ImageIcon title_bg=new ImageIcon(getClass().getResource("Title_BG.png"));

    public void Set_HomePanel(int panel_width, int panel_height, JPanel home_panel)
    {
        home_panel.setLayout(null);
        home_panel.add(title_label);
        title_label.add(title1); title_label.add(title2); title_label.add(line); 
        title1.setBounds(275, 280, 440, 175);
        title2.setBounds(575, 470, 440, 175);

        title_label.setBounds(0, 0, panel_width-100, panel_height);
        title_label.setIcon(title_bg);

        title1.setText("Bèzier"); title2.setText("Curves");
        title1.setBackground(bgc1); title2.setBackground(bgc1);
        title1.setForeground(text_c1); title2.setForeground(text_c1);
        title1.setBorder(null); title2.setBorder(null);
        title1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
        title2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));

        line.setBounds(275, 465, 740, 5);
        line.setOpaque(true);
        line.setBackground(text_c1);
    }

}
