package cn.kgc.springdemo.printer.page;

public class A4 implements Page {
    @Override
    public String getSize() {
        return "A4";
    }
}
