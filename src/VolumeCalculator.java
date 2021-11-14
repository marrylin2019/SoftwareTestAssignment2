public class VolumeCalculator {
    public static int getVolume(int L,int W,int H)
    {
        int tiji;
        if(L<2||L>100||W<5||W>200||H<20||H>80)
        {
            tiji=0;
        }
        else
        {
            tiji=L*W*H;
        }
        return tiji;
    }

}
