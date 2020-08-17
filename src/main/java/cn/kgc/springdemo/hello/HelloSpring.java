package cn.kgc.springdemo.hello;

public class HelloSpring {
    private String str="";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    /**
     * 构造注入
     * @param str
     */
    public HelloSpring(String str){
        this.str=str;
    }
    public void show(){
        System.out.println("你好啊!!!"+str);
    }
}
