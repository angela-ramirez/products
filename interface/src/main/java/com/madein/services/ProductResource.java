/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madein.services;

import com.google.common.io.Files;
import com.madein.ecommerce.domain.Image;
import com.madein.ecommerce.domain.Product;
import com.madein.ecommerce.domain.ProductAttribute;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author oiprado
 */
@Path("Products")
@RequestScoped
public class ProductResource {


    public ProductResource() {
    }

    
    @GET
    @Path("collections/{language}/{country}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getCollections(@PathParam("language") String language, @PathParam("country") String country) throws IOException{
        
        List<Product> products = new ArrayList<>();
        
        Product p1 = new Product();
        
        p1.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p1.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));
        
        File px1 = new File("/root/NetBeansProjects/interface/src/main/webapp/resources/images/photo1.jpg");
        
        p1.getImages().add(new Image(Files.toByteArray(px1), "photo1", "jpg", "6,9 kB"));
        
        Product p2 = new Product();
        
        p2.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p2.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));
        
        File px2 = new File("/root/NetBeansProjects/interface/src/main/webapp/resources/images/photo2.jpg");
        
        p2.getImages().add(new Image(Files.toByteArray(px2), "photo2", "jpg", "6,9 kB"));
        
        Product p3 = new Product();
        
        p3.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p3.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));
        
        File px3 = new File("/root/NetBeansProjects/interface/src/main/webapp/resources/images/photo3.jpg");
        
        p3.getImages().add(new Image(Files.toByteArray(px3), "photo3", "jpg", "6,9 kB"));
        
        Product p4 = new Product();
        
        p4.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p4.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));
        
        File px4 = new File("/root/NetBeansProjects/interface/src/main/webapp/resources/images/photo1.jpg");
        
        p4.getImages().add(new Image(Files.toByteArray(px4), "photo4", "jpg", "6,9 kB"));
        
        Product p5 = new Product();
        
        p5.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p5.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));
        
        File px5 = new File("/root/NetBeansProjects/interface/src/main/webapp/resources/images/photo1.jpg");
        
        p5.getImages().add(new Image(Files.toByteArray(px5), "photo5", "jpg", "6,9 kB"));
        
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        
        return products;
    }
    
    

}