import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
    public static String names[];
    public static String studentName;

    public static void Reader() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            studentName = bufferedReader.readLine();
            names = studentName.split(",");
        } catch (Exception e) {
        }
    }

    public static void Writer(String updatedText) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("students.txt", true));
                     bufferedWriter.write(updatedText);
                      bufferedWriter.close();
        } catch (Exception e) {
        }
    }


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
            Reader();
                for(String j : names)
                {
                    System.out.println(j);
                }

            System.out.println("Data Loaded.");
        }
        else if(args[0].equals("r"))
        {
            System.out.println("Loading data ...");
            Reader();
                Random x = new Random();
                int y = x.nextInt();
                System.out.println(names);
            System.out.println("Data Loaded.");
        }


        else if(args[0].contains("+"))
        {
            System.out.println("Loading data ...");
            Reader();

                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(d);
                Writer(", "+t+"\nList last updated on "+fd);
            System.out.println("Data Loaded.");
        }


        else if(args[0].contains("?"))
        {
            System.out.println("Loading data ...");
              Reader();
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

            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("c"))
        {
            System.out.println("Loading data ...");
            Reader();
                char a[] = studentName.toCharArray();
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

            System.out.println("Data Loaded.");
        }
    }
}
