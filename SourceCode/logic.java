package SourceCode;

import java.util.ArrayList;

import javax.swing.JButton;

public class logic 
{
    float lerp(float c1, float c2, float t)
    {
        return(c1+(c2-c1)*t);
    }

    public ArrayList<int[]> get_points(ArrayList<JButton> points, float step)
    {
        ArrayList<int[]> p=new ArrayList<>();
        ArrayList<Float> opx=new ArrayList<>(), opy=new ArrayList<>();
        for(int i=0; i<points.size(); i++)
        {
            opx.add((float)points.get(i).getX());
            opy.add((float)points.get(i).getY());
        }
        ArrayList<Float> cpx=new ArrayList<>(), cpy=new ArrayList<>();
        cpx.addAll(opx); cpy.addAll(opy);
        float t=step, i=0.0f;
        while(i<=1)
        {
            int count=0;
            int n=opx.size();
            while(cpx.size()>1)
            {
                cpx.add(lerp(cpx.get(0), cpx.get(1), i));
                cpx.remove(0);
                cpy.add(lerp(cpy.get(0), cpy.get(1), i));
                cpy.remove(0);
                ++count;
                if(count==n-1)
                {
                    count=0; --n;
                    cpx.remove(0); cpy.remove(0);
                }
            }
            int[] xy=new int[2];
            xy[0]=Math.round(cpx.get(0)); xy[1]=Math.round(cpy.get(0));
            p.add(xy);
            cpx.clear(); cpx.addAll(opx);
            cpy.clear(); cpy.addAll(opy);
            i+=t;
        }
        return(p);
    }
}
