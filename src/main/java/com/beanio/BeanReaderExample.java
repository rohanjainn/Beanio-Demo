package com.beanio;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

public class BeanReaderExample {

	public static void main(String[] args) throws Exception {
       
		BeanReaderExample beanReaderExample=new BeanReaderExample();
		beanReaderExample.dosome();
    }
	
	public void dosome()
	{
		 
        try{
        	String res="Joe,Smith,Developer,75000,10012009";
        	  StreamFactory factory = StreamFactory.newInstance();
        	  InputStream InputStream=new ByteArrayInputStream(res.getBytes());
        	 factory.load("beanio.xml");
            URL url=this.getClass().getResource(res);
            // use a StreamFactory to create a BeanReader
            //BeanReader in = factory.createReader("employeeFile", new InputStreamReader(InputStream));
            
            File f=new File("E:/BeanIo/Employee.txt");
            
            java.net.URL url2 = getClass().getResource("Employee.txt");
            File f2 = new File(url2.getPath());
            
            InputStream ip=new FileInputStream(f2);
            
           
            
            BeanReader in = factory.createReader("employeeFile", new InputStreamReader(ip));
            Employee employee;
            while ((employee = (Employee) in.read()) != null) {
               System.out.println(employee.getFirstName());
               System.out.println(employee.getSalary());
            }
            in.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
}
