package learningStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    // @Test
    public void regular(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Dheeraj");
        names.add("Rushi");
        names.add("Ayush");
        names.add("Akash");
        names.add("Ajay");

        int count=0;
        for(int i=0;i<names.size();i++){
            String name=names.get(i);
            if(name.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }
    @Test
    public void StreamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Dheeraj");
        names.add("Rushi");
        names.add("Ayush");
        names.add("Akash");
        names.add("Ajay");

        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);


        //Now as we have manually take the list and doing operations
        //but we can create the same with streams lets see that

        long count2=Stream.of("Dheeraj", "Rushi", "Ayush", "Akash", "Ajay").filter(s -> s.startsWith("A")).count();
        System.out.println(count2);

        //To print the all elements of stream we have less lines of code
        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        //Also we can limit the number of output we want to print.
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

    }
    @Test
    public void streamMap(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Abhay");
        names.add("Arush");
        names.add("Rinku");
        names.add("Raj");
        names.add("Ravi");

        //we have to take the names ending with "a" and than printing the results in uppercase only.

        Stream.of("Dheeraj", "Rushia", "Ayusha", "Akasha", "Ajay").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        List<String> names1= Arrays.asList("Dheeraj", "Rushia", "Ayusha", "Akasha", "Ajay");

        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        //Now what if we have to merge the 2 list into one.

        Stream<String> mergedStream=Stream.concat(names.stream(), names1.stream());
       // mergedStream.forEach(s -> System.out.println(s));
        //What if we want to check weather the specific name is present in the list or not.

       boolean flag= mergedStream.anyMatch(s -> s.equalsIgnoreCase("Raj"));

        System.out.println(flag);
        Assert.assertTrue(flag);


    }
    @Test
    public  void streamCollect(){
        //This is the example like we have to store the newly created list based on conditions using stream.
        List<String> list=Stream.of("Dheeraj", "Rushia", "Ayusha", "Akasha", "Ajay").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());


        //One simple assignment
        // we have list of numbers and we have to take only unique numbers and print them in shorted order

        List<Integer> values=Arrays.asList(2,33,4,22,3,3,23,4,4,23,2,2,65,7,4,347,824,4,53,12);

        values.stream().sorted().distinct().forEach(s-> System.out.println(s));

    }
}

