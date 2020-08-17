package cn.kgc.springdemo.printer;

import cn.kgc.springdemo.printer.ink.Ink;
import cn.kgc.springdemo.printer.page.Page;

public class SuperPrinter {
    private Ink ink;
    private Page page;
    public void print(){
        int num=(int) (Math.random()*10);
        if(num%2==0){
            //当随机数被2整除的时候抛出异常，检查异常增强方法是否能够正常的工作
            throw new RuntimeException("随机数是一个偶数"+num);
        }
        System.out.println("打印机正在用"+ink.getColor()+"颜色的墨"+page.getSize()+"纸上打印着小猪佩奇");
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
