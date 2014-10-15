package a;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {
private String name;
private String success;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String execute() {
name = "Hello, " + name + "!"; 
return success;
}
}