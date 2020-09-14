package 其他;

public class Test {
    static String[] handleRgba(String s){
        String rgba[] = new String[4];
        rgba = s.substring(5,s.length()-1).split(",");
        String res[] = new String[2];
        res[1] = rgba[3];
        res[0] = "#";
        for(int i=0;i<3;i++){
            rgba[i]=Integer.toString(Integer.parseInt(rgba[i]),16);
            res[0]+=rgba[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "rgba(255, 255, 255, 0.4)";
        System.out.println(handleRgba(s));
    }
}
