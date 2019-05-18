class Solution2 {
    private static String TAG = "Solution2";
	public static void main(String[] args){
        Solution2 s2 = new Solution2();
	/*
        * char[] letters = {'c', 'f', 'j'}; char target = 'f';
         * System.out.println(s2.nextGreatestLetter(letters,target));
         */
        //s2.zjcode();
        //s2.ins();
        s2.testNetflixKey();
	//通过反射获取类名
	Class c1 = s2.getClass();
	System.out.println("c1: " + c1.getName());
	Class c2 = Solution2.class;
	System.out.println("c2: " + c2.getName());
	//通过反射获取构造器（分有参数和无参数）
	
	//通过反射获取类属性

	//通过反射获取类方法
	}
    private void testNetflixKey(){
        String dangalPCorr = "NFANDROID2-PRV-VOLVER-MGK000000000000066,pjLYLFwdD6znKIBNSxO2KA==,fDR5KMWu56xRiiGUYzzgzSvgfYiar+8szGldvL0+EIg=";
        //String esnid = "NFANDROID2-PRV-VOLVER-MGK000000000000051";
        //String kpekph = "YT4i0S9h3Fugt9PohUuJzA==,mzp/yOFOuEcftnzRr5CsNVaPV3vgutEd4b+l/bdeScE=";
        //param = changeStringtoAscII(Param)
        //String dangalP = changeStringtoAscII("78,70,65,78,68,82,79,73,68,50,45,80,82,86,45,86,79,76,86,69,82,45,77,71,75,48,48,48,48,48,48,48,48,48,48,48,48,48,54,54,44,112,106,76,89,76,70,119,100,68,54,122,110,75,73,66,78,83,120,79,50,75,65,61,61,44,102,68,82,53,75,77,87,117,53,54,120,82,105,105,71,85,89,122,122,103,122,83,118,103,102,89,105,97,114,43,56,115,122,71,108,100,118,76,48,43,69,73,103,61");
        String dangalP = "78,70,65,78,68,82,79,73,68,50,45,80,82,86,45,86,79,76,86,69,82,45,77,71,75,48,48,48,48,48,48,48,48,48,48,48,48,48,54,54,44,112,106,76,89,76,70,119,100,68,54,122,110,75,73,66,78,83,120,79,50,75,65,61,61,44,102,68,82,53,75,77,87,117,53,54,120,82,105,105,71,85,89,122,122,103,122,83,118,103,102,89,105,97,114,43,56,115,122,71,108,100,118,76,48,43,69,73,103,61";
        System.out.println("dangalP: \"" + dangalP + "\"");
        String dangals[] = dangalP.split(",44,");
        String esnid = dangals[0];
        String kpekph = dangalP.substring(esnid.length() + 4, dangalP.length());
        System.out.println("esnid : \"" + esnid + "\"");
        System.out.println("kpekph : \"" + kpekph + "\"");
        System.out.println("esnid ascii: \"" + changeStringtoAscII(esnid) + "\"");
        System.out.println("kpekph ascii: \"" + changeStringtoAscII(kpekph) + "\"");
        System.out.println("netflix key: \"" + dangalPCorr + "\"");
        byte[] e = changeStringToByte(esnid);
        byte[] k = changeStringToByte(kpekph);
        for (int i = 0; i < e.length; i++){
            System.out.print(e[i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < k.length; i++){
            System.out.print(k[i] + " ");
        }
        System.out.print("\n");
    }
    private String changeStringtoAscII(String src){
        int dest_byte;
        String dest = "";
        String[] srcs = null;
        srcs = src.split(",");
        for(int i = 0; i < srcs.length ; i++){
            //System.out.println("srcs[" + i + "] = [" + srcs[i] + "]");
            if(srcs[i] != null && srcs[i].matches("[0-9]+")){
                dest_byte = Integer.parseInt(srcs[i]);
                dest += (char)dest_byte;
            }else{
                //System.out.println("paras is abnormal <" + srcs[i] + ">");
            }
        }
        return dest;
    }
    private byte[] changeStringToByte(String src){
        String srcs[] = src.split(",");
        byte dest[] = new byte[srcs.length];
        for(int i = 0; i < srcs.length; i++){
            dest[i] = (byte)Integer.parseInt(srcs[i]);
        }
        return dest;
    }
    /*private void Testcode()
    {
        String a1 = "[0xff6344bc] = 0x40000000";
        String a2 = "[0xff6344c0] = 0xE0023F80";
        String a3 = "[0xff634454] = 0xFFFFDCE7";
        String a4 = "[0xff634458] = 0xFFFFDCEF";
        long b1 = Long.valueOf(a1.substring(a1.length() - 8, a1.length()), 16);
        long b2 = Long.valueOf(a2.substring(a2.length() - 8, a2.length()), 16);
        long b3 = Long.valueOf(a3.substring(a3.length() - 8, a3.length()), 16);
        long b4 = Long.valueOf(a4.substring(a4.length() - 8, a4.length()), 16);
        System.out.println(a1 + " 设置gpio为普通gpio: old " + b1);
        System.out.println(a2 + " 设置gpio为普通gpio: old " + b2);
        System.out.println(a3 + " 设置gpio为输出: old " + b3);
        System.out.println(a4 + " 标记拉高或者拉低: old " + b4);
        int i1 = ~(1 << 16 | 1 << 14);
        int i2 = ~(1 << 31 | 1 << 25 | 1 << 29 | 1 << 23 | 1 << 21);
        int i3 = ~(1 << 2 | 1);
        int i4 = 1 << 2;
        //对b进行位运算
        b1 = b1 & i1;
        b2 = b2 & i2;
        b3 = b3 & i3;
        b4 = b4 | 1;//0 拉高
        long b5 = b4 & (~1);//0 拉低
        long b6 = b4 | i4;//2 拉高
        long b7 = b4 & (~i4);// 2 拉低 

        System.out.println(a1 + ": new " + b1);
        System.out.println(a2 + ": new " + b2);
        System.out.println(a3 + ": new " + b3);
        System.out.println(a4 + ": new " + b4);
        System.out.println(a2 + ": new " + b5);
        System.out.println(a3 + ": new " + b6);
        System.out.println(a4 + ": new " + b7);

        String c1 = "0x" + Long.toHexString(b1);
        String c2 = "0x" + Long.toHexString(b2);
        String c3 = "0x" + Long.toHexString(b3);
        String c4 = "0x" + Long.toHexString(b4);
        String c5 = "0x" + Long.toHexString(b5);
        String c6 = "0x" + Long.toHexString(b6);
        String c7 = "0x" + Long.toHexString(b7);
        System.out.println(a1 + " 设置gpio为普通gpio: " + c1);
        System.out.println(a2 + " 设置gpio为普通gpio: " + c2);
        System.out.println(a3 + " 设置gpio为输出: " + c3);
        System.out.println(a4 + " 0拉高: " + c4);
        System.out.println(a4 + " 0拉低: " + c5);
        System.out.println(a4 + " 2拉高: " + c6);
        System.out.println(a4 + " 2拉低: " + c7);
        
        
    }
    private void ins(){
        String s = "0x01 0x01";
        String[] s1 = s.split(" ");
        s = s1[0] + "/" + s1[1];
        System.out.println(s1[0]);
        System.out.println(s1[1]);
        System.out.println(s);
    }

    private void vcomTest(){
        String value = "0x920x00x00x00x00x00x00x00x00x0";
        //String buf = value.substring(2, 4);
        //byte ret = (byte)0xff;
        byte[] ret = new byte[5];
        String[] result = value.split("0x");
        for(int i = 0; i < 5; i++){
            //System.out.println(result[i] + ",");
            ret[i] = (byte)Integer.parseInt(result[i + 1], 16);
            System.out.println(ret[i] + ",");
        }
        //System.out.println(ret);
    }*/

    /*public static int OxStringtoInt(String ox) throws Exception {
        ox=ox.toLowerCase();
        if(ox.startsWith("0x")){
            ox=ox.substring(2, ox.length() );
        }
        int ri = 0;
        int oxlen = ox.length();
        if (oxlen > 8)
            throw (new Exception("too lang"));
        for (int i = 0; i < oxlen; i++) {
            char c = ox.charAt(i);
            int h;
            if (('0' <= c && c <= '9')) {
                h = c - 48;
            } else if (('a' <= c && c <= 'f'))
            {
                h = c - 87;
 
            }
            else if ('A' <= c && c <= 'F') {
                h = c - 55;
            } else {
                throw (new Exception("not a integer "));
            }
            byte left = (byte) ((oxlen - i - 1) * 4);
            ri |= (h << left);
        }
        return ri;
 
    }*/
    /* public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    } */

//i2cset -f -y 2 0x20 0x16 0xb5
//i2cget -f -y 2 0x20 0x16
/*
    private byte readVcom(String para) {
        // String ret = null;
        byte ret = (byte) 0xff;
        String value = "";
        // Log.i(TAG, "read Vcom: " + para);

        String config = "readVcom";
        // Log.v(TAG, config);
        if (para != null) {
            String cmd = "i2cget," + para + ",>,/data/vcom";
            // Log.i(TAG, "readVcom cmd is: " + cmd);
            value = "0xb5";
            // Log.i(TAG, "Vcom data result : " + value); 
            if (!value.equals("")) {
                try {
                    value = value.substring(2,4);
                    ret = (byte)Integer.parseInt(value, 16);
                    System.out.println("ret = "+ret);
                } catch (NumberFormatException e) {
                    // Log.e(TAG, "Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
    */
}
