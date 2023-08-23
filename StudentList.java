import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
    public static String names[];
    public static String studentName;
    public static void main(String[] args)
    {

//		Check arguments

        if(args.length!=1){
            System.out.println("Invalid input");
            return;
        }
        if(args[0].equals("a"))
        {
            System.out.println("Loading data ...");
            try
            {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                studentName = bufferedReader.readLine();
                names = studentName.split(",");
                for(String j : names)
                {
                    System.out.println(j);
                }
            }
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        }
        else if(args[0].equals("r"))
        {
            System.out.println("Loading data ...");
            try
            {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                studentName = bufferedReader.readLine();
                System.out.println(studentName);
                names = studentName.split(",");
                Random x = new Random();
                int y = x.nextInt();
                System.out.println(names);
            }
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("+"))
        {
            System.out.println("Loading data ...");
            try
            {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(d);
                bufferedWriter.write(", "+t+"\nList last updated on "+fd);
                bufferedWriter.close();
            }
            catch (Exception e) {}

            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("?"))
        {
            System.out.println("Loading data ...");
            try
            {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                studentName = bufferedReader.readLine();
                names = studentName.split(",");
                boolean done = false;
                String t = args[0].substring(1);
                for(int idx = 0; idx<names.length && !done; idx++)
                {
                    if(names.equals(t))
                    {
                        System.out.println("We found it!");
                        done=true;
                    }
                }
            }
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("c"))
        {
            System.out.println("Loading data ...");
            try
            {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String D = bufferedReader.readLine();
                char a[] = D.toCharArray();
                boolean in_word = false;
                int count=0;
                for(char c:a)
                {
                    if(c ==' ')
                    {
                        if (!in_word)
                        {
                            count++;
                            in_word =true;
                        }
                        else
                        {
                            in_word=false;
                        }
                    }
                }
                System.out.println(count +" word(s) found " + a.length);
            }
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        }
    }
}
