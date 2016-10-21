package HDacm;


//²»»á

import java.util.Scanner;

public class s1006 {

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        while(true){
            double D=s.nextDouble();
            if(D==-1)
                break;
            double mhmin[]=new double[11];
            double mhmax[]=new double[11];
            for(int i=0;i<11;i++){
                mhmin[i]=(360*i+D)*120/11;
                mhmax[i]=(360*i+360-D)*120/11;
            }
            double smmin[]=new double[708];
            double smmax[]=new double[708];
            for(int i=0;i<708;i++){
                smmin[i]=(360*i+D)/5.9;
                smmax[i]=(360*i+360-D)/5.9;
            }
            double shmin[]=new double[719];
            double shmax[]=new double[719];
            for(int i=0;i<719;i++){
                shmin[i]=(360*i+D)*120/719;
                shmax[i]=(360*i+360-D)*120/719;
            }
            double countTime=0;
            for(int i=0;i<11;i++){
                for(int j=0;j<708;j++){
                    if(smmin[j]<mhmax[i]&&smmax[j]>mhmin[i]){
                        for(int k=0;k<719;k++){
                            if(shmin[k]<smmax[j]&&shmax[k]>smmin[j]){
                                if(shmin[k]<mhmax[i]&&shmax[k]>mhmin[i]){
                                    double min=Max(shmin[k],smmin[j],mhmin[i]);
                                    double max=Min(shmax[k],smmax[j],mhmax[i]);
                                    countTime=countTime+max-min;
                                }
                            }
                        }
                    }
                }
            }
            double percent=countTime/432;
            System.out.printf("%.3f", percent);
            System.out.println();
        }
    }

    private static double Min(double d, double e, double f) {
        // TODO Auto-generated method stub
        double min=0;
        min=d>e?e:d;
        min=min>f?f:min;
        return min;
    }

    private static double Max(double d, double e, double f) {
        // TODO Auto-generated method stub
        double max=0;
        max=d>e?d:e;
        max=max>f?max:f;
        return max;
    }
}