
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {
    private ArrayList<String> contactName = new ArrayList<>();
    private ArrayList<String> phoneNumber = new ArrayList<>();
    private ArrayList<String[]> checker = new ArrayList<>();
    private String[] contactInfo = new String[2];
    private int userInput;

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber.add(phoneNumber);
    }
    public void setContactName(String contactName){
        this.contactName.add(contactName);
    }
    public ArrayList<String> getPhoneNumber(){
        return phoneNumber;
    }

    public ArrayList<String> getContactName(){
        return contactName;
    }
    private Scanner input = new Scanner(System.in);
    public void createNewContact(){
        System.out.println("Enter Number ");
        String phoneNumber = input.next();
        while(phoneNumber.length() != 11) {
            System.out.println("Enter Valid Number ");
            phoneNumber = input.next();
        }

        System.out.println("Enter Name You want to save contact with ");
        String contactName = input.next();
        System.out.println("""
                [<1>]Save   [<2>]Back
                """);
        int userAnswer = input.nextInt();
            if(userAnswer ==1){
                System.out.println("Contact saved ");
                setPhoneNumber(phoneNumber);
                setContactName(contactName);
                contactInfo[0] = contactName;
                contactInfo[1] = phoneNumber;
                checker.add(contactInfo);
            }else{
                displayMainMenu();
            }
    }

    public boolean search(String contactName){
        boolean condition = false;
        if(this.contactName.contains(contactName)){
            condition = true;
            return condition;
        } else{
            return false;
        }

    }

    public String deleteContact(String contactName){
        String theName = "";
        for(String[] name:checker){
            if(contactName.equals(name[0])){
                theName = name[0];
                checker.remove(name);
                break;
            }
        }
        for(int count = 0;count< this.contactName.size();count++) {
            if (theName.equals(this.contactName.get(count))) {
                this.contactName.remove(count);
                this.phoneNumber.remove(count);
            }
        }
            return "Contact Deleted";
    }

    public String editContactName(String contactName){
        String temp = "";
        String newName = "";
        for(String[] name: checker){
            if(name[0].equals(contactName)){
                 temp = name[0];
                System.out.println("Enter new name to save the contact");
                 newName = input.next();

                name[0] = newName;

                    break;


            }
        }
        for(int count = 0; count<this.contactName.size();count++){
            if(contactName.equals(this.contactName.get(count))){
                this.contactName.set(count,newName);
                break;
            }
        }

        return "Contact Edited";
    }
    public void displayContact(){
        if(contactName.isEmpty()){
            System.out.println("No Contact Saved Yet \n[<1>]Back to Main menu");
            int userAnswer = input.nextInt();
            if(userInput == 1){
                displayMainMenu();
            }

        }else {
            for (String contact : contactName) {
                System.out.println(contact);
            }

                System.out.println("[<1>]Back to Main menu");
                int userAnswer = input.nextInt();
                if(userInput == 1){
                    displayMainMenu();
                }


        }

    }

    public void displayMainMenu(){
        System.out.println();
        System.out.println("""
                [<1>]Display All Contact.
                [<2>]Add New Contact.
                [<3>]Search Contact.
                [<4>]Exit App.
                """);
        userInput = input.nextInt();

    }

    public void operatePhoneApp(){
        do{
            displayMainMenu();
            if(userInput == 1){
                displayContact();
            }
            else if(userInput==2){
                createNewContact();
            }else if(userInput==3) {
                System.out.println("Enter name You Are Searching for ");
                String names = input.next();
               if(search(names)){
                   String outPut = "";
                   String[] name = new String[2];
                   for (int count =0 ; count<checker.size();count++) {
                       name = checker.get(count);
                       if (name[0].equals(names)) {
                           System.out.printf("""
                                   ContactName: %s
                                       
                                       PhoneNumber: %s
                                       
                                       [<1>] delete contact    [<2>] edit Name
                                       
                                       [<3>] back to main menu;
                                       
                                   """, name[0], name[1]);
                           int answer = input.nextInt();
                           if (answer == 1) {
                               System.out.println(deleteContact(names));
                           } else if (answer == 2) {
                               System.out.println(editContactName(names));
                           } else {
                               displayMainMenu();
                           }

                           break;
                       }else{
                           System.out.println(names + "is not on your contactList");
                       }

                   }
               }

            }

        }while(userInput!=4);
    }
}