/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Student implements Comparable<Student>{
     String name;
     int rank;
    public Student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }
    
    @Override
    public int compareTo(Student s2){
        return this.rank - s2.rank;
    }
}
public class Main
{
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		PriorityQueue<Student> que = new PriorityQueue<>();//PriorityQueue<>(Comparator.reverseOrder())->Prints out in reverse order 
		que.add(new Student("Spider man",12));
		que.add(new Student("Iron man",3));
		que.add(new Student("Bat man",1));
		que.add(new Student("Super man",2));
		while(!que.isEmpty())
		{
		    System.out.println(que.peek().name+"->"+que.peek().rank);
		    que.remove();
		}

	}
}