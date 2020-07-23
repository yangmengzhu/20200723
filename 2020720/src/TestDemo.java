import java.util.*;

public class TestDemo {
    public static void main4(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            String[] arr=str.split(" ");
            StringBuffer ret=new StringBuffer();

            for(int i=arr.length-1;i>0;i--){
                ret.append(arr[i]+" ");
            }
            ret.append(arr[0]);
            System.out.println(ret.toString());
        }

    }
    public static void main8(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            StringBuffer ret=new StringBuffer();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                    ret.append(ch);
                }else{
                    ret.append(' ');
                }
            }
            StringBuffer result=new StringBuffer();
            String[] arr=ret.toString().trim().split(" ");
            for(int i=arr.length-1;i>0;i--){
                if(!arr[i].equals(" ") ){
                    result.append(arr[i]+" ");
                }
            }
            ret.append(arr[0]);
            System.out.println(result.toString());
        }
    }
    //骆驼命名法
    public static void main3(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            String[] arr=str.split("_");
            String ret=arr[0];
            for(int i=1;i<arr.length;i++){
                ret+=(char)(arr[i].charAt(0)-32);
                for(int j=1;j<arr[i].length();j++){
                    ret+=(char)arr[i].charAt(j);
                }
            }
            System.out.println(ret);
        }
    }
    //计算日期到天数的转换
    public static void main2(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int year=scan.nextInt();
            int month=scan.nextInt();
            int day=scan.nextInt();
            int ret=outDay(year,month,day);
            System.out.println(ret);
        }
    }
    private static int outDay(int year,int month,int day){
        int[] arr={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year<=0||month<=0||day<=0||day>arr[month-1]||month>12){
            return -1;
        }
        if((year%4==0&&year%100!=0)||year%400==0){
            arr[1]=29;
        }
        int sum=0;
        for(int i=0;i<month-1;i++){
            sum+=arr[i];
        }
        sum+=day;
        return sum;
    }
    //旋转数组的最小数字
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(right-left==1){
                mid=right;
                break;
            }
            if(array[left]==array[mid]&&array[right]==array[left]){
                int tmp=array[left];
                for(int i=left+1;i<right;i++){
                    if(array[i]<tmp){
                        tmp=array[i];
                    }
                }
                return tmp;
            }
            if(array[mid]>=array[left]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return array[mid];
    }
    //字符串加解密
    public static String encryption(String str){
        char[] ch=str.toCharArray();
        StringBuffer result=new StringBuffer();
        for(int i=0;i<ch.length;i++){
            result.append(encryption(ch[i]));
        }
        return result.toString();
    }
    public static String unEncryption(String str){
        char[] ch=str.toCharArray();
        StringBuffer result=new StringBuffer();
        for(int i=0;i<ch.length;i++){
            result.append(unEncryption(ch[i]));
        }
        return result.toString();
    }
    public static char encryption(char ch){
        if(ch>='0'&&ch<'9'){
            return (char)(ch+1);
        }else if(ch=='9'){
            return '0';
        }else if(ch>='a'&&ch<'z'){
            return (char)(ch+1-32);
        }else if(ch=='z'){
            return 'A';
        }else if(ch>='A'&&ch<'Z'){
            return (char)(ch+1+32);
        }else if(ch=='Z'){
            return 'a';
        }else{
            return ch;
        }
    }
    public static char unEncryption(char ch){
        if(ch>'0'&&ch<='9'){
            return (char)(ch-1);
        }else if(ch=='0'){
            return '9';
        }else if(ch>'a'&&ch<='z'){
            return (char)(ch-1-32);
        }else if(ch=='a'){
            return 'Z';
        }else if(ch>'A'&&ch<='Z'){
            return (char)(ch-1+32);
        }else if(ch=='A'){
            return 'z';
        }else{
            return ch;
        }
    }
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            System.out.println(encryption(str1));
            System.out.println(unEncryption(str2));
        }
    }
    //数字中只出现一次的数字
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int tmp=0;
        for(int i=0;i<array.length;i++){
            tmp^=array[i];
        }
        int pos=0;
        for(;pos<32;pos++){
            if(((tmp>>pos)&1)==1){
                break;
            }
        }
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if(((array[i]>>pos)&1)==1){
                num1[0]=num1[0]^array[i];
            }else{
                num2[0]=num2[0]^array[i];
            }
        }
    }
    //查找兄弟单词
    private static int brother(String point,String word,char[] ch1){
        if(point.length()!=word.length()||point.equals(word)){
            return 0;
        }
        char[] ch=word.toCharArray();
        Arrays.sort(ch);
        return Arrays.equals(ch1,ch)?1:0;
    }
    public static void main6(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            String[] arr=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=scan.next();
            }
            String point=scan.next();
            int index=scan.nextInt();
            char[] ch1=point.toCharArray();
            Arrays.sort(ch1);
            List<String> list=new ArrayList<>();
            int count=0;
            for(int i=0;i<n;i++){
                int x=brother(point,arr[i],ch1);
                count+=x;
                if(x==1){
                    list.add(arr[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if(index<=count){
                System.out.println(list.get(index-1));
            }
        }
    }
    //乒乓球筐
    public static void main7(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            String[] arr=str.split(" ");
            String strA=arr[0];
            String strB=arr[1];
            int[] a=new int[26];
            int[] b=new int[26];
            for(int i=0;i<strA.length();i++){
                a[strA.charAt(i)-'A']++;
            }
            for(int i=0;i<strB.length();i++){
                b[strB.charAt(i)-'A']++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(a[i]<b[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
   //数组中出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        if(array.length==1){
            return array[0];
        }
        int len=array.length/2;
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                int val=map.get(array[i]);
                if(val+1>len){
                    return array[i];
                }else{
                    map.put(array[i],val+1);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<>();
        while(scan.hasNext()){
            String str=scan.next();
            int line=scan.nextInt();
            String[] arr=str.split("\\\\");
            String file=arr[arr.length-1];
            if(file.length()>16){
                file=file.substring(file.length()-16);
            }
            String input=file+" "+line;
            if(!map.containsKey(input)){
                map.put(input,1);
            }else{
                map.put(input,map.get(input)+1);
            }
        }
        int count=0;
        for(String s:map.keySet()){
            count++;
            if(count>map.size()-8){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
}
