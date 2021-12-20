package studentmanager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Created by hovanduy
 * Date 10/24/2021 - 4:40 PM
 * Description: ...
 */
public class student {
    private String ID;
    private String name;
    private float GPA;
    private String image;
    private String address;
    private String note;

    public student(){
        this.ID = "";
        this.name = "";
        this.GPA = 0;
        this.image = "";
        this.address = "";
        this.note = "";
    }

    public student(String id, String name, float GPA, String image , String address, String note){
        this.ID = id;
        this.name = name;
        this.GPA = GPA;
        this.image = image;
        this.address = address;
        this.note = note;
    }

    public static student input() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        student stu = new student();
        String str;
        float GPA;
        try {
            System.out.print("ID: ");
            str = scanner.nextLine();
            stu.setID(str);
            System.out.print("name: ");
            str = scanner.nextLine();
            stu.setName(str);
            System.out.print("GPA: ");
            GPA = scanner.nextFloat();
            stu.setGPA(GPA);
            str = scanner.nextLine();
            System.out.print("image: ");
            str = scanner.nextLine();
            stu.setImage(str);
            System.out.print("address: ");
            str = scanner.nextLine();
            stu.setAddress(str);
            System.out.print("note: ");
            str = scanner.nextLine();
            stu.setNote(str);
        }
        catch (InputMismatchException exc){
            System.out.println("Input fail.Try again!");
            return new student();
        }
        return stu;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString(){
        String str = this.ID + "\t" + this.name + "\t" + this.GPA + "\t"
                + this.image + "\t" + this.address + "\t" + this.note + "\n";
        return str;
    }

    public void output(){
        System.out.printf("%-5s %-20s %.2f \t %-25s %-50s %s \n",this.ID,this.name,this.GPA,this.image,this.address,this.note);
    }

    public static student ParseString(String str){
        student stu = new student();
        if(str.equals("")) return stu;
        String[] arrStr = str.split(",");
        if(arrStr.length < 5) return stu;
        if(arrStr[0] != ""){
            stu.setID(arrStr[0]);
        }
        if(arrStr[1] != ""){
            stu.setName(arrStr[1]);
        }
        if(arrStr[2] != ""){
            stu.setGPA(Float.valueOf(arrStr[2]));
        }
        if(arrStr[3] != ""){
            stu.setImage(arrStr[3]);
        }
        if(arrStr[4] != ""){
            String add = arrStr[4];
            for(int i = 5 ;i < arrStr.length  - 1;i++){
                if(arrStr[i] != "") {
                    add += "," + arrStr[i];
                }
            }
            add = add.replace("\"","");
            stu.setAddress(add);
        }
        if(arrStr[arrStr.length - 1] != ""){
            stu.setNote(arrStr[arrStr.length - 1]);
        }
        return stu;
    }
}


