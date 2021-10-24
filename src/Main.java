import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Random rand = new Random();
	    MyHashMap<String, char[]> hashMap = new MyHashMap<>();

        hashMap.debug();

        String[] arr = new String[50];
        String c = "abcdefghijklmnopqrstuvwxyz";
        String temp = "";

        for(int i = 0;i<arr.length;i++)
        {
            int a = rand.nextInt(11)+14;
            int b = rand.nextInt(10);
            temp = c.substring(b,a);
            //System.out.println(a+", "+b+", "+temp);
            hashMap.put(temp,makeCharArr(temp));
            if(temp.length()%2 == 0)
                hashMap.put(temp,makeCharArr(temp));
        }

        hashMap.debug();
        System.out.println(hashMap.size());
        hashMap.clear();
        System.out.println(hashMap.size());
        hashMap.debug();
    }

    public static char[] makeCharArr(String s)
    {
        char[] c = new char[s.length()];
        for(int i=0;i<s.length();i++)
            c[i] = s.charAt(i);
        return c;
    }
}
