package com.example.track;


public class DataView
{

    String count;
    String name;
    String pack;
    String count1;
    public DataView(String s, String s1, String i)
    {
        pack = s;
        name = s1;
        count = i;
    }
    
 /*   public DataView(String s, String s1, String i)
    {
        pack = s;
        name = s1;
        count1 = i;
    }
*/
    public String getCount()
    {
        return count;
    }

    public String getIdentityName()
    {
        return name;
    }

    public String getPackName()
    {
        return pack;
    }
}
