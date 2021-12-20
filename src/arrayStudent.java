
package studentmanager;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * PACKAGE_NAME
 * Created by hovanduy
 * Date 10/24/2021 - 5:36 PM
 * Description: ...
 */
public class arrayStudent {
    private student[] array;
    private int count;

    public arrayStudent() {
        this.array = null;
        count = 0;
    }

    public student[] getArray() {
        return array;
    }

    public void setArray(student[] array) {
        this.array = array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void growSize() {
        if (this.count < array.length) {
            return;
        }
        student[] temp = new student[this.array.length + 100];
        for (int i = 0; i < this.array.length; i++) {
            temp[i] = this.array[i];
        }
        this.array = temp;
    }

    public int compare(student a, student b) {
        return Integer.valueOf(a.getID()) - Integer.valueOf(b.getID());
    }


    public int addStudent(student stu) {
        if (this.array == null) {
            this.array = new student[100];
            this.count = 0;
        }
        if (this.count == this.array.length) {
            this.growSize();
        }
        for (int i = 0; i < this.count; i++) {
            if (stu.getID().equals(this.array[i].getID())) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại");
                return 0;
            }
        }
        this.array[count] = stu;
        count++;
        this.sortbyID();
        return 1;
    }

    public void removePosition(int pos) {
        student newArray[] = new student[this.array.length - 1];
        if (pos > this.array.length || pos < 0) {
            return;
        }

        for (int i = 0; i < this.array.length - 1; i++) {
            if (i == pos) {
                i++;
                while (i < this.array.length) {
                    newArray[i - 1] = this.array[i];
                    i++;
                }
                break;
            }
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public void updateInfor(student stu){
        int i = 0;
        while (i < this.count) {
            if (array[i].getID().equals(stu.getID())) {
                //update
                array[i] = stu;
                JOptionPane.showMessageDialog(null,"Cập nhật thành công");
                break;
            }
            i++;
        }
    }
    public int findID(String id) {
        int i = 0;
        while (i < this.count) {
            if (array[i].getID().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void delete(String id) {
        int i = 0;
        while (i < this.count) {
            {
                if (array[i].getID().equals(id)) {
                    this.removePosition(i);
                    count--;
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
                    break;
                }
                i++;
            }
        }
    }

    public DefaultTableModel studentList(int option, javax.swing.JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if(this.count == 0) {
            System.out.println("List empty");
            return model;
        }
        
        if(option == 1){
            this.sortbyID();
            for(student element : this.array){
                if(element != null) {
                    Object rowData[] = new Object[6];
                    rowData[0] = element.getID();
                    rowData[1] = element.getName();
                    rowData[2] = element.getGPA();
                    rowData[3] = element.getImage();
                    rowData[4] = element.getAddress();
                    rowData[5] = element.getNote();
                    model.addRow(rowData);
                }
                else{
                    break;
                }
            }
        }
        else{
            this.sortbyGPA();
            for(student element : this.array){
                if(element != null) {
                    Object rowData[] = new Object[6];
                    rowData[0] = element.getID();
                    rowData[1] = element.getName();
                    rowData[2] = element.getGPA();
                    rowData[3] = element.getImage();
                    rowData[4] = element.getAddress();
                    rowData[5] = element.getNote();
                    model.addRow(rowData);
                }
                else{
                    break;
                }
            }
        }
        return model;
    }
    public static String[] loadfileconfig(){
        String config[] = new String[3];
        BufferedReader br;
        try
        {

            br = new BufferedReader(new FileReader("config.txt"));
            int i= 0 ;
            while(true){
                String str = br.readLine();
                if(str == null){
                    break;
                }
                config[i] = str;
                i++;
            }
            br.close();
        }
        catch(IOException exc)
        {
        }
        return config;
    }

    public static int save(arrayStudent arr){
        String config[] = loadfileconfig();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+ config[0]+ ";user=" + config[1]+ ";password=" + config[2]);
            if(con!=null) {
                System.out.println("Connection Successful!");
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM student");
                for(int i = 0 ; i < arr.getCount(); i++){
                    st.executeUpdate("INSERT INTO student " + "VALUES ('"+ arr.array[i].getID() + "',N'" + arr.array[i].getName() + "'," + arr.array[i].getGPA() + ",N'"
                            + arr.array[i].getImage() + "',N'" + arr.array[i].getAddress() + "',N'" + arr.array[i].getNote()+"')");
                }
            }
            con.close();

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lưu không thành công");
            return 0;
        }
        return 1;
    }
    


    public static arrayStudent load(){
        arrayStudent arr = new arrayStudent();
        String config[] = loadfileconfig();
        
        System.out.println(config[0] +" " +  config[1] +" " + config[2]);
        //Connection
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+ config[0]+ ";user=" + config[1]+ ";password=" + config[2]);
            if(con!=null) {
                System.out.println("Connection Successful!");
                String strCommand = "Select * from student";

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(strCommand);

                while (rs.next()) {
                    student stu_new = new student(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6));
                    arr.addStudent(stu_new);
                }
                  
            }
            JOptionPane.showMessageDialog(null, "Mở thành công");
            con.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Mở không thành công");
        }
        return arr;
    }

    public static boolean checkNamefile(String str){
        int flag = str.indexOf(".csv");
        if(flag != -1){
            return true;
        }
        return false;
    }
    public static void Export(arrayStudent arr, String name_file) {
        FileWriter fw;
        if(checkNamefile(name_file) == false){
            name_file += ".csv";
        }
        try
        {
            fw = new FileWriter(name_file);
            for(int i = 0 ; i < arr.getCount(); i++){
                String str = arr.array[i].getID() + "," + arr.array[i].getName() + "," + arr.array[i].getGPA() + ","
                        + arr.array[i].getImage() + ",\"" + arr.array[i].getAddress() + "\"," + arr.array[i].getNote() + "\n";
                fw.write(str);
            }
            JOptionPane.showMessageDialog(null, "Export thành công");
            fw.close();
        }
        catch(IOException exc)
        {
            JOptionPane.showMessageDialog(null, "Export thất bại");
        }

    }

    public static arrayStudent Import(String name_file){
        arrayStudent arr = new arrayStudent();
        BufferedReader br;
        if(checkNamefile(name_file) == false){
            name_file += ".csv";
        }
        try
        {
            br = new BufferedReader(new FileReader(name_file));
            while(true){
                String str = br.readLine();
                if(str == null){
                    break;
                }
                student stu_new = student.ParseString(str);

                if(stu_new.getID() != ""){
                    arr.addStudent(stu_new);
                }
            }
            JOptionPane.showMessageDialog(null, "Import thành công");
            br.close();
            return arr;
        }
        catch(IOException exc)
        {
            JOptionPane.showMessageDialog(null, "Import thất bại");
        }

        return arr;
    }

    public void sortbyID(){
        for(int i = 0 ; i < this.count - 1;i++){
            for(int j = i + 1; j < this.count;j++){
                if(Integer.valueOf(array[i].getID()) > Integer.valueOf(array[j].getID())){
                    student temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void sortbyGPA(){
        for(int i = 0 ; i < this.count - 1;i++){
            for(int j = i + 1; j < this.count;j++){
                if(array[i].getGPA() > array[j].getGPA()){
                    student temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}


