package com.rest.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rest.dao.CustomerDAO;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;

 
@Path("/customers")
public class HelloWorldService {
 
  @GET
  @Produces("text/html")
  public Response getLocalCust() {
 
           String output = "Get Method Rest Services Testing";
           return Response.status(200).entity(output).build();
           
        
  }
 
 /* @GET
  @Path("/nri")
  @Produces("text/html")
  public Response getNriCust() {
 
            String output = "I am from 'getNriCust' method";
            return Response.status(200).entity(output).build();
  }
  
  */
 
      
      @GET
      @Path("{name}/{country}")
      @Produces("text/html")
      public Response getResultByPassingValues(
                      @PathParam("name") String name,
                      @PathParam("country") String country) {
          
          String output = "Customer name - "+name+", Country - "+country+"";
          return Response.status(200).entity(output).build();
   
      }
      
     /* @GET
      @Produces("text/html")
      public Response getResultByPassingValue(
                      @QueryParam("name") String name,
                      @QueryParam("country") String country) {
          
          String output = "Customer name - "+name+", Country - "+country+"";
          return Response.status(200).entity(output).build();
   
      }
	*/
	 
	
	    
	    @POST
	    @Path("/addCustomer")
//	    @Produces("text/html")
	    @Produces("text/xml")
//	    @Produces(MediaType.APPLICATION_JSON)
	  //  @Consumes("text/html")
	    public Customer getResultByPassingValue(
	                    @FormParam("name") String name,
	                    @FormParam("country") String country) {
	    	
	    	 ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
	         CustomerDAO custDao = (CustomerDAO) ac.getBean("customerDao");
	       
	         ///Insert
	         Customer cust = new Customer();        
	            cust .setCustName(name);
	            cust .setCustCountry(country);
	            custDao.save(cust);
	         
	    	
	        
	      /*  String output = "<font face='verdana' size='2'>" +
	                "Web Service has added your Customer information with Name - <u>"+name+"</u>, Country - <u>"+country+"</u></font>";
	        return Response.status(200).entity(output).build();*/
	            
	           return cust;
	 
	    }
	    
	    @GET
	    @Path("/{cusNo}")
	    @Produces(MediaType.APPLICATION_JSON)
	//    @Produces(MediaType.APPLICATION_XML)
	    public Customer produceCustomerDetailsinJSON(@PathParam("cusNo") int no) {
	 
	        Customer cust = new Customer();        
	            cust .setCustNo(no);
	            cust .setCustName("Karim");
	            cust .setCustCountry("India");
	       //     empDao.save(cust);
	            
	        return cust;
	    }
	  
	    
	    

	 /*   @GET
	    @Produces("text/plain")
	    @Path("{id}")
	    public Response getCustomerDetails(@PathParam("id") String custId) {
	        
	         //CODE TO FETCH CUSTOMER DETAILS FROM THE DATABASE USING CUSTOMER ID
	        String output = "Customer Details With ID "+custId+" Has Been fetched Successfully";
	        return Response.status(200).entity(output).build();
	     }
	   */ 
	    @POST
	    @Produces("text/plain")
	    @Path("{id}")
	    public Response insertCustomer(@PathParam("id") String custId) {
	        
	         //CODE TO INSERT CUSTOMER DETAILS USING CUSTOMER ID
	        String output = "Customer Data With ID "+custId+" Has Been Saved Successfully";
	        return Response.status(200).entity(output).build();
	     }
	 
	    @PUT
	    @Produces("text/plain")
	    @Path("{id}")
	    public Response updateCustomerDetails(@PathParam("id") String custId) {
	        
	         //CODE TO UPDATE CUSTOMER DETAILS USING CUSTOMER ID
	        String output = "Customer Data With ID "+custId+" Has Been Updated Successfully";
	        return Response.status(200).entity(output).build();
	     }
	    
	    @DELETE
	    @Produces("text/plain")
	    @Path("{id}")
	    public Response deleteCustomer(@PathParam("id") String custId) {
	        
	         //CODE TO DELETE CUSTOMER DETAILS USING CUSTOMER ID
	        String output = "Customer With ID "+custId+" Has Been Deleted From the Database.";
	        return Response.status(200).entity(output).build();
	     }
	    
	    
	    private static final String FILE_PATH = "C:\\Karim\\INPUT\\Input-Big.txt";  
	    @GET  
	    @Path("/download")  
	    @Produces("text/plain")  
	    public Response getFile() {  
	        File file = new File(FILE_PATH);  
	   
	        ResponseBuilder response = Response.ok((Object) file);  
	        response.header("Content-Disposition","attachment; filename=\"downloaded.txt\"");  
	        return response.build();  
	   
	    }  
	    
	    @POST  
	    @Path("/upload")  
	    @Consumes(MediaType.MULTIPART_FORM_DATA)  
	    public Response uploadFile(  
	            @FormDataParam("file") InputStream uploadedInputStream,  
	            @FormDataParam("file") FormDataContentDisposition fileDetail) {  
	            String fileLocation = "C://Karim//" + fileDetail.getFileName();  
	            try {  
	                FileOutputStream out = new FileOutputStream(new File(fileLocation));  
	                int read = 0;  
	                byte[] bytes = new byte[1024];  
	                out = new FileOutputStream(new File(fileLocation));  
	                while ((read = uploadedInputStream.read(bytes)) != -1) {  
	                    out.write(bytes, 0, read);  
	                }  
	                out.flush();  
	                out.close();  
	            } catch (IOException e) {e.printStackTrace();}  
	            String output = "File successfully uploaded to : " + fileLocation;  
	            return Response.status(200).entity(output).build();  
	        }  
	
}