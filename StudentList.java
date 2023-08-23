import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
    public static String names[];
    public static String studentName;
    public static Constant constant = new Constant();
    public static void Reader() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(constant.FILE_NAME)));
            studentName = bufferedReader.readLine();
            names = studentName.split(constant.SPLIT);
        } catch (Exception e) {
        }
    }

    public static void Writer(String updatedText) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(constant.FILE_NAME, true));//here true means it will be available after write a string here...
                     bufferedWriter.write(updatedText);
                      bufferedWriter.close();
        } catch (Exception e) {
        }
    }


    public static void main(String[] args)
    {

//		Check arguments

        if(args.length!=1){
            System.out.println(constant.INVALID);
            return;
        }
        if(args[0].equals(constant.SHOW_DATA))
        {
            System.out.println(constant.LOADING);
            Reader();
                for(String j : names)
                {
                    System.out.println(j);
                }

            System.out.println(constant.LOADED);
        }
        else if(args[0].equals(constant.RANDOM))
        {
            System.out.println(constant.LOADING);
            Reader();
                Random x = new Random();
                int y = x.nextInt();
                System.out.println(names);
            System.out.println(constant.LOADED);
        }


        else if(args[0].contains(constant.ADD_DATA))
        {
            System.out.println(constant.LOADING);
            Reader();

                String t = args[0].substring(1);
                Date d = new Date();
                String df = constant.DATE_FORMATE;
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(d);
                Writer(constant.SPLIT+t+constant.ListLastUpdated+fd);
            System.out.println(constant.LOADED);
        }


        else if(args[0].contains(constant.QUERY))
        {
            System.out.println(constant.LOADING);
              Reader();
                names = studentName.split(constant.SPLIT);
                boolean done = false;

                String t = args[0].substring(1);
                for(int idx = 0; idx<names.length && !done; idx++)
                {
                    if(names[idx].equals(t))
                    {
                        System.out.println(constant.FOUND);
                        done=true;
                    }
                }

            System.out.println(constant.LOADED);
        }
        else if(args[0].contains(constant.COUNT))
        {
            System.out.println(constant.LOADING);
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
                System.out.println(count +constant.WORDS_FOUND + a.length);

            System.out.println(constant.LOADED);
        }
    }
}
